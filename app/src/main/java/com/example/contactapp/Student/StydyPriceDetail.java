package com.example.contactapp.Student;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactapp.Model.Noti_Home;
import com.example.contactapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class StydyPriceDetail extends AppCompatActivity {
    int IdNoti=Home.IdNoti;
    int IdExpire=Home.IdExpire;
    TextView time;
    TextView User;
    TextView date;
    DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Thời gian
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
        String currentTime = new SimpleDateFormat("HH:mm a", Locale.getDefault()).format(new Date());
        mDatabase = FirebaseDatabase.getInstance().getReference();
        setContentView(R.layout.activity_stydy_price_detail);
        String Day = new SimpleDateFormat("EEE, d MMM yyyy", Locale.getDefault()).format(new Date());
        date=(TextView) findViewById(R.id.textView);
        date.setText(Day);
        time = (TextView) findViewById(R.id.textView10);
        time.setText(currentTime);
        User = (TextView) findViewById(R.id.textView4);
        User.setText("Wellcome, " + Home.NameUser);


        TextView title =(TextView) findViewById(R.id.tvTitle);
        TextView nguoiGui = (TextView) findViewById(R.id.tvNguoiGui);
        TextView decrip = (TextView) findViewById(R.id.tvDecrip);
        if(ParentHome.UserRole.equals("")){
            if(IdNoti!=-1){
                title.setText("Tiêu đề: " + Home.name);
                nguoiGui.setText("Người gửi: "+Home.nguoiGui);
                decrip.setText("Nội dung: " + Home.decrip);
            }else {
                title.setText("Tiêu đề: "+Home.name);
                nguoiGui.setText("Deadline: "+ Home.nguoiGui);
                decrip.setText("Nội dung: " + Home.decrip);
            }
        }else {
            if(IdNoti!=-1){
                title.setText("Tiêu đề: " + ParentHome.name);
                nguoiGui.setText("Người gửi: "+ParentHome.nguoiGui);
                decrip.setText("Nội dung: " + ParentHome.decrip);
            }else {
                title.setText("Tiêu đề: "+ParentHome.name);
                nguoiGui.setText("Deadline: "+ ParentHome.nguoiGui);
                decrip.setText("Nội dung: " + ParentHome.decrip);
            }
        }

    }
}