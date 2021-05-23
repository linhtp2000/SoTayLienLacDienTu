package com.example.contactapp;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.contactapp.Student.Home;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_form);
        Button btn_createAccount = (Button) findViewById(R.id.btn_createAccount);

        EditText userName = (EditText) findViewById(R.id.login_user);
        EditText password = (EditText) findViewById(R.id.login_pass);
        btn_createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Register.class));
            }
        });
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialogerror2);

        Button btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = userName.getText().toString().trim();
                String pass = password.getText().toString().trim();
                if(user.equals("") || pass.equals(""))
                {
                    dialog.show();
                    return;
                }
                startActivity(new Intent(MainActivity.this, Home.class));
            }
        });
    }

}