package com.example.contactapp.Student;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.contactapp.Model.BaiGiang;
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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class TestSchedule extends AppCompatActivity {
    TextView date;
    TextView dataNumber;
    TextView monthYear;

    DatabaseReference mDatabase;

    CustomCalendar customCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_schedule);

        //customCalendar
        customCalendar=findViewById(R.id.customCalendarTest);
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

//        dateHashMap.put(20,"present");
//        dateHashMap.put(30,"absent");
        customCalendar.setDate(calendar,dateHashMap);




        RecyclerView recyclerViewTestSchedule =(RecyclerView) findViewById(R.id.test_schedule_recyler);
        recyclerViewTestSchedule.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(TestSchedule.this, LinearLayoutManager.VERTICAL, false);
        recyclerViewTestSchedule.setLayoutManager(layoutManager);
        ArrayList<Test_Schedule_Item> arrayList = new ArrayList<>();



//        arrayList.add(new Test_Schedule_Item("Linh", "111" , "1111"));
//        arrayList.add(new Test_Schedule_Item("Linh1", "111" , "1111"));
//        arrayList.add(new Test_Schedule_Item("Linh2", "111" , "1111"));
//        arrayList.add(new Test_Schedule_Item("Linh3", "111" , "1111"));
//        arrayList.add(new Test_Schedule_Item("Linh4", "111" , "1111"));
//        arrayList.add(new Test_Schedule_Item("Linh5", "111" , "1111"));
//        arrayList.add(new Test_Schedule_Item("Linh6", "111" , "1111"));
//        arrayList.add(new Test_Schedule_Item("Linh8", "111" , "1111"));
        TestScheduleAdapter testScheduleAdapter = new TestScheduleAdapter(arrayList, TestSchedule.this);
        recyclerViewTestSchedule.setAdapter(testScheduleAdapter);



        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
        String currentTime = new SimpleDateFormat("HH:mm a", Locale.getDefault()).format(new Date());
        String DayNumber = new SimpleDateFormat("dd" , Locale.getDefault()).format(new Date());
        String Day = new SimpleDateFormat("EEE ", Locale.getDefault()).format(new Date());
        String MonthYear = new SimpleDateFormat("MMM, yyyy ", Locale.getDefault()).format(new Date());
        monthYear=(TextView) findViewById(R.id.textView10);
        monthYear.setText(MonthYear);
        dataNumber=(TextView) findViewById(R.id.textView);
        dataNumber.setText(DayNumber);
        date=(TextView) findViewById(R.id.textView9);
        date.setText(Day);


        ArrayList<ScheduleKey> arScheduleKey = new ArrayList<>();

        mDatabase = FirebaseDatabase.getInstance().getReference();
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
                                mDatabase.child("KiemTra").addChildEventListener(new ChildEventListener() {
                                    @Override
                                    public void onChildAdded(@NonNull DataSnapshot snapshot2, @Nullable String previousChildName) {
                                        ListScheduleItem listTest = snapshot2.getValue(ListScheduleItem.class);
                                        String keyTest = snapshot2.getKey();
                                        for (int i = 0 ;i<arScheduleKey.size();i++){
                                            if(arrayList.size()==0){
                                                if (keyTest.equals(arScheduleKey.get(i).getKeyBaiGiang())){
                                                    arrayList.add(new Test_Schedule_Item(listTest.getName(),listTest.getTime(),listTest.getDay()));
                                                    String[] splits = listTest.getDay().split("/");
                                                    int date = 0;
                                                    for (String item : splits){
//                                                      System.out.println(item);
                                                        date = Integer.parseInt(item);
                                                        break;
                                                    }
                                                    dateHashMap.put(date,"absent");
                                                    testScheduleAdapter.notifyDataSetChanged();
                                                }
                                                break;
                                            }else {
                                                if (keyTest.equals(arScheduleKey.get(i + 1).getKeyBaiGiang())){
                                                    arrayList.add(new Test_Schedule_Item(listTest.getName(),listTest.getTime(),listTest.getDay()));
                                                    String[] splits = listTest.getDay().split("/");
                                                    int date = 0;
                                                    for (String item : splits){
//                                                      System.out.println(item);
                                                        date = Integer.parseInt(item);
                                                        break;
                                                    }
                                                    dateHashMap.put(date,"absent");
                                                    testScheduleAdapter.notifyDataSetChanged();
                                                }
                                                break;
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
                                mDatabase.child("KiemTra").addChildEventListener(new ChildEventListener() {
                                    @Override
                                    public void onChildAdded(@NonNull DataSnapshot snapshot2, @Nullable String previousChildName) {
                                        ListScheduleItem listTest = snapshot2.getValue(ListScheduleItem.class);
                                        String keyTest = snapshot2.getKey();
                                        for (int i = 0 ;i<arScheduleKey.size();i++){
                                            if(arrayList.size()==0){
                                                if (keyTest.equals(arScheduleKey.get(i).getKeyBaiGiang())){
                                                    arrayList.add(new Test_Schedule_Item(listTest.getName(),listTest.getTime(),listTest.getDay()));
                                                    String[] splits = listTest.getDay().split("/");
                                                    int date = 0;
                                                    for (String item : splits){
//                                                      System.out.println(item);
                                                        date = Integer.parseInt(item);
                                                        break;
                                                    }
                                                    dateHashMap.put(date,"absent");
                                                    testScheduleAdapter.notifyDataSetChanged();
                                                }
                                                break;
                                            }else {
                                                if (keyTest.equals(arScheduleKey.get(i + 1).getKeyBaiGiang())){
                                                    arrayList.add(new Test_Schedule_Item(listTest.getName(),listTest.getTime(),listTest.getDay()));
                                                    String[] splits = listTest.getDay().split("/");
                                                    int date = 0;
                                                    for (String item : splits){
//                                                      System.out.println(item);
                                                        date = Integer.parseInt(item);
                                                        break;
                                                    }
                                                    dateHashMap.put(date,"absent");
                                                    testScheduleAdapter.notifyDataSetChanged();
                                                }
                                                break;
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





    }
}