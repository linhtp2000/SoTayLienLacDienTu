package com.example.contactapp;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.contactapp.Admin.AdminManager;
import com.example.contactapp.Models.Admin;
import com.example.contactapp.Models.GiaoVien;
import com.example.contactapp.Models.PhuHuynh;
import com.example.contactapp.Models.QuanLy;
import com.example.contactapp.Models.SinhVien;
import com.example.contactapp.Quanly.HomeQuanly.Home_Quanly;
import com.example.contactapp.Quanly.Quanly;
import com.example.contactapp.Student.Home;
import com.example.contactapp.Student.ParentHome;
import com.example.contactapp.Teacher.Class.TeacherClassActivity;
import com.example.contactapp.Teacher.Course.TeacherCourseActivity;
import com.example.contactapp.Teacher.Exercises.TeacherExerciseEdit;
import com.example.contactapp.Teacher.Exercises.TeacherExercisesActivity;
import com.example.contactapp.Teacher.Home.TeacherHomeActivity;
import com.example.contactapp.Teacher.Profile.TeacherProfileActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {
    private EditText inputEmail, inputPassword;
    private FirebaseAuth auth;
    private static final String TAG = "ReadAndWriteSnippets";
    private Button btnSignup, btnLogin,btnReset;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private ChildEventListener mChildListener;
    private FirebaseAuth.AuthStateListener authListener;
    private static int check=0;
    public static String IdUser;
    //  private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        //   final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

//        authListener = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                FirebaseUser user = firebaseAuth.getCurrentUser();
//                if (user != null) {
//                    //Giao vien
//                    mDatabaseReference = mFirebaseDatabase.getReference().child("GiaoVien");
//                    mDatabaseReference.addValueEventListener(new ValueEventListener() {
//                        public void onDataChange(DataSnapshot dataSnapshot) {
//                            GiaoVien gv = dataSnapshot.getValue(GiaoVien.class);
//                            if (gv.getEmail().equals(user.getEmail())) {
//                                Intent intent = new Intent(LoginActivity.this, TeacherExercisesActivity.class);
//                                startActivity(intent);
//                                finish();
//
//                            }
//                        }
//
//                        @Override
//                        public void onCancelled(DatabaseError databaseError) {
//                            // Getting Post failed, log a message
//                            Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
//                        }
//                    });
//                    //Phu huynh
//                    mDatabaseReference = mFirebaseDatabase.getReference().child("PhuHuynh");
//                    mDatabaseReference.addValueEventListener(new ValueEventListener() {
//                        public void onDataChange(DataSnapshot dataSnapshot) {
//                            PhuHuynh ph = dataSnapshot.getValue(PhuHuynh.class);
//                            if (ph.getEmail().equals(user.getEmail())) {
//                                Intent intent = new Intent(LoginActivity.this, TeacherProfileActivity.class);
//                                startActivity(intent);
//                                finish();
//
//                            }
//                        }
//
//                        @Override
//                        public void onCancelled(DatabaseError databaseError) {
//                            // Getting Post failed, log a message
//                            Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
//                        }
//                    });
//                    //Sinh vien
//                    mDatabaseReference = mFirebaseDatabase.getReference().child("SinhVien");
//                    mDatabaseReference.addValueEventListener(new ValueEventListener() {
//                        public void onDataChange(DataSnapshot dataSnapshot) {
//                            GiaoVien gv = dataSnapshot.getValue(GiaoVien.class);
//                            if (gv.getEmail().equals(user.getEmail())) {
//                                Intent intent = new Intent(LoginActivity.this, TeacherExercisesActivity.class);
//                                startActivity(intent);
//                                finish();
//
//                            }
//                        }
//
//                        @Override
//                        public void onCancelled(DatabaseError databaseError) {
//                            // Getting Post failed, log a message
//                            Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
//                        }
//                    });
//                    //Qu???n l??
//                    mDatabaseReference = mFirebaseDatabase.getReference().child("QuanLy");
//                    mDatabaseReference.addValueEventListener(new ValueEventListener() {
//                        public void onDataChange(DataSnapshot dataSnapshot) {
//                            QuanLy ql = dataSnapshot.getValue(QuanLy.class);
//                            if (ql.getEmail().equals(user.getEmail())) {
//                                Intent intent = new Intent(LoginActivity.this, TeacherExercisesActivity.class);
//                                startActivity(intent);
//                                finish();
//
//                            }
//                        }
//
//                        @Override
//                        public void onCancelled(DatabaseError databaseError) {
//                            // Getting Post failed, log a message
//                            Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
//                        }
//                    });
//                    //Admin
//                    mDatabaseReference = mFirebaseDatabase.getReference().child("Admin");
//                    mDatabaseReference.addValueEventListener(new ValueEventListener() {
//                        public void onDataChange(DataSnapshot dataSnapshot) {
//                            Admin ad = dataSnapshot.getValue(Admin.class);
//                            if (ad.getEmail().equals(user.getEmail())) {
//                                Intent intent = new Intent(LoginActivity.this, TeacherExercisesActivity.class);
//                                startActivity(intent);
//                                finish();
//
//                            }
//                        }
//
//                        @Override
//                        public void onCancelled(DatabaseError databaseError) {
//                            // Getting Post failed, log a message
//                            Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
//                        }
//                    });
//                }
//            }
//            };

//        if (auth.getCurrentUser() != null) {
//            String email = auth.getCurrentUser().getEmail().toString();
//            mDatabaseReference=mFirebaseDatabase.getReference().child("GiaoVien");
//            mChildListener= new ChildEventListener() {
//                @Override
//                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                    GiaoVien gv =snapshot.getValue(GiaoVien.class);
//                    if(gv.getEmail().equals(email))
//                    {
//                        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
//                        finish();
//                    }
//                }
//
//                @Override
//                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//                }
//
//                @Override
//                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//
//                }
//
//                @Override
//                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError error) {
//
//                }
//            };
//            mDatabaseReference.addChildEventListener(mChildListener);
//
//            mDatabaseReference=mFirebaseDatabase.getReference().child("PhuHuynh");
//            mChildListener= new ChildEventListener() {
//                @Override
//                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                    PhuHuynh ph =snapshot.getValue(PhuHuynh.class);
//                    if(ph.getEmail().equals(email))
//                    {
//                        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
//                        finish();
//                    }
//                }
//
//                @Override
//                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//                }
//
//                @Override
//                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//
//                }
//
//                @Override
//                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError error) {
//
//                }
//            };
//            mDatabaseReference.addChildEventListener(mChildListener);
//
//            mDatabaseReference=mFirebaseDatabase.getReference().child("Admin");
//            mChildListener= new ChildEventListener() {
//                @Override
//                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                    Admin ad =snapshot.getValue(Admin.class);
//                    if(ad.getEmail().equals(email))
//                    {
//                        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
//                        finish();
//                    }
//                }
//
//                @Override
//                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//                }
//
//                @Override
//                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//
//                }
//
//                @Override
//                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError error) {
//
//                }
//            };
//            mDatabaseReference.addChildEventListener(mChildListener);
//
//            mDatabaseReference=mFirebaseDatabase.getReference().child("QuanLy");
//            mChildListener= new ChildEventListener() {
//                @Override
//                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                    QuanLy ql =snapshot.getValue(QuanLy.class);
//                    if(ql.getEmail().equals(email))
//                    {
//                        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
//                        finish();
//                    }
//                }
//
//                @Override
//                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//                }
//
//                @Override
//                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//
//                }
//
//                @Override
//                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError error) {
//
//                }
//            };
//            mDatabaseReference.addChildEventListener(mChildListener);
//
//            mDatabaseReference=mFirebaseDatabase.getReference().child("SinhVien");
//            mChildListener= new ChildEventListener() {
//                @Override
//                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                    SinhVien sv =snapshot.getValue(SinhVien.class);
//                    if(sv.getEmail().equals(email))
//                    {
//                        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
//                        finish();
//                    }
//                }
//
//                @Override
//                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//                }
//
//                @Override
//                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//
//                }
//
//                @Override
//                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError error) {
//
//                }
//            };
//            mDatabaseReference.addChildEventListener(mChildListener);
//        }
                    inputEmail = (EditText) findViewById(R.id.edtEmail);
                    inputPassword = (EditText) findViewById(R.id.edtPassword);
                    btnSignup = (Button) findViewById(R.id.btnResgister);
                    btnLogin = (Button) findViewById(R.id.btnLogin);
                    btnReset = (Button) findViewById(R.id.btnReset);

                    //Get Firebase auth instance
                    auth = FirebaseAuth.getInstance();

                    btnSignup.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                        }
                    });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, ChangePasswordActivity.class));
            }
        });


                    btnLogin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String email = inputEmail.getText().toString();
                            final String password = inputPassword.getText().toString();

                            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                                dialogError(Gravity.CENTER);
                                return;
                            }


                            //authenticate user
                            auth.signInWithEmailAndPassword(email, password)
                                    .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                            if (!task.isSuccessful()) {

//                                                if (check==0) {
//                                                    Toast.makeText(LoginActivity.this, "Account has not been!", Toast.LENGTH_LONG).show();
//                                                } else {
//                                                    if (check==1) {
//                                                        Toast.makeText(
//                                                                LoginActivity.this, "Password is incorrect!", Toast.LENGTH_LONG).show();
//                                                    } else
                                                        Toast.makeText(LoginActivity.this, "Failed", Toast.LENGTH_LONG).show();
//                                                }
                                            } else {
                                                String uid = auth.getCurrentUser().getUid();

                                                mDatabaseReference = mFirebaseDatabase.getReference().child("GiaoVien");
                                                mDatabaseReference.addValueEventListener(new ValueEventListener() {
                                                    public void onDataChange(DataSnapshot dataSnapshot) {
                                                        for (DataSnapshot snap : dataSnapshot.getChildren()) {
                                                            String id=snap.getKey();
                                                            //GiaoVien gv = snap.getValue(GiaoVien.class)
                                                            if (id != null) {
                                                                if (id.equals(uid)) {
                                                                    Intent intent = new Intent(LoginActivity.this, TeacherHomeActivity.class);
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
                                                                String id=snap.getKey();
                                                                //GiaoVien gv = snap.getValue(GiaoVien.class)
                                                                if (id != null) {
                                                                    if (id.equals(uid)) {
                                                                        IdUser=uid;
                                                                        Intent intent = new Intent(LoginActivity.this, ParentHome.class);
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
                                                                    String id=snap.getKey();
                                                                    //GiaoVien gv = snap.getValue(GiaoVien.class)
                                                                    if (id != null) {
                                                                        if (id.equals(uid)) {
                                                                            IdUser=uid;
                                                                            Intent intent = new Intent(LoginActivity.this, Home.class);
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
                                                        //Qu???n l??
                                                        mDatabaseReference = mFirebaseDatabase.getReference().child("QuanLy");
                                                        mDatabaseReference.addValueEventListener(new ValueEventListener() {
                                                            public void onDataChange(DataSnapshot dataSnapshot) {
                                                                for (DataSnapshot snap : dataSnapshot.getChildren()) {
                                                                    String id=snap.getKey();
                                                                    //GiaoVien gv = snap.getValue(GiaoVien.class)
                                                                    if (id != null) {
                                                                        if (id.equals(uid)) {
                                                                            Intent intent = new Intent(LoginActivity.this, Quanly.class);
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
                                                                    String id=snap.getKey();
                                                                    //GiaoVien gv = snap.getValue(GiaoVien.class)
                                                                    if (id != null) {
                                                                        if (id.equals(uid)) {
                                                                            Intent intent = new Intent(LoginActivity.this, AdminManager.class);
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
                                    });
                        }
                    });

    }

//    private void CheckMailExist (String email) {
//       // final int[] check = {0};
//
//        mFirebaseDatabase = FirebaseDatabase.getInstance();
//     //   mDatabaseReference=mFirebaseDatabase.getReference();
////        authListener = firebaseAuth -> {
////            FirebaseUser user = firebaseAuth.getCurrentUser();
//            //Giao vien
//            mDatabaseReference = mFirebaseDatabase.getReference().child("GiaoVien");
//            mDatabaseReference.addValueEventListener(new ValueEventListener() {
//                public void onDataChange(DataSnapshot dataSnapshot) {
//                    for (DataSnapshot snap:dataSnapshot.getChildren()) {
//                        GiaoVien gv = snap.getValue(GiaoVien.class);
//                        String s=gv.getEmail();
//                        if (gv.getEmail().equals(email)) {
//                            check = 1;
//                         return;
//                        }
//                    }
//
//                }
//
//                @Override
//                public void onCancelled(DatabaseError databaseError) {
//                    // Getting Post failed, log a message
//                    Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
//                }
//            });
//            if (check != 1) {
//                //Phu huynh
//                mDatabaseReference = mFirebaseDatabase.getReference().child("PhuHuynh");
//                mDatabaseReference.addValueEventListener(new ValueEventListener() {
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//                        PhuHuynh ph = dataSnapshot.getValue(PhuHuynh.class);
//                        if (ph.getEmail().equals(email)) {
//                            check = 1;
//                           return;
//                        }
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//                        // Getting Post failed, log a message
//                        Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
//                    }
//                });
//                if (check != 1) {
//                    //Sinh vien
//                    mDatabaseReference = mFirebaseDatabase.getReference().child("SinhVien");
//                    mDatabaseReference.addValueEventListener(new ValueEventListener() {
//                        public void onDataChange(DataSnapshot dataSnapshot) {
//                            SinhVien sv = dataSnapshot.getValue(SinhVien.class);
//                            if (sv.getEmail().equals(email)) {
//                                check = 1;
//                                return;
//                            }
//                        }
//
//                        @Override
//                        public void onCancelled(DatabaseError databaseError) {
//                            // Getting Post failed, log a message
//                            Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
//                        }
//                    });
//                    if (check == 1) {
//                        //Qu???n l??
//                        mDatabaseReference = mFirebaseDatabase.getReference().child("QuanLy");
//                        mDatabaseReference.addValueEventListener(new ValueEventListener() {
//                            public void onDataChange(DataSnapshot dataSnapshot) {
//                                QuanLy ql = dataSnapshot.getValue(QuanLy.class);
//                                if (ql.getEmail().equals(email)) {
//                                    check = 1;
//                                   return;
//
//                                }
//                            }
//
//                            @Override
//                            public void onCancelled(DatabaseError databaseError) {
//                                // Getting Post failed, log a message
//                                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
//                            }
//                        });
//                        if (check != 1) {
//                            //Admin
//                            mDatabaseReference = mFirebaseDatabase.getReference().child("Admin");
//                            mDatabaseReference.addValueEventListener(new ValueEventListener() {
//                                public void onDataChange(DataSnapshot dataSnapshot) {
//                                    Admin ad = dataSnapshot.getValue(Admin.class);
//                                    if (ad.getEmail().equals(email)) {
//                                        check = 1;
//                                       return;
//
//                                    }
//                                }
//
//                                @Override
//                                public void onCancelled(DatabaseError databaseError) {
//                                    // Getting Post failed, log a message
//                                    Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
//                                }
//                            });
//
//                        }
//                    }
//                }
//            }
////        FirebaseUtil.openFbReference("GiaoVien");
////        mFirebaseDatabase = FirebaseUtil.mFirebaseDatabase;
////        mDatabaseReference = FirebaseUtil.mDatabaseReference;
////        ValueEventListener postListener2 = new ValueEventListener() {
////            @Override
////            public void onDataChange(DataSnapshot dataSnapshot) {
////                // Get Post object and use the values to update the UI
////                GiaoVien ad = dataSnapshot.getValue(GiaoVien.class);
////                if (ad.getEmail().toString().equals(email)) {
////                    check[0] = 1;
////                    return;
////                }
////            }
////
////            @Override
////            public void onCancelled(DatabaseError databaseError) {
////                // Getting Post failed, log a message
////                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
////            }
////        };
////        mDatabaseReference.addValueEventListener(postListener2);
////        if (check[0] == 1) {
////            return true;
////        }
////
////        FirebaseUtil.openFbReference("PhuHuynh");
////        mFirebaseDatabase = FirebaseUtil.mFirebaseDatabase;
////        mDatabaseReference = FirebaseUtil.mDatabaseReference;
////        ValueEventListener postListener3 = new ValueEventListener() {
////            @Override
////            public void onDataChange(DataSnapshot dataSnapshot) {
////                // Get Post object and use the values to update the UI
////                PhuHuynh ad = dataSnapshot.getValue(PhuHuynh.class);
////                if (ad.getEmail().toString().equals(email)) {
////                    check[0] = 1;
////                    return;
////                }
////            }
////
////            @Override
////            public void onCancelled(DatabaseError databaseError) {
////                // Getting Post failed, log a message
////                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
////            }
////        };
////        mDatabaseReference.addValueEventListener(postListener3);
////        if (check[0] == 1) {
////            return true;
////        }
////
////        FirebaseUtil.openFbReference("SinhVien");
////        mFirebaseDatabase = FirebaseUtil.mFirebaseDatabase;
////        mDatabaseReference = FirebaseUtil.mDatabaseReference;
////        ValueEventListener postListener4 = new ValueEventListener() {
////            @Override
////            public void onDataChange(DataSnapshot dataSnapshot) {
////                // Get Post object and use the values to update the UI
////                SinhVien ad = dataSnapshot.getValue(SinhVien.class);
////                if (ad.getEmail().toString().equals(email)) {
////                    check[0] = 1;
////                    return;
////                }
////            }
////
////            @Override
////            public void onCancelled(DatabaseError databaseError) {
////                // Getting Post failed, log a message
////                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
////            }
////        };
////        mDatabaseReference.addValueEventListener(postListener4);
////        if (check[0] == 1) {
////            return true;
////        }
////
////        FirebaseUtil.openFbReference("QuanLy");
////        mFirebaseDatabase = FirebaseUtil.mFirebaseDatabase;
////        mDatabaseReference = FirebaseUtil.mDatabaseReference;
////        ValueEventListener postListener5 = new ValueEventListener() {
////            @Override
////            public void onDataChange(DataSnapshot dataSnapshot) {
////                // Get Post object and use the values to update the UI
////                QuanLy ad = dataSnapshot.getValue(QuanLy.class);
////                if (ad.getEmail().toString().equals(email)) {
////                    check[0] = 1;
////                    return;
////                }
////            }
////
////            @Override
////            public void onCancelled(DatabaseError databaseError) {
////                // Getting Post failed, log a message
////                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
////            }
////        };
////        mDatabaseReference.addValueEventListener(postListener5);
////        if (check[0] == 1) {
////            return true;
////        }
//
//
//        return;
//    }

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


