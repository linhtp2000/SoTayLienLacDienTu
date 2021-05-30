package com.example.contactapp.Student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.contactapp.R;

public class ProfileUserDetail extends AppCompatActivity {
    TextView User;
    TextView ClassUser;
    EditText Phone;
    EditText Mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_user_detail);
        Button btn = (Button) findViewById(R.id.btn_puDetailEdit);

        User = (TextView) findViewById(R.id.pudetail_name);
        ClassUser = (TextView) findViewById(R.id.pudetail_class);
        Phone = (EditText) findViewById(R.id.editTextPhone);
        Mail=(EditText) findViewById(R.id.editTextEmail);

        if(ParentHome.UserRole.equals("")){
            User.setText( Home.NameUser);
            ClassUser.setText("Class:" + Home.ClassUser);
            Phone.setText(Home.PhoneUser);
            Mail.setText(Home.MailUser);
        }else {
            User.setText( ParentHome.NameUser);
            ClassUser.setText("");
            Phone.setText(ParentHome.PhoneUser);
            Mail.setText(ParentHome.MailUser);
        }




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileUserDetail.this, EditProfileUser.class));
            }
        });
        Button btn2 = (Button) findViewById(R.id.btn_puDetailChangePass);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileUserDetail.this, ChangePassword.class));
            }
        });
    }
}