package com.example.contactapp.Student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.contactapp.R;

import java.util.ArrayList;

public class Home extends AppCompatActivity {
    ArrayList<Noti_Home> arrayList;
    ArrayList<Expire_Home> arrayList2;
    NotiHomeAdapter notiHomeAdapter;
    ExpireHomeAdapter expireHomeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        RecyclerView recyclerViewNotiHome =(RecyclerView) findViewById(R.id.noti_home);
        recyclerViewNotiHome.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewNotiHome.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>();
        arrayList.add(new Noti_Home("Bài tập 1", "Test mid semester"));
        arrayList.add(new Noti_Home("Bài tập 2", "Test mid semester"));
        arrayList.add(new Noti_Home("Bài tập 3", "Test mid semester"));
        arrayList.add(new Noti_Home("Bài tập 4", "Test mid semester"));
        notiHomeAdapter = new NotiHomeAdapter(arrayList, this);
        recyclerViewNotiHome.setAdapter(notiHomeAdapter);


        RecyclerView recyclerViewExpireHome =(RecyclerView) findViewById(R.id.expire_home);
        recyclerViewExpireHome.setHasFixedSize(true);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewExpireHome.setLayoutManager(layoutManager2);
        arrayList2 = new ArrayList<>();
        arrayList2.add(new Expire_Home("Xác suất thống kê", "Bài tập vui", "10:00 PM"));
        arrayList2.add(new Expire_Home("Xác suất thống kê 2", "Bài tập vui", "10:00 PM"));
        arrayList2.add(new Expire_Home("Xác suất thống kê 3", "Bài tập vui", "10:00 PM"));
        arrayList2.add(new Expire_Home("Xác suất thống kê 4 ", "Bài tập vui", "10:00 PM"));
        arrayList2.add(new Expire_Home("Xác suất thống kê 5", "Bài tập vui", "10:00 PM"));
        expireHomeAdapter = new ExpireHomeAdapter(arrayList2, this);
        recyclerViewExpireHome.setAdapter(expireHomeAdapter);

        Button btn_testSchedule = (Button) findViewById(R.id.btn_testSchedule);
        btn_testSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, TestSchedule.class));
            }
        });

        Button btn_dealine = (Button) findViewById(R.id.btn_deadline);
        btn_dealine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Deadline.class));
            }
        });

        Button btn_point= (Button) findViewById(R.id.btn_point);
        btn_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, Point.class));
            }
        });

        Button btn_profile= (Button) findViewById(R.id.btn_profileStudent);
        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this, ProfileStudent.class));
            }
        });
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerViewNotiHome);
//        ItemTouchHelper itemTouchHelper2 = new ItemTouchHelper(simpleCallback2);
//        itemTouchHelper.attachToRecyclerView(recyclerViewExpireHome);
    }
   ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
       @Override
       public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
           return false;
       }

       @Override
       public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
           int position = viewHolder.getAdapterPosition();
            switch (direction){
                case ItemTouchHelper.LEFT:
                    arrayList.remove(position);
                    notiHomeAdapter.notifyItemRemoved(position);
                    break;
                case ItemTouchHelper.RIGHT:
                    startActivity(new Intent(Home.this, StydyPriceDetail.class));
                    break;
            }
       }
   };
//    ItemTouchHelper.SimpleCallback simpleCallback2 = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
//        @Override
//        public boolean onMove(@NonNull RecyclerView recyclerView2, @NonNull RecyclerView.ViewHolder viewHolder2, @NonNull RecyclerView.ViewHolder target2) {
//            return false;
//        }
//
//        @Override
//        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder2, int direction2) {
//            int position2 = viewHolder2.getAdapterPosition();
//            switch (direction2){
//                case ItemTouchHelper.LEFT:
//                    arrayList2.remove(position2);
//                    expireHomeAdapter.notifyItemRemoved(position2);
//                    break;
//            }
//        }
//    };
}