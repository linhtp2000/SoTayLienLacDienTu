package com.example.contactapp.Admin;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactapp.Admin.Adapter.AdapterManager;
import com.example.contactapp.Models.QuanLy;
import com.example.contactapp.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListManager  extends AppCompatActivity {
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private ChildEventListener mChildListener;

    RecyclerView recyclerView;
    AdapterManager adapter;
    ArrayList<QuanLy> list;
    DatabaseReference  database;

    private AdapterManager.RecyclerVieWClickListener listener;
    Dialog dialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listmanager);


        Button btnAddManager=findViewById(R.id.btnAddManager);
        dialog=new Dialog(ListManager.this);


        recyclerView=findViewById(R.id.rvManager);
        database= FirebaseDatabase.getInstance().getReference().child("QuanLy");





        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<>();

        adapter= new AdapterManager(this,list, listener);
        recyclerView.setAdapter(adapter);
        database.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //list=new ArrayList<>();
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){

                    QuanLy quanLy =dataSnapshot.getValue(QuanLy.class);

                    quanLy.setId(dataSnapshot.getKey());


                    list.add(quanLy);

                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        btnAddManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialogAddCourse();



            }
        });




    }
    private void openDialogAddCourse(){
        dialog.setContentView(R.layout.dialog_addmanager);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        EditText editTextAddName=dialog.findViewById(R.id.editTextNameManager);
        EditText editTextAddPhone=dialog.findViewById(R.id.EditTextPhoneStudent);
        EditText editTextAddEmail=dialog.findViewById(R.id.editTextEmailManager);
        Button btnSave=dialog.findViewById(R.id.btnSaveAddManager);
        Button btnCancle =dialog.findViewById(R.id.btnCancleAddManager);
        dialog.show();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean nameCheck=editTextAddName.getText().toString().equals("");
                Boolean phoneCheck= editTextAddPhone.getText().toString().equals("");
                Boolean mailCheck= editTextAddEmail.getText().toString().equals("");

                if(nameCheck==false && phoneCheck==false && mailCheck==false)
                {

                    FirebaseDatabase db=FirebaseDatabase.getInstance();
                    DatabaseReference node=db.getReference();
                    QuanLy quanLy= new QuanLy(editTextAddName.getText().toString(), editTextAddPhone.getText().toString(),editTextAddEmail.getText().toString());
                    node.child("QuanLy").push().setValue(quanLy);
                    list.clear();
                    // adapter.notifyDataSetChanged();
                    editTextAddName.setText("");
                    editTextAddPhone.setText("");
                    ;editTextAddEmail.setText("");

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


}
