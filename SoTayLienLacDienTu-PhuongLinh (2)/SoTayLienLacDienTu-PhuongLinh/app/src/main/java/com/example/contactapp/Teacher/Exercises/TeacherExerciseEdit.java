package com.example.contactapp.Teacher.Exercises;

import android.app.DatePickerDialog;
import android.app.Dialog;
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

public class TeacherExerciseEdit extends AppCompatActivity {
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private ChildEventListener mChildListener;
    private FirebaseUser mFirebaseUser;
    Button btnDelete, btnSave;
    ImageView btnFrom, btnTo,btnTime;
    EditText edtName, edtNoiDung;
    TextView tvCourse, tvClass,tvFrom,tvTo,tvTime;
    String from;
    Calendar to;

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
        btnDelete=findViewById(R.id.btnDelete);
        btnSave=findViewById(R.id.btnSave);
        btnFrom=findViewById(R.id.imgvFrom);
        btnTo=findViewById(R.id.imgvTo);
        btnTime=findViewById(R.id.imgvTime);
        tvTime=findViewById(R.id.tvTime);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference=mFirebaseDatabase.getReference();

        Intent intent=getIntent();
        BaiTap baitap =(BaiTap) intent.getSerializableExtra("Baitap");
        BaiGiang baigiang =(BaiGiang) intent.getSerializableExtra("Baigiang");
        tvCourse.setText("Course - "+baigiang.getKhoaHoc());
        tvClass.setText(baigiang.getMon());

        edtName.setText(baitap.getName());
        edtNoiDung.setText(baitap.getNoiDung());
        tvFrom.setText(baitap.getNgayTao());
        tvTo.setText(baitap.getDeadline());
        tvTime.setText(baitap.getThoiGianNop());
        from=baitap.getThoiGianTao().toString();

        btnTo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int ngay=calendar.get(Calendar.DATE);
                int thang=calendar.get(Calendar.MONTH);
                int nam=calendar.get(Calendar.YEAR);
                DatePickerDialog datePickerDialog=new DatePickerDialog(TeacherExerciseEdit.this, new DatePickerDialog.OnDateSetListener() {
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
                        tvTime.setText(hourOfDay+" : "+minute);
                        to=myCalendar;
                    }
                };
                new TimePickerDialog(TeacherExerciseEdit.this, t,
                        myCalendar.get(Calendar.HOUR_OF_DAY),
                        myCalendar.get(Calendar.MINUTE), true).show();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tvTo.getText()!="" && tvFrom.getText()!="" && edtName.getText().toString()!="" &&edtNoiDung.getText().toString()!="") {
                    String day1=tvFrom.getText().toString();
                    String day2=tvTo.getText().toString();
                    if(CheckDeadlineValid(day1,day2,from,to)==true) {
                        BaiTap baitap = new BaiTap();
                        baitap.setName(edtName.getText().toString());
                        baitap.setNoiDung(edtNoiDung.getText().toString());
                        baitap.setNgayTao(tvFrom.getText().toString());
                        baitap.setDeadline(tvTo.getText().toString());
                        baitap.setThoiGianNop(tvTime.getText().toString());
                        baitap.setBaiGiang(baigiang.getId());
                        baitap.setGiaoVien(baigiang.getGiaoVien());
                        baitap.setLstBaiTapSV(null);
                        mDatabaseReference.child("BaiTap").child(baitap.getId()).setValue(baitap);
                        Toast.makeText(TeacherExerciseEdit.this, "Edit Successfully!", Toast.LENGTH_LONG).show();
                        backToList();
                    }
                    else {
                        Toast.makeText(TeacherExerciseEdit.this, "Deadline is invalid!", Toast.LENGTH_LONG).show();
                    }

                }
                else
                {
                    Toast.makeText(TeacherExerciseEdit.this, "Please fill out the form", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Showdialog(baitap);
                backToList();
            }
        });

    }

    private boolean CheckDeadlineValid(String day1, String day2, String time1, Calendar time2){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = null;
        Date date2 = null;
        String[] words=time1.split(":");
        String s1=words[0], s2=words[1];
        try {
            date1 = sdf.parse(day1);
            date2 = sdf.parse(day2);
            if(date2.after(date1))
            {
                return true;
            }
            if(date1.equals(date2))
            {
                if(Integer.parseInt(s1)>time2.HOUR)
                {
                    return true;
                }
                else
                {
                    if(Integer.parseInt(s1)==time2.HOUR &&Integer.parseInt(s2)>time2.MINUTE)
                    { return true;}
                }
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }
    private void backToList() {
        Intent intent = new Intent(TeacherExerciseEdit.this, TeacherExercisesActivity.class);
        startActivity(intent);
    }
    public void Showdialog(BaiTap baitap){
        final Dialog dialog=new Dialog(this);
        dialog.setContentView(R.layout.dialogdelete);
        Button btnOK = (Button) dialog.findViewById(R.id.btnOK);
        Button btnCancel =(Button) dialog.findViewById(R.id.btnCancel);
        dialog.show();
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabaseReference.child("BaiTap").child(baitap.getId()).removeValue();
                Toast.makeText(TeacherExerciseEdit.this, "Delete successfully!", Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });
    }
}
