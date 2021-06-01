package com.example.contactapp.Admin;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.contactapp.Models.QuanLy;
import com.example.contactapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ManagerInfo extends AppCompatActivity {



    DatabaseReference database;
    Dialog dialog;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_manager);

        Bundle extras=getIntent().getExtras();
        EditText nameManager=findViewById(R.id.editTextName);
        EditText mailManager=findViewById(R.id.editTextMailManager);
        EditText phoneManager=findViewById(R.id.editTextPhoneManager);







        database= FirebaseDatabase.getInstance().getReference("QuanLy");
        dialog=new Dialog(ManagerInfo.this);
        database.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //list=new ArrayList<>();

                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    //  Lop lop=dataSnapshot.getValue(Lop.class);
                    QuanLy quanLy=dataSnapshot.getValue(QuanLy.class);
                    quanLy.setId(dataSnapshot.getKey());
                    String getId=quanLy.getId();
                    String checkId=extras.getString("IdManager");

                    Boolean check=getId.equals(checkId);

                    if(check==true)
                    {


                        nameManager.setText(quanLy.getName());
                        phoneManager.setText(quanLy.getPhone());
                        mailManager.setText(quanLy.getEmail());


                    }








                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        Button btnSave=findViewById(R.id.btnOkSure);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Boolean name=nameManager.getText().toString().equals("");
                Boolean mail=mailManager.getText().toString().equals("");
                Boolean phone=phoneManager.getText().toString().equals("");

                if(name==false&& mail==false&& phone==false)
                {
                    String path=extras.getString("IdManager");

                    database.child(path).child("name").setValue(nameManager.getText().toString());
                    database.child(extras.getString("IdManager")).child("phone").setValue(phoneManager.getText().toString());
                    database.child(extras.getString("IdManager")).child("email").setValue(mailManager.getText().toString());
                    Toast.makeText(getApplicationContext(),"Sửa đổi thành công",Toast.LENGTH_LONG).show();


                }
                else Toast.makeText(getApplicationContext(),"Bạn chưa nhập thông tin đầy đủ", Toast.LENGTH_LONG).show();


            }
        });
        Button btnCancle=findViewById(R.id.btnCancleSure);
        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), ListManager.class);
                v.getContext().startActivity(intent);
            }
        });
        Button btnDelete=findViewById(R.id.btnDeleteManager);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialogSure();
            }
        });
        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(), ListManager.class);
                v.getContext().startActivity(intent);

            }
        });















    }
    private void openDialogSure(){
        dialog.setContentView(R.layout.dialogsure);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Button btnOk=dialog.findViewById(R.id.btnOkSure);
        Button btnCancle =dialog.findViewById(R.id.btnCancleSure);
        dialog.show();

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle extras=getIntent().getExtras();
                database.child(extras.getString("IdManager")).setValue(null);

                Intent intent=new Intent(v.getContext(), ListManager.class);
                v.getContext().startActivity(intent);

            }
        });

        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();


            }
        });



    }








}
