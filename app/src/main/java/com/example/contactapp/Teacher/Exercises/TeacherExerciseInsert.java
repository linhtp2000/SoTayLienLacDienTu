package com.example.contactapp.Teacher.Exercises;

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

import com.example.contactapp.Model.BaiTapSV;
import com.example.contactapp.Models.BaiGiang;
import com.example.contactapp.Models.BaiTap;
import com.example.contactapp.R;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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
    BaiGiang baiGiang;
    private static final String TAG = "ReadAndWriteSnippets";

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

        Intent intent=getIntent();
        BaiGiang bg =(BaiGiang) intent.getSerializableExtra("Baigiang");
        if(bg==null)
        {
            bg= new BaiGiang();
        }
        baiGiang=bg;
        tvCourse.setText("Course - "+bg.getKhoaHoc());
        tvClass.setText(bg.getName());

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


        btnCancel.setOnClickListener(new View.OnClickListener() {

          @Override
         public void onClick(View view) {
                       backToList();
         }
     });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(tvTo.getText().toString().trim().compareTo("") !=0 &&tvFrom.getText().toString().trim().compareTo("") !=0 && edtName.getText().toString().trim().compareTo("") !=0 &&
                       edtNoiDung.getText().toString().trim().compareTo("") !=0 && tvTime.getText().toString().trim().compareTo("") !=0) {
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
                       baitap.setBaiGiang(baiGiang.getId());
                       baitap.setGiaoVien(baiGiang.getGiaoVien());
                       baitap.setLstBaiTapSV(null);
                       Calendar calendar= Calendar.getInstance();
                       int giay=calendar.get(Calendar.MILLISECOND);
                       int gio=calendar.get(Calendar.HOUR);
                       int ngay=calendar.get(Calendar.DATE);
                       int thang=calendar.get(Calendar.MONTH);
                       int nam=calendar.get(Calendar.YEAR);
                       String idbaitap=(baitap.getBaiGiang()+baitap.getName()+ngay+thang+nam+gio+phut+giay).toString();
                       mDatabaseReference.child("BaiTap").child(idbaitap).setValue(baitap);
                       baitap.setId(idbaitap);
                       //Add bài tập
                       AddBaiTap(baitap);
                       Toast.makeText(TeacherExerciseInsert.this, "Insert Successfully!", Toast.LENGTH_LONG).show();
                       backToList();
                       //  Clean();
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
//    private void Clean()
//    {
//      //  tvFrom.setText("");
//        tvTo.setText("");
//        edtName.setText("");
//        edtNoiDung.setText("");
//        tvTime.setText("");
//        Calendar calendar = Calendar.getInstance();
//        int gio = calendar.get(Calendar.HOUR);
//        int phut = calendar.get(Calendar.MINUTE);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        String date = (simpleDateFormat.format(calendar.getTime()));
//        tvFrom.setText(date);
//        from=(gio+":"+phut).toString();
//        time1=calendar;
//
//    }
    private void AddBaiTap(BaiTap baiTap)
    {
        DatabaseReference mDatabaseReference2=mFirebaseDatabase.getReference().child("BaiTapSV");
        mDatabaseReference.child("TKB").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot1) {
                for (DataSnapshot snap : snapshot1.getChildren()) {
                    String id = snap.getKey();
                    mDatabaseReference.child("TKB").child(id).child("SinhVien").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            String idsv = snapshot.getValue(String.class);
                            mDatabaseReference.child("TKB").child(id).child("BaiGiang").addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    for (DataSnapshot snap : dataSnapshot.getChildren()) {
                                        String idbaigiang = snap.getValue(String.class);
                                        //  tkb.setId(snap.getKey());
                                        if (idbaigiang != null) {
                                            if (idbaigiang.equals(baiTap.getBaiGiang())) {
                                                BaiTapSV baiTapSV = new BaiTapSV();
                                                baiTapSV.setBaiTap(baiTap.getId());
                                                baiTapSV.setSinhVien(idsv);
                                                baiTapSV.setDiem(0);
                                                baiTapSV.setNgayNop("Chưa nộp");
                                                mDatabaseReference2.push().setValue(baiTapSV);
                                                break;
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

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
                @Override
                public void onCancelled (@NonNull DatabaseError error){

                }
        });
    }
private void backToList() {
    Intent intent = new Intent(TeacherExerciseInsert.this, TeacherExercisesActivity.class);
    intent.putExtra("Baigiang",baiGiang);
    startActivity(intent);
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
