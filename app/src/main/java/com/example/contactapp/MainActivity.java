package com.example.contactapp;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;


import android.util.Log;

import com.example.contactapp.Models.Admin;
import com.example.contactapp.Models.BaiTap;
import com.example.contactapp.Models.GiaoVien;
import com.example.contactapp.Models.PhuHuynh;
import com.example.contactapp.Models.QuanLy;
import com.example.contactapp.Models.SinhVien;
import com.example.contactapp.Teacher.Class.TeacherClassActivity;
import com.example.contactapp.Teacher.Course.TeacherCourseActivity;
import com.example.contactapp.Teacher.Exercises.TeacherExerciseInsert;
import com.example.contactapp.Teacher.Exercises.TeacherExercisesActivity;
import com.example.contactapp.Teacher.Profile.TeacherProfileActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.contactapp.Student.Home;
import com.example.contactapp.Student.ParentHome;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private ChildEventListener mChildListener;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener authListener;
    private FirebaseAuth auth;
    private static final String TAG = "ReadAndWriteSnippets";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

      //  setContentView(R.layout.activity_main);


//        Intent intent = new Intent(MainActivity.this, TeacherExercisesActivity.class);
//        startActivity(intent);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
//                if (user != null) {
//                    //Giao vien
//                    mDatabaseReference=mFirebaseDatabase.getReference().child("GiaoVien");
//                    mDatabaseReference.addValueEventListener(new ValueEventListener() {
//                        public void onDataChange(DataSnapshot dataSnapshot) {
//                            GiaoVien gv= dataSnapshot.getValue(GiaoVien.class);
//                            if(gv.getEmail().equals(user.getEmail())){
//                                Intent intent = new Intent(MainActivity.this, TeacherExercisesActivity.class);
//                                startActivity(intent);
//                                finish();
//
//                            }
//                        }
//                        @Override
//                        public void onCancelled(DatabaseError databaseError) {
//                            // Getting Post failed, log a message
//                            Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
//                        }
//                    });
//                    //Phu huynh
//                    mDatabaseReference=mFirebaseDatabase.getReference().child("PhuHuynh");
//                    mDatabaseReference.addValueEventListener(new ValueEventListener() {
//                        public void onDataChange(DataSnapshot dataSnapshot) {
//                            PhuHuynh ph= dataSnapshot.getValue(PhuHuynh.class);
//                            if(ph.getEmail().equals(user.getEmail())){
//                                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//                                startActivity(intent);
//                                finish();
//
//                            }
//                        }
//                        @Override
//                        public void onCancelled(DatabaseError databaseError) {
//                            // Getting Post failed, log a message
//                            Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
//                        }
//                    });
//                    //Sinh vien
//                    mDatabaseReference=mFirebaseDatabase.getReference().child("SinhVien");
//                    mDatabaseReference.addValueEventListener(new ValueEventListener() {
//                        public void onDataChange(DataSnapshot dataSnapshot) {
//                            GiaoVien gv= dataSnapshot.getValue(GiaoVien.class);
//                            if(gv.getEmail().equals(user.getEmail())){
//                                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
//                                startActivity(intent);
//                                finish();
//
//                            }
//                        }
//                        @Override
//                        public void onCancelled(DatabaseError databaseError) {
//                            // Getting Post failed, log a message
//                            Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
//                        }
//                    });
//                    //Qu???n l??
//                    mDatabaseReference=mFirebaseDatabase.getReference().child("QuanLy");
//                    mDatabaseReference.addValueEventListener(new ValueEventListener() {
//                        public void onDataChange(DataSnapshot dataSnapshot) {
//                            QuanLy ql= dataSnapshot.getValue(QuanLy.class);
//                            if(ql.getEmail().equals(user.getEmail())){
//                                Intent intent = new Intent(MainActivity.this, TeacherExercisesActivity.class);
//                                startActivity(intent);
//                                finish();
//
//                            }
//                        }
//                        @Override
//                        public void onCancelled(DatabaseError databaseError) {
//                            // Getting Post failed, log a message
//                            Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
//                        }
//                    });
//                    //Admin
//                    mDatabaseReference=mFirebaseDatabase.getReference().child("Admin");
//                    mDatabaseReference.addValueEventListener(new ValueEventListener() {
//                        public void onDataChange(DataSnapshot dataSnapshot) {
//                            Admin ad= dataSnapshot.getValue(Admin.class);
//                            if(ad.getEmail().equals(user.getEmail())){
//                                Intent intent = new Intent(MainActivity.this, TeacherExercisesActivity.class);
//                                startActivity(intent);
//                                finish();
//
//                            }
//                        }
//                        @Override
//                        public void onCancelled(DatabaseError databaseError) {
//                            // Getting Post failed, log a message
//                            Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
//                        }
//                    });
//                }
//                else
//                {
            }
        };
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        //  }


    }



}