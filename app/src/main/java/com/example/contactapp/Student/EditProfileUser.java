package com.example.contactapp.Student;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.contactapp.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditProfileUser extends AppCompatActivity {
    TextView User;
    TextView ClassUser;
    TextView Mssv;
    EditText Phone;
    EditText Mail;
    EditText Address;
    DatabaseReference mDatabase;
    Button Save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDatabase = FirebaseDatabase.getInstance().getReference();
        setContentView(R.layout.activity_edit_profile_user);


        User = (TextView) findViewById(R.id.editprofile_name);
        Mssv=(TextView) findViewById(R.id.editprofile_mssv);
        ClassUser = (TextView) findViewById(R.id.editprofile_class);
        Phone = (EditText) findViewById(R.id.editprofileTextPhone);
        Mail=(EditText) findViewById(R.id.editprofileTextEmail);
        Address=(EditText) findViewById(R.id.editprofileTextAddress);
        Save=(Button) findViewById(R.id.btn_editProfileEdit);
        if(ParentHome.UserRole.equals("")){
            User.setText( Home.NameUser);
            ClassUser.setText("Class:" + Home.ClassUser);
            Phone.setText(Home.PhoneUser);
            Mail.setText(Home.MailUser);
            Mssv.setText(Home.MSSV);
            Address.setText(Home.AddressUser);
            Save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDatabase.child("SinhVien").child(Home.Id).child("Phone").setValue(Phone.getText().toString());
                    mDatabase.child("SinhVien").child(Home.Id).child("Email").setValue(Mail.getText().toString());
                    mDatabase.child("SinhVien").child(Home.Id).child("Address").setValue(Address.getText().toString());
                    Toast.makeText(EditProfileUser.this,"Đã cập nhật!",Toast.LENGTH_LONG).show();
                }
            });
        }else {
            User.setText( ParentHome.NameUser);
            ClassUser.setText("");
            Phone.setText(ParentHome.PhoneUser);
            Mail.setText(ParentHome.MailUser);
            Mssv.setText("");
            Address.setText(ParentHome.AddressUser);
            Save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mDatabase.child("PhuHuynh").child(ParentHome.Id).child("Phone").setValue(Phone.getText().toString());
                    mDatabase.child("PhuHuynh").child(ParentHome.Id).child("Email").setValue(Mail.getText().toString());
                    mDatabase.child("PhuHuynh").child(ParentHome.Id).child("Address").setValue(Address.getText().toString());
                    Toast.makeText(EditProfileUser.this,"Đã cập nhật!",Toast.LENGTH_LONG).show();
                }
            });

        }


    }
}