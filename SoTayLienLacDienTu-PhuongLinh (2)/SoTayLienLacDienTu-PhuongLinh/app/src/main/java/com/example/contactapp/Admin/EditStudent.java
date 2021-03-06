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

        studentName.setText(extras.getString("name") +" "+ extras.getString("mssv"));
        TextView mail=findViewById(R.id.txtMailEdit);
        mail.setText(extras.getString("mail"));
        EditText phone=findViewById(R.id.EditTextPhone);
        phone.setText(extras.getString("phone"));
        EditText address=findViewById(R.id.editTextAddress);
        address.setText(extras.getString("address"));








        database= FirebaseDatabase.getInstance().getReference("SinhVien");
        Button btnSave=findViewById(R.id.btnOkSure);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean checkPhone=phone.getText().toString().equals("");
                Boolean checkAddr=address.getText().toString().equals("");
                if (checkPhone==false && checkAddr==false) {
                    database.child(extras.getString("id")).child("phone").setValue(phone.getText().toString());
                    database.child(extras.getString("id")).child("address").setValue(address.getText().toString());
                    Toast.makeText(getApplicationContext(), "Thay ?????i th??nh c??ng", Toast.LENGTH_LONG).show();
                }
                else  Toast.makeText(getApplicationContext(),"B???n ch??a nh???p s??? ??i???n tho???i", Toast.LENGTH_LONG).show();
            }

        });










    }








}
