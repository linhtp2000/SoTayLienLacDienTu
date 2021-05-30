package com.example.contactapp.Student;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactapp.Model.BaiTapSV;
import com.example.contactapp.Model.Deadline_item;
import com.example.contactapp.Model.Expire_Home;
import com.example.contactapp.Model.Student;
import com.example.contactapp.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.naishadhparmar.zcustomcalendar.CustomCalendar;
import org.naishadhparmar.zcustomcalendar.OnDateSelectedListener;
import org.naishadhparmar.zcustomcalendar.Property;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class Deadline extends AppCompatActivity {
    TextView time;
    TextView User;
    TextView date;
    DatabaseReference mDatabase;
    CustomCalendar customCalendar;
    String idBaiTap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deadline);




        //customCalendar
        customCalendar=findViewById(R.id.customCalendar);
        //Init decription hash map
        HashMap<java.lang.Object, Property> descHashMap = new HashMap<>();

        //Init default prop
        Property defaultProperty=new Property();
        //Init default resource
        defaultProperty.layoutResource=R.layout.default_view;
        //Init and assign variable
        defaultProperty.dateTextViewResource=R.id.text_view;
        //Put object and prop
        descHashMap.put("default",defaultProperty);

        //For current date
        Property currentProperty = new Property();
        currentProperty.layoutResource=R.layout.current_view;
        currentProperty.dateTextViewResource = R.id.text_view;
        descHashMap.put("current",currentProperty);
        //For present date
        Property presentProperty=new Property();
        presentProperty.layoutResource=R.layout.present_view;
        presentProperty.dateTextViewResource=R.id.text_view;
        descHashMap.put("present",presentProperty);

        //For absent
        Property absentProperty=new Property();
        absentProperty.layoutResource=R.layout.absent_view;
        absentProperty.dateTextViewResource=R.id.text_view;
        descHashMap.put("absent",absentProperty);

        //For deadline
        Property deadlineProperty=new Property();
        absentProperty.layoutResource=R.layout.deadline_day;
        absentProperty.dateTextViewResource=R.id.text_view;
        descHashMap.put("deadline",absentProperty);


        //set desc hash map on custom calendar
        customCalendar.setMapDescToProp(descHashMap);

        //Init date hash map
        HashMap<Integer, java.lang.Object> dateHashMap = new HashMap<>();
        //Init calendar
        Calendar calendar= Calendar.getInstance();
        //Put value
//        dateHashMap.put(13,"deadline");
//        dateHashMap.put(2,"deadline");
//        dateHashMap.put(3,"deadline");
//        dateHashMap.put(4,"absent");
//        dateHashMap.put(20,"present");
//        dateHashMap.put(30,"absent");


        customCalendar.setOnDateSelectedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(View view, Calendar selectedDate, java.lang.Object desc) {
                //get string date
                String sDate=selectedDate.get(Calendar.DAY_OF_MONTH)
                        + "/" + (selectedDate.get(Calendar.MONTH) + 1)
                        + "/" + selectedDate.get(Calendar.YEAR);
                //Toast
                Toast.makeText(getApplicationContext(),sDate,Toast.LENGTH_LONG).show();
            }
        });



        //recycleview
        RecyclerView recyclerViewDeadline =(RecyclerView) findViewById(R.id.deadline_recyler);
        recyclerViewDeadline.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(Deadline.this, LinearLayoutManager.VERTICAL, false);
        recyclerViewDeadline.setLayoutManager(layoutManager);
        ArrayList<Deadline_item> arrayListDeadLine = new ArrayList<>();
        ArrayList<BaiTapSV> baitapsv = new ArrayList<>();
//        arrayList.add(new Deadline_item("Xác suất thống kê", "Bài tập vui", "18/08/2018", "10:00 PM"));
//        arrayList.add(new Deadline_item("Xác suất thống kê 2", "Bài tập vui", "18/08/2018", "10:00 PM"));
//        arrayList.add(new Deadline_item("Xác suất thống kê 3", "Bài tập vui", "18/08/2018", "10:00 PM"));
//        arrayList.add(new Deadline_item("Xác suất thống kê 4", "Bài tập vui", "18/08/2018", "10:00 PM"));
//        arrayList.add(new Deadline_item("Xác suất thống kê 5", "Bài tập vui", "18/08/2018", "10:00 PM"));
//        arrayList.add(new Deadline_item("Xác suất thống kê 6", "Bài tập vui", "18/08/2018", "10:00 PM"));
        DeadlineAdapter deadlineAdapter = new DeadlineAdapter(arrayListDeadLine, Deadline.this);
        recyclerViewDeadline.setAdapter(deadlineAdapter);
        //Init FireBase
        mDatabase = FirebaseDatabase.getInstance().getReference();










        //Thời gian
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
        String currentTime = new SimpleDateFormat("HH:mm a", Locale.getDefault()).format(new Date());
        String Day = new SimpleDateFormat("EEE, d MMM yyyy", Locale.getDefault()).format(new Date());
        date=(TextView) findViewById(R.id.textView);
        date.setText(Day);
        time = (TextView) findViewById(R.id.textView10);
        time.setText(currentTime);
        User = (TextView) findViewById(R.id.textView4);
        if(ParentHome.UserRole.equals("")){
            User.setText("Wellcome, " + Home.NameUser);
            mDatabase.child("BaiTap").addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    Deadline_item deadline = snapshot.getValue(Deadline_item.class);
                    String key = snapshot.getKey();
                    if(Home.idBaiTap.equals(key)){
                        arrayListDeadLine.add(new Deadline_item(key,deadline.getName(),deadline.getDeadline(),deadline.getGiaoVien(),deadline.getBaitapSV(),deadline.getNoiDung(),deadline.getBaiGiang(),deadline.getNgayTao(),deadline.getThoiGianNop(),deadline.getThoiGianTao()));
                        String[] splits = deadline.getDeadline().split("/");
                        int date = 0;
                        for (String item : splits){
//                    System.out.println(item);
                            date = Integer.parseInt(item);
                            break;
                        }
                        dateHashMap.put(date,"absent");
//                arrayListDeadLine.add(new Deadline_item(deadline.getName(),deadline.getNoiDung(),deadline.getHanNop(),deadline.getThoiGianNop(),deadline.getThoiGianNop()));
                        deadlineAdapter.notifyDataSetChanged();

                        dateHashMap.put(calendar.get(Calendar.DAY_OF_MONTH),"current");
                        //set date

                        customCalendar.setDate(calendar,dateHashMap);
                    }
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }else {
            User.setText("Wellcome, " + ParentHome.NameUser);
            mDatabase.child("BaiTap").addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    Deadline_item deadline = snapshot.getValue(Deadline_item.class);
                    String key = snapshot.getKey();
                    if(ParentHome.idBaiTap.equals(key)){
                        arrayListDeadLine.add(new Deadline_item(key,deadline.getName(),deadline.getDeadline(),deadline.getGiaoVien(),deadline.getBaitapSV(),deadline.getNoiDung(),deadline.getBaiGiang(),deadline.getNgayTao(),deadline.getThoiGianNop(),deadline.getThoiGianTao()));
                        String[] splits = deadline.getDeadline().split("/");
                        int date = 0;
                        for (String item : splits){
//                    System.out.println(item);
                            date = Integer.parseInt(item);
                            break;
                        }
                        dateHashMap.put(date,"absent");
//                arrayListDeadLine.add(new Deadline_item(deadline.getName(),deadline.getNoiDung(),deadline.getHanNop(),deadline.getThoiGianNop(),deadline.getThoiGianNop()));
                        deadlineAdapter.notifyDataSetChanged();

                        dateHashMap.put(calendar.get(Calendar.DAY_OF_MONTH),"current");
                        //set date

                        customCalendar.setDate(calendar,dateHashMap);
                    }
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }


    }
}