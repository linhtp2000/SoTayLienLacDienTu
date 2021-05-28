package com.example.contactapp;

import android.content.Intent;
import android.os.Bundle;

import com.example.contactapp.Models.Admin;
import com.example.contactapp.Models.GiaoVien;
import com.example.contactapp.Models.PhuHuynh;
import com.example.contactapp.Models.QuanLy;
import com.example.contactapp.Models.SinhVien;
import com.example.contactapp.Teacher.Class.TeacherClassActivity;
import com.example.contactapp.Teacher.Exercises.TeacherExerciseInsert;
import com.example.contactapp.Teacher.Exercises.TeacherExercisesActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(MainActivity.this, TeacherExercisesActivity.class);
        startActivity(intent);

//        mFirebaseDatabase=FirebaseDatabase.getInstance();
//        mFirebaseAuth=FirebaseAuth.getInstance();
//        authListener = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                FirebaseUser user = firebaseAuth.getCurrentUser();
//
////                if (user == null) {
////                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
////                    finish();
////                }
////                else
////                {
////                    FirebaseUtil.openFbReference("GiaoVien");
////                    mFirebaseDatabase=FirebaseUtil.mFirebaseDatabase;
////                    mDatabaseReference=FirebaseUtil.mDatabaseReference;
////                    mChildListener= new ChildEventListener() {
////                        @Override
////                        public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
////                            GiaoVien gv =snapshot.getValue(GiaoVien.class);
////                            if(gv.getEmail().equals(user.getEmail().toString()))
////                            {
////                                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
////                                finish();
////                            }
////                        }
////
////                        @Override
////                        public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
////
////                        }
////
////                        @Override
////                        public void onChildRemoved(@NonNull DataSnapshot snapshot) {
////
////                        }
////
////                        @Override
////                        public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
////
////                        }
////
////                        @Override
////                        public void onCancelled(@NonNull DatabaseError error) {
////
////                        }
////                    };
////                    mDatabaseReference.addChildEventListener(mChildListener);
////
////                    FirebaseUtil.openFbReference("PhuHuynh");
////                    mFirebaseDatabase=FirebaseUtil.mFirebaseDatabase;
////                    mDatabaseReference=FirebaseUtil.mDatabaseReference;
////                    mChildListener= new ChildEventListener() {
////                        @Override
////                        public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
////                            PhuHuynh ph =snapshot.getValue(PhuHuynh.class);
////                            if(ph.getEmail().equals(user.getEmail().toString()))
////                            {
////                                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
////                                finish();
////                            }
////                        }
////
////                        @Override
////                        public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
////
////                        }
////
////                        @Override
////                        public void onChildRemoved(@NonNull DataSnapshot snapshot) {
////
////                        }
////
////                        @Override
////                        public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
////
////                        }
////
////                        @Override
////                        public void onCancelled(@NonNull DatabaseError error) {
////
////                        }
////                    };
////                    mDatabaseReference.addChildEventListener(mChildListener);
////
////                    FirebaseUtil.openFbReference("Admin");
////                    mFirebaseDatabase=FirebaseUtil.mFirebaseDatabase;
////                    mDatabaseReference=FirebaseUtil.mDatabaseReference;
////                    mChildListener= new ChildEventListener() {
////                        @Override
////                        public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
////                            Admin ad =snapshot.getValue(Admin.class);
////                            if(ad.getEmail().equals(user.getEmail().toString()))
////                            {
////                                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
////                                finish();
////                            }
////                        }
////
////                        @Override
////                        public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
////
////                        }
////
////                        @Override
////                        public void onChildRemoved(@NonNull DataSnapshot snapshot) {
////
////                        }
////
////                        @Override
////                        public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
////
////                        }
////
////                        @Override
////                        public void onCancelled(@NonNull DatabaseError error) {
////
////                        }
////                    };
////                    mDatabaseReference.addChildEventListener(mChildListener);
////
////                    FirebaseUtil.openFbReference("QuanLy");
////                    mFirebaseDatabase=FirebaseUtil.mFirebaseDatabase;
////                    mDatabaseReference=FirebaseUtil.mDatabaseReference;
////                    mChildListener= new ChildEventListener() {
////                        @Override
////                        public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
////                            QuanLy ql =snapshot.getValue(QuanLy.class);
////                            if(ql.getEmail().equals(user.getEmail().toString()))
////                            {
////                                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
////                                finish();
////                            }
////                        }
////
////                        @Override
////                        public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
////
////                        }
////
////                        @Override
////                        public void onChildRemoved(@NonNull DataSnapshot snapshot) {
////
////                        }
////
////                        @Override
////                        public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
////
////                        }
////
////                        @Override
////                        public void onCancelled(@NonNull DatabaseError error) {
////
////                        }
////                    };
////                    mDatabaseReference.addChildEventListener(mChildListener);
////
////                    FirebaseUtil.openFbReference("GiaoVien");
////                    mFirebaseDatabase=FirebaseUtil.mFirebaseDatabase;
////                    mDatabaseReference=FirebaseUtil.mDatabaseReference;
////                    mChildListener= new ChildEventListener() {
////                        @Override
////                        public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
////                            SinhVien sv =snapshot.getValue(SinhVien.class);
////                            if(sv.getEmail().equals(user.getEmail().toString()))
////                            {
////                                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
////                                finish();
////                            }
////                        }
////
////                        @Override
////                        public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
////
////                        }
////
////                        @Override
////                        public void onChildRemoved(@NonNull DataSnapshot snapshot) {
////
////                        }
////
////                        @Override
////                        public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
////
////                        }
////
////                        @Override
////                        public void onCancelled(@NonNull DatabaseError error) {
////
////                        }
////                    };
////                    mDatabaseReference.addChildEventListener(mChildListener);
////                }
//            }
//        };

    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//        FirebaseUtil.detachListener();
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//      //String EmailCurrentUser ;
//        FirebaseUtil.openFbReference(this);
//
//        FirebaseUtil.attachListener();
//    }
//sign out method
//@Override
//protected void onResume() {
//    super.onResume();
//    auth.addAuthStateListener(authListener);
//
//}
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        auth.addAuthStateListener(authListener);
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        if (authListener != null) {
//            auth.removeAuthStateListener(authListener);
//        }
//    }
}