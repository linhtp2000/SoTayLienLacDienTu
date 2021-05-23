package com.example.contactapp.Student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.contactapp.R;

public class ProfileUserDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_user_detail);
        Button btn = (Button) findViewById(R.id.btn_puDetailEdit);
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