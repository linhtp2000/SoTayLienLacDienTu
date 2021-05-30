package com.example.contactapp.Student;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.example.contactapp.Model.Test_Schedule_Item;
import com.example.contactapp.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class TestSchedule extends AppCompatActivity {
    TextView date;
    TextView dataNumber;
    TextView monthYear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_schedule);

        RecyclerView recyclerViewTestSchedule =(RecyclerView) findViewById(R.id.test_schedule_recyler);
        recyclerViewTestSchedule.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(TestSchedule.this, LinearLayoutManager.VERTICAL, false);
        recyclerViewTestSchedule.setLayoutManager(layoutManager);
        ArrayList<Test_Schedule_Item> arrayList = new ArrayList<>();
        arrayList.add(new Test_Schedule_Item("Linh", "111" , "1111"));
        arrayList.add(new Test_Schedule_Item("Linh1", "111" , "1111"));
        arrayList.add(new Test_Schedule_Item("Linh2", "111" , "1111"));
        arrayList.add(new Test_Schedule_Item("Linh3", "111" , "1111"));
        arrayList.add(new Test_Schedule_Item("Linh4", "111" , "1111"));
        arrayList.add(new Test_Schedule_Item("Linh5", "111" , "1111"));
        arrayList.add(new Test_Schedule_Item("Linh6", "111" , "1111"));
        arrayList.add(new Test_Schedule_Item("Linh8", "111" , "1111"));
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
    }
}