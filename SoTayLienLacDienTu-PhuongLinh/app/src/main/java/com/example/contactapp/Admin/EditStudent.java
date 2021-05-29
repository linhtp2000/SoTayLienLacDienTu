package com.example.contactapp.Admin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.contactapp.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditStudent extends AppCompatActivity {



    DatabaseReference database;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_username);
        TextView studentName=findViewById(R.id.txtNameStudentEdit);

        Bundle extras=getIntent().getExtras();
        TextView classname=findViewById(R.id.txtDayManager);
        classname.setText(extras.getString("class"));

        studentName.setText(extras.getString("name"));
        TextView mail=findViewById(R.id.txtMailEdit);
        mail.setText(extras.getString("mail"));
        EditText phone=findViewById(R.id.EditTextPhone);
        phone.setText(extras.getString("phone"));








        database= FirebaseDatabase.getInstance().getReference("SinhVien");
        Button btnSave=findViewById(R.id.btnOkSure);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (phone.getText().toString() == "") {
                    database.child(extras.getString("id")).child("Phone").setValue(phone.getText().toString());
                    Toast.makeText(getApplicationContext(), "Thay đổi thành công", Toast.LENGTH_LONG).show();
                }
                else  Toast.makeText(getApplicationContext(),"Bạn chưa nhập số điện thoại", Toast.LENGTH_LONG).show();
            }

        });










    }








}
