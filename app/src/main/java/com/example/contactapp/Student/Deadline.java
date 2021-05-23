package com.example.contactapp.Student;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.contactapp.R;

import java.util.ArrayList;

public class Deadline extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deadline);
        RecyclerView recyclerViewDeadline =(RecyclerView) findViewById(R.id.deadline_recyler);
        recyclerViewDeadline.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(Deadline.this, LinearLayoutManager.VERTICAL, false);
        recyclerViewDeadline.setLayoutManager(layoutManager);
        ArrayList<Deadline_item> arrayList = new ArrayList<>();
        arrayList.add(new Deadline_item("Xác suất thống kê", "Bài tập vui", "18/08/2018", "10:00 PM"));
        arrayList.add(new Deadline_item("Xác suất thống kê 2", "Bài tập vui", "18/08/2018", "10:00 PM"));
        arrayList.add(new Deadline_item("Xác suất thống kê 3", "Bài tập vui", "18/08/2018", "10:00 PM"));
        arrayList.add(new Deadline_item("Xác suất thống kê 4", "Bài tập vui", "18/08/2018", "10:00 PM"));
        arrayList.add(new Deadline_item("Xác suất thống kê 5", "Bài tập vui", "18/08/2018", "10:00 PM"));
        arrayList.add(new Deadline_item("Xác suất thống kê 6", "Bài tập vui", "18/08/2018", "10:00 PM"));
        DeadlineAdapter deadlineAdapter = new DeadlineAdapter(arrayList, Deadline.this);
        recyclerViewDeadline.setAdapter(deadlineAdapter);
    }
}