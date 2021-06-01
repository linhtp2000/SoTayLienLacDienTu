package com.example.contactapp.Teacher.Class;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactapp.FirebaseUtil;
import com.example.contactapp.LoginActivity;
import com.example.contactapp.MainActivity;
import com.example.contactapp.Models.Admin;
import com.example.contactapp.Models.BaiGiang;
import com.example.contactapp.Models.GiaoVien;
import com.example.contactapp.Models.Mon;
import com.example.contactapp.Models.PhuHuynh;
import com.example.contactapp.R;
import com.example.contactapp.Teacher.Exercises.TeacherExercisesActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TeacherClassActivity extends AppCompatActivity {
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private ChildEventListener mChildListener;
    private FirebaseUser mFirebaseUser;
    List<BaiGiang> lstBaiGiang=new ArrayList<>();
    TeacherClassAdapter adapter;
    String khoahoc;
    RecyclerView recyclerView;
    TextView tvName,tvCourse, tvDate,tvTime;
    private static final String TAG = "ReadAndWriteSnippets";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_class);

        Intent intent=getIntent();
        String kh=(String) intent.getSerializableExtra("KhoaHoc");
        if(kh==null)
        {
            kh="";
        }
        khoahoc=kh;

        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager=new LinearLayoutManager(TeacherClassActivity.this);
        recyclerView.setLayoutManager(layoutManager);

        adapter= new TeacherClassAdapter(khoahoc);
        recyclerView.setAdapter(adapter);


    }
    private void getData()
    {
      //  lstBaiGiang.clear();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference=mFirebaseDatabase.getReference().child("BaiGiang");
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snap:dataSnapshot.getChildren()) {
                    BaiGiang bg = snap.getValue(BaiGiang.class);
                     bg.setId(snap.getKey());
                     if(bg.getKhoaHoc()==2018) {
                        lstBaiGiang.add(bg);
                        adapter.notifyItemInserted(lstBaiGiang.size()-1);
                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        });

        //        mFirebaseDatabase = FirebaseDatabase.getInstance();
//        mDatabaseReference=mFirebaseDatabase.getReference().child("BaiGiang");
//     //   mDatabaseReference=FirebaseDatabase.getInstance().getReference().child("GiaoVien");

    }
}
