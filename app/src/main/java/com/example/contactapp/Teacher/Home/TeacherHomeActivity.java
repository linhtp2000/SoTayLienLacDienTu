package com.example.contactapp.Teacher.Home;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactapp.Models.BaiGiang;
import com.example.contactapp.Models.GiaoVien;
import com.example.contactapp.R;
import com.example.contactapp.Teacher.Course.TeacherCourseActivity;
import com.example.contactapp.Teacher.Course.TeacherCourseAdapter;
import com.example.contactapp.Teacher.Exercises.TeacherExerciseEdit;
import com.example.contactapp.Teacher.Profile.TeacherBackgroundProfile;
import com.example.contactapp.Teacher.Profile.TeacherProfileActivity;
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
import java.util.List;

public class TeacherHomeActivity extends AppCompatActivity {
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private ChildEventListener mChildListener;
    private FirebaseUser mFirebaseUser;
    TextView tvName,tvDate,tvTime;
    RelativeLayout btnCourse, btnProfile;
    private static final String TAG = "ReadAndWriteSnippets";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_home);

        tvTime=findViewById(R.id.tvTime);
        tvName=findViewById(R.id.tvName);
        tvDate=findViewById(R.id.tvDate);

        btnCourse=findViewById(R.id.ButtonYourClass);
        btnProfile=findViewById(R.id.ButtonNotification);

        getUser();
        getDate();

        btnProfile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent= new Intent(TeacherHomeActivity.this, TeacherBackgroundProfile.class);
                startActivity(intent);

            }
        });
        btnCourse.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent= new Intent(TeacherHomeActivity.this, TeacherCourseActivity.class);
                startActivity(intent);

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
        //  String dayOfWeek = new SimpleDateFormat("EEEE").format(date);
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
        if(buoi==0) {
            tvTime.setText(gio + ":" + phut + "pm");
        }else {
            tvTime.setText(gio + ":" + phut + "pm");
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

