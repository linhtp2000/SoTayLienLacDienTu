package com.example.contactapp;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.contactapp.Student.Home;
import com.example.contactapp.Student.ParentHome;

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


        Button btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = userName.getText().toString().trim();
                String pass = password.getText().toString().trim();
                if(user.equals("") || pass.equals(""))
                {
                    dialogError(Gravity.CENTER);
                    return;
                }else if (pass.equals("a")){
                    startActivity(new Intent(MainActivity.this, Home.class));
                }else {
                    startActivity(new Intent(MainActivity.this, ParentHome.class));
                }

            }
        });
    }
    private void dialogError(int gravity){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialogerror2);

        Window window = dialog.getWindow();
        if(window == null)
        {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = gravity;
        window.setAttributes(windowAttributes);
        if(Gravity.BOTTOM == gravity)
        {
            dialog.setCancelable(true);
        }
        else {
            dialog.setCancelable(false);
        }
        Button btn_oke = (Button) dialog.findViewById(R.id.btn_dialogError_Oke1);
        btn_oke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }

}