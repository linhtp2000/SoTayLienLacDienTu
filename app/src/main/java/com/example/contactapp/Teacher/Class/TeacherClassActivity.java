package com.example.contactapp.Teacher.Class;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactapp.Models.BaiGiang;
import com.example.contactapp.Models.GiaoVien;
import com.example.contactapp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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

        tvTime=findViewById(R.id.tvTime);
        tvName=findViewById(R.id.tvName);
        tvCourse=findViewById(R.id.tvCourse);
        tvDate=findViewById(R.id.tvDate);

        Intent intent=getIntent();
        String kh=(String) intent.getSerializableExtra("KhoaHoc");
        if(kh==null)
        {
            kh="";
        }
        khoahoc=kh;
        tvCourse.setText("Course - "+kh);
        getData();
        getDate();
        getUser();

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

    }
    private void getUser()
    {
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        FirebaseAuth auth = FirebaseAuth.getInstance();
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
                        tvName.setText("Welcome, "+gv.getName());
                        return;
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
    private void getDate()
    {
        Calendar calendar = Calendar.getInstance();
        int day=calendar.get(Calendar.DATE);
        int month =calendar.get(Calendar.MONTH);
        int year=calendar.get(Calendar.YEAR);
        int gio=calendar.get(Calendar.HOUR);
        int phut=calendar.get(Calendar.MINUTE);
        int buoi=calendar.get(Calendar.AM);
        month=month+1;
        String m="";
        if(month==1) m="Jan";
        if(month==2) m="Feb";
        if(month==3) m="Mar";
        if(month==4) m="Apr";
        if(month==5) m="May";
        if(month==6) m="Jun";
        if(month==7) m="Jul";
        if(month==8) m="Aug";
        if(month==9) m="Sep";
        if(month==10) m="Oct";
        if(month==11) m="Nov";
        if(month==12) m="Dec";
        tvDate.setText(day+" "+m+", "+year);
        if(buoi==0){
            tvTime.setText(gio+":"+phut+"pm");
        }
        else {
            tvTime.setText(gio+":"+phut+"am");
        }


    }
}
