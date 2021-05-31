package com.example.contactapp.Teacher.Profile;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.contactapp.Models.BaiGiang;
import com.example.contactapp.Models.BaiTap;
import com.example.contactapp.Models.GiaoVien;
import com.example.contactapp.R;
import com.example.contactapp.Teacher.Exercises.TeacherExerciseEdit;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TeacherProfileActivity extends AppCompatActivity {
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private ChildEventListener mChildListener;
    private FirebaseAuth auth;
    private FirebaseUser mFirebaseUser;
    Button btnEdit, btnChangpwd,btnLogout;
    ImageView imgView;
    TextView tvName, tvEmail,tvPhone;
    private static final String TAG = "ReadAndWriteSnippets";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_profile_detail);

        tvName = findViewById(R.id.tvName);
        tvPhone = findViewById(R.id.tvPhone);
        tvEmail = findViewById(R.id.tvEmail);
        btnEdit = findViewById(R.id.btnEdit);
        btnChangpwd = findViewById(R.id.btnChangepwd);
        btnLogout = findViewById(R.id.btnLogout);

       getData();

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent= new Intent(TeacherProfileActivity.this,TeacherProfileEdit.class);
               startActivity(intent);
            }
        });

        btnChangpwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(TeacherProfileActivity.this,TeacherProfileChangePassword.class);
                startActivity(intent);
            }
        });
    }
    private void getData()
    {
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();
        mDatabaseReference=mFirebaseDatabase.getReference().child("GiaoVien");
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot:dataSnapshot.getChildren()) {
                    GiaoVien gv = snapshot.getValue(GiaoVien.class);
                    gv.setId(snapshot.getKey());
                    String uid=auth.getCurrentUser().getUid();
                    if(gv.getId().equals(uid))
                    {
                        tvName.setText(gv.getName());
                        tvPhone.setText(gv.getPhone());
                        tvEmail.setText(gv.getEmail());

                    }
                }

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        });

//                    mDatabaseReference=mFirebaseDatabase.getReference().child("GiaoVien");
//            mChildListener= new ChildEventListener() {
//                @Override
//                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                    GiaoVien gv = snapshot.getValue(GiaoVien.class);
//                    gv.setId(snapshot.getKey());
//                    String email = auth.getCurrentUser().getEmail();
//                    if (gv.getEmail().equals(email)) {
//                        tvName.setText(gv.getName());
//                        tvPhone.setText(gv.getPhone());
//                        tvEmail.setText(gv.getEmail());
//
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
    }
}
