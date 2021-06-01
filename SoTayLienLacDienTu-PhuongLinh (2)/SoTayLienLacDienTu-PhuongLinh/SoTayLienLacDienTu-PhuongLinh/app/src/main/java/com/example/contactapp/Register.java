package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.Spinner;



public class Register extends AppCompatActivity {

    Spinner spnRole;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        spnRole=findViewById(R.id.spnRole);
    }

//    public void registerNewEmail(final String email, String password)
//    {
//      //  showDialog();
//
//        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,password)
//                .addOnCompleteListener(task ->
//                {
//                    Log.d(
//                    if(spnRole.getSelectedItem().toString().equals("Student"))
//                });
//    }
}