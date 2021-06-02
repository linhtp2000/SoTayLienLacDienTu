package com.example.contactapp.Teacher.Profile;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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

public class TeacherProfileEdit extends AppCompatActivity {
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private ChildEventListener mChildListener;
    private FirebaseAuth auth;
    private FirebaseUser mFirebaseUser;
    Button btnSave;
    ImageView imgView;
    EditText edtName, edtPhone;
    TextView tvEmail;
    private static final String TAG = "ReadAndWriteSnippets";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_profile_edit);

        edtName = findViewById(R.id.edtName);
        edtPhone = findViewById(R.id.edtPhone);
        tvEmail = findViewById(R.id.tvEmail);
        btnSave = findViewById(R.id.btnSave);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();
        mDatabaseReference=mFirebaseDatabase.getReference().child("GiaoVien");
        getData();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Showdialog();
               // EditProfile(auth.getCurrentUser().getUid());
            }
        });
    }

    private void getData()
    {

        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot:dataSnapshot.getChildren()) {
                    GiaoVien gv = snapshot.getValue(GiaoVien.class);
                    gv.setId(snapshot.getKey());
                    String uid=auth.getCurrentUser().getUid();
                    if(gv.getId().equals(uid))
                    {
                        edtName.setText(gv.getName());
                        edtPhone.setText(gv.getPhone());
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
    }
    private void Showdialog(){
        Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.dialogdelete);
        dialog.show();
        Button btnOK = (Button) dialog.findViewById(R.id.btnOK);
        Button btnCancel =(Button) dialog.findViewById(R.id.btnCancel);
        TextView tvTile=(TextView) dialog.findViewById(R.id.dialogDelete_Title);
        tvTile.setText("Save changes?");

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtName.getText().toString().trim().compareTo("")!=0 && edtPhone.getText().toString().trim().compareTo("")!=0) {
                    String uid = auth.getCurrentUser().getUid();
                    GiaoVien gv = new GiaoVien();
                    gv.setPhone(edtPhone.getText().toString());
                    gv.setName(edtName.getText().toString());
                    gv.setEmail(tvEmail.getText().toString());
                    mDatabaseReference.child(uid).setValue(gv);
                    Toast.makeText(TeacherProfileEdit.this, "Update successfully!", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }else
                {
                    Toast.makeText(TeacherProfileEdit.this, "Please fill out the form", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                }
            }
        });
    }
//    private  void EditProfile(String uid)
//    {
//        if(edtName.getText().toString().trim()!=""&&edtPhone.getText().toString().trim()!="") {
//
//            Toast.makeText(TeacherProfileEdit.this, "Update successfully!", Toast.LENGTH_SHORT).show();
//        }
//        else {
//            Toast.makeText(TeacherProfileEdit.this, "Please fill out the form", Toast.LENGTH_SHORT).show();
//        }
//    }
}
