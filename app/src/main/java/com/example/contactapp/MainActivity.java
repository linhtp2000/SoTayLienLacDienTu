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
import com.example.contactapp.Teacher.Exercises.TeacherExerciseEdit;
import com.example.contactapp.Teacher.Exercises.TeacherExerciseInsert;
import com.example.contactapp.Teacher.Exercises.TeacherExercisesActivity;
import com.example.contactapp.Teacher.Home.TeacherHomeActivity;
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

        setContentView(R.layout.activity_main);


//        Intent intent = new Intent(MainActivity.this, TeacherExercisesActivity.class);
//        startActivity(intent);
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();

        //get current user
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (user == null) {
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                    finish();
                } else {
                    String uid = user.getUid();
                    mDatabaseReference = mFirebaseDatabase.getReference().child("GiaoVien");
                    mDatabaseReference.addValueEventListener(new ValueEventListener() {
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for (DataSnapshot snap : dataSnapshot.getChildren()) {
                                String id = snap.getKey();
                                //GiaoVien gv = snap.getValue(GiaoVien.class)
                                if (id != null) {
                                    if (id.equals(uid)) {
                                        Intent intent = new Intent(MainActivity.this, TeacherHomeActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            }

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            // Getting Post failed, log a message
                            Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                        }
                    });


                    mDatabaseReference = mFirebaseDatabase.getReference().child("PhuHuynh");
                    mDatabaseReference.addValueEventListener(new ValueEventListener() {
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for (DataSnapshot snap : dataSnapshot.getChildren()) {
                                String id = snap.getKey();
                                //GiaoVien gv = snap.getValue(GiaoVien.class)
                                if (id != null) {
                                    if (id.equals(uid)) {
                                        Intent intent = new Intent(MainActivity.this, TeacherExercisesActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            }

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            // Getting Post failed, log a message
                            Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                        }
                    });

                    //Sinh vien
                    mDatabaseReference = mFirebaseDatabase.getReference().child("SinhVien");
                    mDatabaseReference.addValueEventListener(new ValueEventListener() {
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for (DataSnapshot snap : dataSnapshot.getChildren()) {
                                String id = snap.getKey();
                                //GiaoVien gv = snap.getValue(GiaoVien.class)
                                if (id != null) {
                                    if (id.equals(uid)) {
                                        Intent intent = new Intent(MainActivity.this, TeacherClassActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            }

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            // Getting Post failed, log a message
                            Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                        }
                    });
                    //Quản lý
                    mDatabaseReference = mFirebaseDatabase.getReference().child("QuanLy");
                    mDatabaseReference.addValueEventListener(new ValueEventListener() {
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for (DataSnapshot snap : dataSnapshot.getChildren()) {
                                String id = snap.getKey();
                                //GiaoVien gv = snap.getValue(GiaoVien.class)
                                if (id != null) {
                                    if (id.equals(uid)) {
                                        Intent intent = new Intent(MainActivity.this, TeacherExerciseEdit.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            }

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            // Getting Post failed, log a message
                            Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                        }
                    });

                    //Admin
                    mDatabaseReference = mFirebaseDatabase.getReference().child("Admin");
                    mDatabaseReference.addValueEventListener(new ValueEventListener() {
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for (DataSnapshot snap : dataSnapshot.getChildren()) {
                                String id = snap.getKey();
                                //GiaoVien gv = snap.getValue(GiaoVien.class)
                                if (id != null) {
                                    if (id.equals(uid)) {
                                        Intent intent = new Intent(MainActivity.this, TeacherCourseActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            }

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            // Getting Post failed, log a message
                            Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
                        }
                    });
                }
            }
        };

    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onStart() {
        super.onStart();
        auth.addAuthStateListener(authListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (authListener != null) {
            auth.removeAuthStateListener(authListener);
        }
    }

}