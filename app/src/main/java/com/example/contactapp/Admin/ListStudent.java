package com.example.contactapp.Admin;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactapp.Admin.Adapter.AdapterClass;
import com.example.contactapp.Admin.Adapter.AdapterStudent;
import com.example.contactapp.Models.Lop;
import com.example.contactapp.Models.SinhVien;
import com.example.contactapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListStudent extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterStudent adapter;
    ArrayList<SinhVien> list;

    DatabaseReference database;
    Dialog dialog;

    private AdapterClass.RecyclerVieWClickListener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class_list);
        TextView className=findViewById(R.id.txtNameClass);
        dialog=new Dialog(ListStudent.this);


        Bundle extras=getIntent().getExtras();

        className.setText(extras.getString("key"));








        database= FirebaseDatabase.getInstance().getReference("SinhVien");
        recyclerView=findViewById(R.id.rvListStudent);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<>();
        adapter= new AdapterStudent(this,list);
        recyclerView.setAdapter(adapter);
        database.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //list=new ArrayList<>();

                for (DataSnapshot dataSnapshot:snapshot.getChildren()){

                    SinhVien sinhVien=dataSnapshot.getValue(SinhVien.class);
                    sinhVien.setId(dataSnapshot.getKey());
                    String a=sinhVien.getLop();
                    String b=className.getText().toString();
                    if(a!=null){
                        Boolean check=a.equals(b);

                        if(check==true) {

                            list.add(sinhVien);
                        }



                    }
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        Button btnAddStudent=findViewById(R.id.btnAddStudent);
        btnAddStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialogAddStudent();

            }
        });























    }
    public void openDialogAddStudent(){
        dialog.setContentView(R.layout.dialog_addstudent);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        EditText editTextNameStudent=dialog.findViewById(R.id.editTextNameStudent);
        EditText editTextMailStudent=dialog.findViewById(R.id.editTextEmailStudent);
        EditText editTextMssvStudent=dialog.findViewById(R.id.editTextMssv);
        EditText editTextAddrStudent=dialog.findViewById(R.id.editTextAddressStudent);
        EditText editTextPhoneStudent=dialog.findViewById(R.id.EditTextPhoneStudent);


        Button btnSave=dialog.findViewById(R.id.btnSaveAddStudent);
        Button btnCancle =dialog.findViewById(R.id.btnCancleAddStudent);
        dialog.show();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean checkName=editTextNameStudent.getText().toString().equals("");
                Boolean checkAddr=editTextAddrStudent.getText().toString().equals("");
                Boolean checkPhone=editTextPhoneStudent.getText().toString().equals("");
                Boolean checkMssv=editTextMssvStudent.getText().toString().equals("");
                Boolean checkEmail=editTextMailStudent.getText().toString().equals("");




                if(checkName==false && checkAddr==false && checkEmail==false&& checkMssv==false && checkPhone==false)
                {

                    TextView className=findViewById(R.id.txtNameClass);
                    String classname=className.getText().toString();
                    FirebaseDatabase db=FirebaseDatabase.getInstance();


                    DatabaseReference node1=db.getReference("SinhVien");


                    SinhVien sinhVien=new SinhVien(editTextNameStudent.getText().toString(),classname,editTextAddrStudent.getText().toString(),
                            editTextPhoneStudent.getText().toString(),editTextMailStudent.getText().toString(),editTextMssvStudent.getText().toString());
                    list.clear();
                    node1.push().setValue(sinhVien);

                    editTextNameStudent.setText("");
                    editTextPhoneStudent.setText("");
                    editTextAddrStudent.setText("");
                    editTextMailStudent.setText("");
                    editTextMssvStudent.setText("");







                    Toast.makeText(getApplicationContext(), "Thông tin đã được thêm", Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(getApplicationContext(), "Bạn chưa nhập thông tin", Toast.LENGTH_SHORT).show();
            }
        });

        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();


            }
        });

    }



//
//



}
