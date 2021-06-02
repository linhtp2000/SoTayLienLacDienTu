package com.example.contactapp.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.contactapp.R;

public class AdminManager extends AppCompatActivity {








    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin);









        Button btnManager=findViewById(R.id.btnManager);
        btnManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(v.getContext(), ListManager.class);



                v.getContext().startActivity(intent);
            }
        });
        Button btnCourse=findViewById(R.id.btnCourse);
        btnCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(v.getContext(), ListCourse.class);



                v.getContext().startActivity(intent);
            }
        });











    }








}

