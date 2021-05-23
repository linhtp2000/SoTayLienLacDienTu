package com.example.contactapp.Student;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.contactapp.R;

import java.util.ArrayList;

public class TestSchedule extends AppCompatActivity {

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
    }
}