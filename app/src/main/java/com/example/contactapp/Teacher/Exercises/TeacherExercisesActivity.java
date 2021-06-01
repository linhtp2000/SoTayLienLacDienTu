package com.example.contactapp.Teacher.Exercises;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.contactapp.Models.BaiGiang;
import com.example.contactapp.Models.BaiTap;
import com.example.contactapp.R;
import com.example.contactapp.Teacher.Class.TeacherClassAdapter;
import com.example.contactapp.Teacher.Profile.TeacherProfileEdit;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TeacherExercisesActivity extends AppCompatActivity {

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private ChildEventListener mChildListener;
    private FirebaseUser mFirebaseUser;
    List<BaiTap> lstBaiTap=new ArrayList<>();
    TeacherExerciseAdapter adapter;

    RecyclerView recyclerView;
    TextView tvClass,tvCourse;
    ImageView btnAdd,btnDelete;
    private static final String TAG = "ReadAndWriteSnippets";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_exercises);
        lstBaiTap=new ArrayList<>();

        recyclerView=findViewById(R.id.recyclerView);
        tvCourse=findViewById(R.id.tvCourse);
        tvClass=findViewById(R.id.tvClass);
        btnAdd=findViewById(R.id.btnAdd);
        btnDelete=findViewById(R.id.btnDelete);

        Intent intent=getIntent();
        BaiGiang bg =(BaiGiang) intent.getSerializableExtra("Baigiang");
        if(bg==null)
        {
            bg= new BaiGiang();
        }
        tvCourse.setText("Course - "+bg.getKhoaHoc());
        tvClass.setText(bg.getName());

        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter= new TeacherExerciseAdapter(bg);
        recyclerView.setAdapter(adapter);

        BaiGiang baiGiang=bg;
//        baiGiang.setId(bg.getId());
//        baiGiang.setMon(bg.getMon());
//        baiGiang.setGiaoVien(bg.getGiaoVien());
//        baiGiang.setHocKy(bg.getHocKy());
//        baiGiang.setKhoa(bg.getKhoa());
//        baiGiang.setKhoaHoc(bg.getKhoaHoc());
//        baiGiang.setName(bg.getName());
//        baiGiang.setPhong(bg.getPhong());
//        baiGiang.setThoiGian(bg.getThoiGian());
//        baiGiang.setThu(bg.getThu());

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TeacherExercisesActivity.this, TeacherExerciseInsert.class);
//                BaiGiang baiGiang= new BaiGiang();
//                baiGiang.setId(bg.getId());
                intent.putExtra("Baigiang", baiGiang);
                startActivity(intent);
            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TeacherExercisesActivity.this, TeacherExerciseEdit.class);
                intent.putExtra("Baigiang", baiGiang);
                startActivity(intent);
            }
        });
    }
}