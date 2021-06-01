package com.example.contactapp.Student;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.contactapp.Model.Parent;
import com.example.contactapp.R;

public class ProfileStudent extends AppCompatActivity {
    TextView User;
    TextView ClassUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_student);
        User = (TextView) findViewById(R.id.profile_name);
        ClassUser = (TextView) findViewById(R.id.profile_mssv);

        if(ParentHome.UserRole.equals("parent")){
            ClassUser.setText("Parent of " + ParentHome.NameChild);
            User.setText( ParentHome.NameUser);
        }
        else {
            ClassUser.setText("Class:" + Home.ClassUser);
            User.setText( Home.NameUser);
        }

        Button btn = (Button) findViewById(R.id.btn_profileUser);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileStudent.this, ProfileUserDetail.class));
            }
        });
    }
}