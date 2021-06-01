package com.example.contactapp.Teacher.Exercises;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.contactapp.LoginActivity;
import com.example.contactapp.Models.BaiGiang;
import com.example.contactapp.Models.BaiTap;
import com.example.contactapp.R;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TeacherExerciseInsert extends AppCompatActivity {

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private ChildEventListener mChildListener;
    private FirebaseUser mFirebaseUser;
    Button btnOk, btnCancel;
    ImageView btnFrom, btnTo,btnTime;
    EditText edtName, edtNoiDung;
    TextView tvCourse, tvClass,tvFrom,tvTo,tvTime;
    String from,to;
    Calendar time1,time2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_insert_exercise);

        tvFrom=findViewById(R.id.tvFrom);
        tvTo=findViewById(R.id.tvTo);
        tvCourse=findViewById(R.id.tvCourse);
        tvClass=findViewById(R.id.tvClass);
        edtName=findViewById(R.id.tvName);
        edtNoiDung=findViewById(R.id.tvNoiDung);
        btnCancel=findViewById(R.id.btnCancel);
        btnOk=findViewById(R.id.btnOk);
        btnFrom=findViewById(R.id.imgvFrom);
        btnTo=findViewById(R.id.imgvTo);
        btnTime=findViewById(R.id.imgvTime);
        tvTime=findViewById(R.id.tvTime);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference=mFirebaseDatabase.getReference();

//        Intent intent=getIntent();
////        BaiGiang bg =(BaiGiang) intent.getSerializableExtra("Baigiang");
        BaiGiang bg= new BaiGiang();
        tvCourse.setText("Course - "+bg.getKhoaHoc());
        tvClass.setText(bg.getMon());

        Calendar calendar = Calendar.getInstance();
        int gio = calendar.get(Calendar.HOUR);
        int phut = calendar.get(Calendar.MINUTE);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
         String date = (simpleDateFormat.format(calendar.getTime()));
         tvFrom.setText(date);
         from=(gio+":"+phut).toString();
         time1=calendar;

        btnTo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int ngay=calendar.get(Calendar.DATE);
                int thang=calendar.get(Calendar.MONTH);
                int nam=calendar.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog=new DatePickerDialog(TeacherExerciseInsert.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        calendar.set(year,month,dayOfMonth);
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        tvTo.setText(simpleDateFormat.format(calendar.getTime()));
                    }
                }, nam,thang,ngay);
                datePickerDialog.show();
            }
        });
        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar myCalendar = Calendar.getInstance();
                TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener()
                {
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        myCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        myCalendar.set(Calendar.MINUTE, minute);
                        time2=myCalendar;
                       tvTime.setText(hourOfDay+" : "+minute);
                    }
                };
                new TimePickerDialog(TeacherExerciseInsert.this, t,
                        myCalendar.get(Calendar.HOUR_OF_DAY),
                        myCalendar.get(Calendar.MINUTE), true).show();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(tvTo.getText()!="" && tvFrom.getText()!="" && edtName.getText().toString()!="" &&edtNoiDung.getText().toString()!="") {
                   String day1=tvFrom.getText().toString();
                   String day2=tvTo.getText().toString();
                   if(CheckDeadlineValid(day1,day2,time1,time2)==true) {
                       BaiTap baitap = new BaiTap();
                       baitap.setName(edtName.getText().toString());
                       baitap.setNoiDung(edtNoiDung.getText().toString());
                       baitap.setNgayTao(tvFrom.getText().toString());
                       baitap.setDeadline(tvTo.getText().toString());
                       baitap.setThoiGianNop(tvTime.getText().toString());
                       baitap.setThoiGianTao(from);
                       baitap.setBaiGiang(bg.getId());
                       baitap.setGiaoVien(bg.getGiaoVien());
                       baitap.setLstBaiTapSV(null);
                       mDatabaseReference.child("BaiTap").push().setValue(baitap);
                       Toast.makeText(TeacherExerciseInsert.this, "Insert Successfully!", Toast.LENGTH_LONG).show();
                       Clean();
                   }
                   else {
                       Toast.makeText(TeacherExerciseInsert.this, "Deadline is invalid!", Toast.LENGTH_LONG).show();
                   }

               }
               else
               {
                   Toast.makeText(TeacherExerciseInsert.this, "Please fill out the form", Toast.LENGTH_LONG).show();
               }
            }
        });

    }
    private void Clean()
    {
      //  tvFrom.setText("");
        tvTo.setText("");
        edtName.setText("");
        edtNoiDung.setText("");
        tvTime.setText("");
        Calendar calendar = Calendar.getInstance();
        int gio = calendar.get(Calendar.HOUR);
        int phut = calendar.get(Calendar.MINUTE);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String date = (simpleDateFormat.format(calendar.getTime()));
        tvFrom.setText(date);
        from=(gio+":"+phut).toString();
        time1=calendar;

    }
    private boolean CheckDeadlineValid(String day1, String day2, Calendar time1, Calendar time2){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = sdf.parse(day1);
            date2 = sdf.parse(day2);
            if(date2.after(date1))
            {
                return true;
            }
            if(date1.equals(date2))
            {
                if(time2.after(time1))
                {
                    return true;
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
}
