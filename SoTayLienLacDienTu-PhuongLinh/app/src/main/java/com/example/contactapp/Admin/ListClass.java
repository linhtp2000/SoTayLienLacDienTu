package com.example.contactapp.Admin;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactapp.Adapter.AdapterClass;
import com.example.contactapp.Models.Lop;
import com.example.contactapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ListClass extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterClass adapter;
    ArrayList<Lop> list;

    DatabaseReference database;

    private AdapterClass.RecyclerVieWClickListener listener;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listclass);
        TextView course=findViewById(R.id.txtCourseName);
         String kh="";
        Bundle extras=getIntent().getExtras();
        if(extras!=null){
            kh=extras.getString("key");
        }
        course.setText(kh);

        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd MMM,yyyy");
        SimpleDateFormat simpleDateFormatTime=new SimpleDateFormat("hh:mm");
        String currentTime=simpleDateFormatTime.format(calendar.getTime());
        String currentDate= simpleDateFormat.format(calendar.getTime());
        TextView txtTime=findViewById(R.id.txtTimeListManager);
        TextView txtDay=findViewById(R.id.txtDayManager);
        txtDay.setText(currentDate);
        txtTime.setText(currentTime);
        //

        Button btnAddClass=findViewById(R.id.btnAddClass);
        dialog=new Dialog(ListClass.this);




        recyclerView=findViewById(R.id.rvListClass);

//        TextView txtcourse=findViewById(R.id.txtCourseName);
//        String courseName=txtcourse.getText().toString();

        database= FirebaseDatabase.getInstance().getReference("Lop");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<>();

        adapter= new AdapterClass(this,list, listener);
        recyclerView.setAdapter(adapter);
        database.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //list=new ArrayList<>();

                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                  //  Lop lop=dataSnapshot.getValue(Lop.class);
                    Lop lop=dataSnapshot.getValue(Lop.class);
                    lop.setId(dataSnapshot.getKey());


                    String a=lop.getKhoaHoc().toString();
                    String b=course.getText().toString();
                    if(a.equals(b)==true) {

                        list.add(lop);
                    }


                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        btnAddClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialogAddClass();



            }
        });






    }

    private void openDialogAddClass(){
        dialog.setContentView(R.layout.dialog_addcourse);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        EditText editTextAddCourse=dialog.findViewById(R.id.editTextAddCourse);
        TextView txtNameDialog=dialog.findViewById(R.id.txtNameDialog);
        txtNameDialog.setText("Add Class");
        Button btnSave=dialog.findViewById(R.id.btnSaveAddCourse);
        Button btnCancle =dialog.findViewById(R.id.btnCancleAddCourse);
        dialog.show();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean check=editTextAddCourse.toString().equals("");
                if(check==false)
                {
                    //KhoaHoc obj= new KhoaHoc("null");
                    TextView nameCourse=findViewById(R.id.txtCourseName);
                    String name=nameCourse.getText().toString();
                    FirebaseDatabase db=FirebaseDatabase.getInstance();
                    //add lớp vào khoa
                    DatabaseReference node=db.getReference("KhoaHoc").child(name);
                    String text=editTextAddCourse.getText().toString();
                    node.child(text).setValue("class");
                    //add lớp vào DS Lớp
                    DatabaseReference node1=db.getReference("Lop");
                    TextView course=findViewById(R.id.txtCourseName);
                    Lop lop=new Lop(text,course.getText().toString());
                    node1.push().setValue(lop);




                    list.clear();

                    editTextAddCourse.setText("");
                    Toast.makeText(getApplicationContext(), "Thông tin đã được thêm", Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(getApplicationContext(), "Bạn chưa nhập thông tin", Toast.LENGTH_SHORT).show();
            }
        });

        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();


            }
        });


//
//
    }


    }
