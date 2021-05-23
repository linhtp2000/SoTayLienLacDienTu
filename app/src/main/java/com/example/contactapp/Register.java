package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

import com.example.contactapp.Student.Home;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        EditText userName = (EditText) findViewById(R.id.register_userName);
        EditText password = (EditText) findViewById(R.id.register_pass);
        EditText mail = (EditText) findViewById(R.id.register_mail);
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialogerror2);
        Button btn_register = (Button) findViewById(R.id.button_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = userName.getText().toString().trim();
                String pass = password.getText().toString().trim();
                String email = mail.getText().toString().trim();
                if(user.equals("") || pass.equals("") || email.equals(""))
                {
                    dialog.show();
                    return;
                }
                startActivity(new Intent(Register.this, Home.class));
            }
        });
    }
}