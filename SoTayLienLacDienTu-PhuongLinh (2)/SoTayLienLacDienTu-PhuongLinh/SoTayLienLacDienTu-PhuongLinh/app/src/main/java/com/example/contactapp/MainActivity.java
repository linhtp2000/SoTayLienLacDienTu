package com.example.contactapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.contactapp.Admin.ListCourse;
import com.example.contactapp.Admin.ListManager;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnGotoCourse=findViewById(R.id.btnGoToCourse);
        btnGotoCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), ListCourse.class);

                startActivity(intent);
            }
        });
        Button manager=findViewById(R.id.btnManager);
        manager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), ListManager.class);

                startActivity(intent);
            }
        });

    }

//    private void setOnClickListener() {
//        listener=new AdapterCourse.RecyclerVieWClickListener() {
//            @Override
//            public void onClick(View v, int positon) {
//                Intent intent=new Intent(getApplicationContext(),ListClass.class);
//                intent.putExtra("key",list.get(positon));
//                startActivity(intent);
//            }
//        };
//    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//        FirebaseUtil.detachListener();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        FirebaseUtil.openFbReference("Teacher",this);
//        FirebaseUtil.attachListener();
//    }
}