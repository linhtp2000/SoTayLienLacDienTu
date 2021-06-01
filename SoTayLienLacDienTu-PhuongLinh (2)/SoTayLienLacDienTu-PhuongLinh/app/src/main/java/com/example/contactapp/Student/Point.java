package com.example.contactapp.Student;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.contactapp.R;

import java.util.ArrayList;

public class Point extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point);
        Spinner spinner = (Spinner) findViewById(R.id.spinner_semester);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Học kì 1");
        arrayList.add("Học kì 2");
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Point.this, arrayList.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        RecyclerView recyclerViewPoint =(RecyclerView) findViewById(R.id.recyler_state);
        recyclerViewPoint.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(Point.this, LinearLayoutManager.VERTICAL, false);
        recyclerViewPoint.setLayoutManager(layoutManager);
        ArrayList<Object> arrayListObject = new ArrayList<>();
        arrayListObject.add(new Object("Toán 2"));
        arrayListObject.add(new Object("Lý 2"));
        arrayListObject.add(new Object("Hóa 2"));
        arrayListObject.add(new Object("Sinh 2"));
        arrayListObject.add(new Object("Địa 2"));


        ObjectAdapter objectAdapter = new ObjectAdapter(arrayListObject, Point.this);
        recyclerViewPoint.setAdapter(objectAdapter);
    }
}