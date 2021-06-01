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

import com.example.contactapp.Admin.Adapter.AdapterCourse;
import com.example.contactapp.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class ListCourse  extends AppCompatActivity {
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private ChildEventListener mChildListener;
    Button delete;
    RecyclerView recyclerView;
    AdapterCourse adapter;
    ArrayList<String> list;
    DatabaseReference  database;
    DatabaseReference  databasechild;
    private AdapterCourse.RecyclerVieWClickListener listener;
    Dialog dialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listcourse);
        //get day
        Calendar calendar=Calendar.getInstance();
        SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd MMM,yyyy");
        SimpleDateFormat simpleDateFormatTime=new SimpleDateFormat("hh:mm");
        String currentTime=simpleDateFormatTime.format(calendar.getTime());
        String currentDate= simpleDateFormat.format(calendar.getTime());
        TextView txtTime=findViewById(R.id.txtTimeListManager);
        TextView txtDay=findViewById(R.id.txtDayManager);
        txtDay.setText(currentDate);
        txtTime.setText(currentTime);

        Button btnAddCourse=findViewById(R.id.btnAddManager);
         dialog=new Dialog(ListCourse.this);


        recyclerView=findViewById(R.id.rvManager);
        database= FirebaseDatabase.getInstance().getReference().child("KhoaHoc");





        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list=new ArrayList<>();

        adapter= new AdapterCourse(this,list, listener);
        recyclerView.setAdapter(adapter);
        database.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //list=new ArrayList<>();
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                  //  KhoaHoc course =dataSnapshot.getValue(KhoaHoc.class);
                    String key= dataSnapshot.getKey();

                    list.add(key);

                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        btnAddCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialogAddCourse();



            }
        });




    }
    private void openDialogAddCourse(){
        dialog.setContentView(R.layout.dialog_addcourse);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        EditText editTextAddCourse=dialog.findViewById(R.id.editTextAddCourse);
        Button btnSave=dialog.findViewById(R.id.btnSaveAddCourse);
        Button btnCancle =dialog.findViewById(R.id.btnCancleAddCourse);
        dialog.show();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean check=editTextAddCourse.toString().equals("");
                if(check==false)
                {

                FirebaseDatabase db=FirebaseDatabase.getInstance();
                DatabaseReference node=db.getReference("KhoaHoc");
                String text=editTextAddCourse.getText().toString();
                node.child(text).child("Tenlop").setValue("null");
                list.clear();
               // adapter.notifyDataSetChanged();
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



    }


}
