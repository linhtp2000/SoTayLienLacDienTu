package com.example.contactapp.Student;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactapp.Model.BaiGiang;
import com.example.contactapp.Model.Deadline_item;
import com.example.contactapp.Model.ListScheduleItem;
import com.example.contactapp.Model.ScheduleKey;
import com.example.contactapp.Model.Schedule_List;
import com.example.contactapp.Model.Test_Schedule_Item;
import com.example.contactapp.Model.itemTKB;
import com.example.contactapp.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.naishadhparmar.zcustomcalendar.CustomCalendar;
import org.naishadhparmar.zcustomcalendar.Property;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class  Schedule extends AppCompatActivity {
    TextView time;
    TextView User;
    TextView date;
    TextView Title;
    TextView role;
    DatabaseReference mDatabase;
    //Init Calendar
    CustomCalendar customCalendar;
    ArrayList<Schedule_List> arraySchdule;
    ArrayList<BaiGiang> listBaiGiang;
    String keyTKB;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deadline);
        //customCalendar
        customCalendar=findViewById(R.id.customCalendar);
        //Init decription hash map
        HashMap<java.lang.Object, Property> descHashMap = new HashMap<>();

         role = (TextView) findViewById(R.id.textView9);
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


        //set desc hash map on custom calendar
        customCalendar.setMapDescToProp(descHashMap);

        //Init date hash map
        HashMap<Integer, java.lang.Object> dateHashMap = new HashMap<>();
        //Init calendar
        Calendar calendar= Calendar.getInstance();
        //Put value
//        dateHashMap.put(calendar.get(Calendar.TUESDAY),"absent");
//        dateHashMap.put(4,"absent");
//        dateHashMap.put(20,"absent");
//        dateHashMap.put(30,"absent");
//        dateHashMap.put(calendar.get(Calendar.DAY_OF_MONTH),"present");


        //set date



        RecyclerView recyclerViewDeadline =(RecyclerView) findViewById(R.id.deadline_recyler);
        recyclerViewDeadline.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(Schedule.this, LinearLayoutManager.VERTICAL, false);
        recyclerViewDeadline.setLayoutManager(layoutManager);
        ArrayList<Deadline_item> arrayListDeadLine = new ArrayList<>();
//        arrayListDeadLine.add(new Deadline_item("Xác suất thống kê", "Bài tập vui", "18/08/2018", "10:00 PM","a"));
//        arrayListDeadLine.add(new Deadline_item("Xác suất thống kê 2", "Bài tập vui", "18/08/2018", "10:00 PM","a"));
//        arrayListDeadLine.add(new Deadline_item("Xác suất thống kê 3", "Bài tập vui", "18/08/2018", "10:00 PM","a"));
//        arrayListDeadLine.add(new Deadline_item("Xác suất thống kê 4", "Bài tập vui", "18/08/2018", "10:00 PM","a"));
//        arrayListDeadLine.add(new Deadline_item("Xác suất thống kê 5", "Bài tập vui", "18/08/2018", "10:00 PM","a"));
//        arrayListDeadLine.add(new Deadline_item("Xác suất thống kê 6", "Bài tập vui", "18/08/2018", "10:00 PM","a"));
        DeadlineAdapter deadlineAdapter = new DeadlineAdapter(arrayListDeadLine, Schedule.this);
        recyclerViewDeadline.setAdapter(deadlineAdapter);
        //Init FireBase
        mDatabase = FirebaseDatabase.getInstance().getReference();
        arraySchdule=new ArrayList<>();



        listBaiGiang=new ArrayList<>();
        ArrayList<String> listThu = new ArrayList<>();
//        mDatabase.child("BaiGiang").addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                BaiGiang scheduleBaiGiang = snapshot.getValue(BaiGiang.class);
//                String key = snapshot.getKey();
//                listBaiGiang.add(new BaiGiang(key,scheduleBaiGiang.getGiaoVien(),scheduleBaiGiang.getHocKy(),scheduleBaiGiang.getKhoa(),scheduleBaiGiang.getKhoaHoc(),scheduleBaiGiang.getMon(),scheduleBaiGiang.getName(),scheduleBaiGiang.getPhong(),scheduleBaiGiang.getThoiGian(),scheduleBaiGiang.getThu()));
////                arraySchdule.get(0).BaiGiang.
//                switch (scheduleBaiGiang.getThu()){
//                    case "Thứ Hai":
//                        listThu.add("Mon");
//                        LocalDate start = LocalDate.of( 2021 , 6 , 1 );
//                        LocalDate stop = LocalDate.of( 2021 , 6 , 30 );
//                        LocalDate monday = start.with( TemporalAdjusters.nextOrSame( DayOfWeek.MONDAY ) );
//                        while( monday.isBefore( stop ) ) {
//                            dateHashMap.put(monday.getDayOfMonth(),"absent");
//                            // Set up the next loop.
//                            monday = monday.plusWeeks( 1 );
////                            int datee1 = monday.getDayOfMonth();
//                        }
//                        break;
//                    case "Thứ Ba":
//                        listThu.add("Tue");
//                        LocalDate tuesday = LocalDate.of( 2021 , 6 , 1 ).with( TemporalAdjusters.nextOrSame( DayOfWeek.TUESDAY ) );
//                        while( tuesday.isBefore( LocalDate.of( 2021 , 6 , 30 ) ) ) {
//                            dateHashMap.put(tuesday.getDayOfMonth(),"absent");
//                            // Set up the next loop.
//                            tuesday = tuesday.plusWeeks( 1 );
////                            int datee1 = monday.getDayOfMonth();
//                        }
//                        break;
//                    case "Thứ Tư":
//                        listThu.add("Wed");
//                        LocalDate wednesday = LocalDate.of( 2021 , 6 , 1 ).with( TemporalAdjusters.nextOrSame( DayOfWeek.WEDNESDAY ) );
//                        while( wednesday.isBefore( LocalDate.of( 2021 , 6 , 30 ) ) ) {
//                            dateHashMap.put(wednesday.getDayOfMonth(),"absent");
//                            // Set up the next loop.
//                            wednesday = wednesday.plusWeeks( 1 );
////                            int datee1 = monday.getDayOfMonth();
//                        }
//                        break;
//                    case "Thứ Năm":
//                        listThu.add("Thu");
//                        LocalDate thursday = LocalDate.of( 2021 , 6 , 1 ).with( TemporalAdjusters.nextOrSame( DayOfWeek.THURSDAY ) );
//                        while( thursday.isBefore( LocalDate.of( 2021 , 6 , 30 ) ) ) {
//                            dateHashMap.put(thursday.getDayOfMonth(),"absent");
//                            // Set up the next loop.
//                            thursday = thursday.plusWeeks( 1 );
////                            int datee1 = monday.getDayOfMonth();
//                        }
//                        break;
//                    case "Thứ Sáu":
//                        listThu.add("Fri");
//                        LocalDate friday = LocalDate.of( 2021 , 6 , 1 ).with( TemporalAdjusters.nextOrSame( DayOfWeek.FRIDAY ) );
//                        while( friday.isBefore( LocalDate.of( 2021 , 6 , 30 ) ) ) {
//                            dateHashMap.put(friday.getDayOfMonth(),"absent");
//                            // Set up the next loop.
//                            friday = friday.plusWeeks( 1 );
////                            int datee1 = monday.getDayOfMonth();
//                        }
//                        break;
//                    case "Thứ Bảy":
//                        listThu.add("Sat");
//                        LocalDate Satuday = LocalDate.of( 2021 , 6 , 1 ).with( TemporalAdjusters.nextOrSame( DayOfWeek.SATURDAY ) );
//                        while( Satuday.isBefore( LocalDate.of( 2021 , 6 , 30 ) ) ) {
//                            dateHashMap.put(Satuday.getDayOfMonth(),"absent");
//                            // Set up the next loop.
//                            Satuday = Satuday.plusWeeks( 1 );
////                            int datee1 = monday.getDayOfMonth();
//                        }
//                        break;
//                }
//                dateHashMap.put(calendar.get(Calendar.DAY_OF_MONTH),"present");
//                customCalendar.setDate(calendar,dateHashMap);
//                deadlineAdapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
////
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });






//        customCalendar.setOnDateSelectedListener(new OnDateSelectedListener() {
//            @Override
//            public void onDateSelected(View view, Calendar selectedDate, java.lang.Object desc) {
//                //get string date
//                String sDate=selectedDate.get(Calendar.DAY_OF_MONTH)
//                        + "/" + (selectedDate.get(Calendar.MONTH) + 1)
//                        + "/" + selectedDate.get(Calendar.YEAR);
//                //Toast
//                Toast.makeText(getApplicationContext(),sDate,Toast.LENGTH_LONG).show();
//            }
//        });
        ArrayList<ScheduleKey> arScheduleKey = new ArrayList<>();
        ArrayList<Test_Schedule_Item> arrayList = new ArrayList<>();

        if(ParentHome.UserRole.equals("")){
            mDatabase.child("TKB").addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    itemTKB schedule = snapshot.getValue(itemTKB.class);
                    if(Home.Id.equals(schedule.getSinhVien())){
                        String keyTKB=snapshot.getKey();
                        Schedule_List listSchedule = snapshot.getValue(Schedule_List.class);
                        mDatabase.child("TKB").child(keyTKB).child("BaiGiang").addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(@NonNull DataSnapshot snapshot1, @Nullable String previousChildName) {
                                String listKeySchedule= (String) snapshot1.getValue();
                                String key=snapshot1.getKey();
                                arScheduleKey.add(new ScheduleKey(key,listKeySchedule));
                                mDatabase.child("BaiGiang").addChildEventListener(new ChildEventListener() {
                                    @Override
                                    public void onChildAdded(@NonNull DataSnapshot snapshot2, @Nullable String previousChildName) {
                                        BaiGiang scheduleBaiGiang = snapshot2.getValue(BaiGiang.class);
                                        String keyTest = snapshot2.getKey();
                                        for (int i = 0 ;i<arScheduleKey.size();i++){
                                            if (keyTest.equals(arScheduleKey.get(i).getKeyBaiGiang())){
                                                listBaiGiang.add(new BaiGiang(key,scheduleBaiGiang.getGiaoVien(),scheduleBaiGiang.getHocKy(),scheduleBaiGiang.getKhoa(),scheduleBaiGiang.getKhoaHoc(),scheduleBaiGiang.getMon(),scheduleBaiGiang.getName(),scheduleBaiGiang.getPhong(),scheduleBaiGiang.getThoiGian(),scheduleBaiGiang.getThu()));
//                arraySchdule.get(0).BaiGiang.
                                                switch (scheduleBaiGiang.getThu()){
                                                    case "Thứ Hai":
                                                        listThu.add("Mon");
                                                        LocalDate start = LocalDate.of( 2021 , 6 , 1 );
                                                        LocalDate stop = LocalDate.of( 2021 , 6 , 30 );
                                                        LocalDate monday = start.with( TemporalAdjusters.nextOrSame( DayOfWeek.MONDAY ) );
                                                        while( monday.isBefore( stop ) ) {
                                                            dateHashMap.put(monday.getDayOfMonth(),"absent");
                                                            // Set up the next loop.
                                                            monday = monday.plusWeeks( 1 );
//                            int datee1 = monday.getDayOfMonth();
                                                        }
                                                        break;
                                                    case "Thứ Ba":
                                                        listThu.add("Tue");
                                                        LocalDate tuesday = LocalDate.of( 2021 , 6 , 1 ).with( TemporalAdjusters.nextOrSame( DayOfWeek.TUESDAY ) );
                                                        while( tuesday.isBefore( LocalDate.of( 2021 , 6 , 30 ) ) ) {
                                                            dateHashMap.put(tuesday.getDayOfMonth(),"absent");
                                                            // Set up the next loop.
                                                            tuesday = tuesday.plusWeeks( 1 );
//                            int datee1 = monday.getDayOfMonth();
                                                        }
                                                        break;
                                                    case "Thứ Tư":
                                                        listThu.add("Wed");
                                                        LocalDate wednesday = LocalDate.of( 2021 , 6 , 1 ).with( TemporalAdjusters.nextOrSame( DayOfWeek.WEDNESDAY ) );
                                                        while( wednesday.isBefore( LocalDate.of( 2021 , 6 , 30 ) ) ) {
                                                            dateHashMap.put(wednesday.getDayOfMonth(),"absent");
                                                            // Set up the next loop.
                                                            wednesday = wednesday.plusWeeks( 1 );
//                            int datee1 = monday.getDayOfMonth();
                                                        }
                                                        break;
                                                    case "Thứ Năm":
                                                        listThu.add("Thu");
                                                        LocalDate thursday = LocalDate.of( 2021 , 6 , 1 ).with( TemporalAdjusters.nextOrSame( DayOfWeek.THURSDAY ) );
                                                        while( thursday.isBefore( LocalDate.of( 2021 , 6 , 30 ) ) ) {
                                                            dateHashMap.put(thursday.getDayOfMonth(),"absent");
                                                            // Set up the next loop.
                                                            thursday = thursday.plusWeeks( 1 );
//                            int datee1 = monday.getDayOfMonth();
                                                        }
                                                        break;
                                                    case "Thứ Sáu":
                                                        listThu.add("Fri");
                                                        LocalDate friday = LocalDate.of( 2021 , 6 , 1 ).with( TemporalAdjusters.nextOrSame( DayOfWeek.FRIDAY ) );
                                                        while( friday.isBefore( LocalDate.of( 2021 , 6 , 30 ) ) ) {
                                                            dateHashMap.put(friday.getDayOfMonth(),"absent");
                                                            // Set up the next loop.
                                                            friday = friday.plusWeeks( 1 );
//                            int datee1 = monday.getDayOfMonth();
                                                        }
                                                        break;
                                                    case "Thứ Bảy":
                                                        listThu.add("Sat");
                                                        LocalDate Satuday = LocalDate.of( 2021 , 6 , 1 ).with( TemporalAdjusters.nextOrSame( DayOfWeek.SATURDAY ) );
                                                        while( Satuday.isBefore( LocalDate.of( 2021 , 6 , 30 ) ) ) {
                                                            dateHashMap.put(Satuday.getDayOfMonth(),"absent");
                                                            // Set up the next loop.
                                                            Satuday = Satuday.plusWeeks( 1 );
//                            int datee1 = monday.getDayOfMonth();
                                                        }
                                                        break;
                                                }
                                                dateHashMap.put(calendar.get(Calendar.DAY_OF_MONTH),"present");
                                                customCalendar.setDate(calendar,dateHashMap);
                                                deadlineAdapter.notifyDataSetChanged();
                                            }

                                        }
                                        dateHashMap.put(calendar.get(Calendar.DAY_OF_MONTH),"current");
                                        customCalendar.setDate(calendar,dateHashMap);
                                    }

                                    @Override
                                    public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

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

                            @Override
                            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

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

                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

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
            role.setText("Parent");
            mDatabase.child("TKB").addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    itemTKB schedule = snapshot.getValue(itemTKB.class);
                    if(ParentHome.idChild.equals(schedule.getSinhVien())){
                        String keyTKB=snapshot.getKey();
                        Schedule_List listSchedule = snapshot.getValue(Schedule_List.class);
                        mDatabase.child("TKB").child(keyTKB).child("BaiGiang").addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(@NonNull DataSnapshot snapshot1, @Nullable String previousChildName) {
                                String listKeySchedule= (String) snapshot1.getValue();
                                String key=snapshot1.getKey();
                                arScheduleKey.add(new ScheduleKey(key,listKeySchedule));
                                mDatabase.child("BaiGiang").addChildEventListener(new ChildEventListener() {
                                    @Override
                                    public void onChildAdded(@NonNull DataSnapshot snapshot2, @Nullable String previousChildName) {
                                        BaiGiang scheduleBaiGiang = snapshot2.getValue(BaiGiang.class);
                                        String keyTest = snapshot2.getKey();
                                        for (int i = 0 ;i<arScheduleKey.size();i++){
                                            if (keyTest.equals(arScheduleKey.get(i).getKeyBaiGiang())){
                                                listBaiGiang.add(new BaiGiang(key,scheduleBaiGiang.getGiaoVien(),scheduleBaiGiang.getHocKy(),scheduleBaiGiang.getKhoa(),scheduleBaiGiang.getKhoaHoc(),scheduleBaiGiang.getMon(),scheduleBaiGiang.getName(),scheduleBaiGiang.getPhong(),scheduleBaiGiang.getThoiGian(),scheduleBaiGiang.getThu()));
//                arraySchdule.get(0).BaiGiang.
                                                switch (scheduleBaiGiang.getThu()){
                                                    case "Thứ Hai":
                                                        listThu.add("Mon");
                                                        LocalDate start = LocalDate.of( 2021 , 6 , 1 );
                                                        LocalDate stop = LocalDate.of( 2021 , 6 , 30 );
                                                        LocalDate monday = start.with( TemporalAdjusters.nextOrSame( DayOfWeek.MONDAY ) );
                                                        while( monday.isBefore( stop ) ) {
                                                            dateHashMap.put(monday.getDayOfMonth(),"absent");
                                                            // Set up the next loop.
                                                            monday = monday.plusWeeks( 1 );
//                            int datee1 = monday.getDayOfMonth();
                                                        }
                                                        break;
                                                    case "Thứ Ba":
                                                        listThu.add("Tue");
                                                        LocalDate tuesday = LocalDate.of( 2021 , 6 , 1 ).with( TemporalAdjusters.nextOrSame( DayOfWeek.TUESDAY ) );
                                                        while( tuesday.isBefore( LocalDate.of( 2021 , 6 , 30 ) ) ) {
                                                            dateHashMap.put(tuesday.getDayOfMonth(),"absent");
                                                            // Set up the next loop.
                                                            tuesday = tuesday.plusWeeks( 1 );
//                            int datee1 = monday.getDayOfMonth();
                                                        }
                                                        break;
                                                    case "Thứ Tư":
                                                        listThu.add("Wed");
                                                        LocalDate wednesday = LocalDate.of( 2021 , 6 , 1 ).with( TemporalAdjusters.nextOrSame( DayOfWeek.WEDNESDAY ) );
                                                        while( wednesday.isBefore( LocalDate.of( 2021 , 6 , 30 ) ) ) {
                                                            dateHashMap.put(wednesday.getDayOfMonth(),"absent");
                                                            // Set up the next loop.
                                                            wednesday = wednesday.plusWeeks( 1 );
//                            int datee1 = monday.getDayOfMonth();
                                                        }
                                                        break;
                                                    case "Thứ Năm":
                                                        listThu.add("Thu");
                                                        LocalDate thursday = LocalDate.of( 2021 , 6 , 1 ).with( TemporalAdjusters.nextOrSame( DayOfWeek.THURSDAY ) );
                                                        while( thursday.isBefore( LocalDate.of( 2021 , 6 , 30 ) ) ) {
                                                            dateHashMap.put(thursday.getDayOfMonth(),"absent");
                                                            // Set up the next loop.
                                                            thursday = thursday.plusWeeks( 1 );
//                            int datee1 = monday.getDayOfMonth();
                                                        }
                                                        break;
                                                    case "Thứ Sáu":
                                                        listThu.add("Fri");
                                                        LocalDate friday = LocalDate.of( 2021 , 6 , 1 ).with( TemporalAdjusters.nextOrSame( DayOfWeek.FRIDAY ) );
                                                        while( friday.isBefore( LocalDate.of( 2021 , 6 , 30 ) ) ) {
                                                            dateHashMap.put(friday.getDayOfMonth(),"absent");
                                                            // Set up the next loop.
                                                            friday = friday.plusWeeks( 1 );
//                            int datee1 = monday.getDayOfMonth();
                                                        }
                                                        break;
                                                    case "Thứ Bảy":
                                                        listThu.add("Sat");
                                                        LocalDate Satuday = LocalDate.of( 2021 , 6 , 1 ).with( TemporalAdjusters.nextOrSame( DayOfWeek.SATURDAY ) );
                                                        while( Satuday.isBefore( LocalDate.of( 2021 , 6 , 30 ) ) ) {
                                                            dateHashMap.put(Satuday.getDayOfMonth(),"absent");
                                                            // Set up the next loop.
                                                            Satuday = Satuday.plusWeeks( 1 );
//                            int datee1 = monday.getDayOfMonth();
                                                        }
                                                        break;
                                                }
                                                dateHashMap.put(calendar.get(Calendar.DAY_OF_MONTH),"present");
                                                customCalendar.setDate(calendar,dateHashMap);
                                                deadlineAdapter.notifyDataSetChanged();
                                            }

                                        }
                                        dateHashMap.put(calendar.get(Calendar.DAY_OF_MONTH),"current");
                                        customCalendar.setDate(calendar,dateHashMap);
                                    }

                                    @Override
                                    public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

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

                            @Override
                            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

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

                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

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
        }
        else {
            User.setText("Wellcome, " + ParentHome.NameUser);
        }
        Title = (TextView) findViewById(R.id.textView11);
        Title.setText("Schedule");
    }


}