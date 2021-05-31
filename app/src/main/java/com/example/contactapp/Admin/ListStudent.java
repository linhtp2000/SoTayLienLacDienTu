package com.example.contactapp.Admin;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactapp.Admin.Adapter.AdapterClass;
import com.example.contactapp.Admin.Adapter.AdapterStudent;
import com.example.contactapp.Models.SinhVien;
import com.example.contactapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListStudent extends AppCompatActivity {

    RecyclerView recyclerView;
    AdapterStudent adapter;
    ArrayList<SinhVien> list;

    DatabaseReference database;

    private AdapterClass.RecyclerVieWClickListener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class_list);
        TextView className=findViewById(R.id.txtDayManager);
        String kh="";
        Bundle extras=getIntent().getExtras();
        if(extras!=null){
            kh=extras.getString("key");
        }
        className.setText(extras.getString("key"));








        database= FirebaseDatabase.getInstance().getReference("SinhVien");
        recyclerView=findViewById(R.id.rvListStudent);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<>();
        adapter= new AdapterStudent(this,list);
        recyclerView.setAdapter(adapter);
        database.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //list=new ArrayList<>();

                for (DataSnapshot dataSnapshot:snapshot.getChildren()){

                   SinhVien sinhVien=dataSnapshot.getValue(SinhVien.class);
                    sinhVien.setId(dataSnapshot.getKey());
                   String a=sinhVien.getLop();
                   String b=className.getText().toString();
                   Boolean check=a.equals(b);
                  if(check==true) {

                      list.add(sinhVien);
                  }



                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

//        TextView txtcourse=findViewById(R.id.txtCourseName);
//        String courseName=txtcourse.getText().toString();




















    }



//
//



}
