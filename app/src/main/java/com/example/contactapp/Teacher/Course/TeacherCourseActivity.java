package com.example.contactapp.Teacher.Course;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.contactapp.Models.BaiGiang;
import com.example.contactapp.Models.GiaoVien;
import com.example.contactapp.R;
import com.example.contactapp.Teacher.Class.TeacherClassAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TeacherCourseActivity extends AppCompatActivity {
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private ChildEventListener mChildListener;
    private FirebaseUser mFirebaseUser;
    List<BaiGiang> lstBaiGiang=new ArrayList<>();
    TeacherCourseAdapter adapter;
    String khoahoc;
    RecyclerView recyclerView;
    TextView tvName,tvCourse, tvDate,tvTime;
    private static final String TAG = "ReadAndWriteSnippets";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_course);

        tvTime=findViewById(R.id.textViewTime);
        tvName=findViewById(R.id.textViewName);
      //  tvCourse=findViewById(R.id.textViewCourse);
        tvDate=findViewById(R.id.textViewDate);

        getUser();
        getDate();

        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager=new LinearLayoutManager(TeacherCourseActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        adapter= new TeacherCourseAdapter();
        recyclerView.setAdapter(adapter);


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
}
