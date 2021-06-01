package com.example.contactapp.Student;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactapp.LoginActivity;
import com.example.contactapp.Model.BaiTapSV;
import com.example.contactapp.Model.Expire_Home;
import com.example.contactapp.Model.Noti_Home;
import com.example.contactapp.Model.Parent;
import com.example.contactapp.Model.Student;
import com.example.contactapp.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class ParentHome extends AppCompatActivity {
    ArrayList<Noti_Home> arrayListNotificate;
    ArrayList<Expire_Home> arrayList2;
    ArrayList<Parent> arrayListParent;
    ArrayList<Student> arrayListStudent;
    NotiHomeAdapter notiHomeAdapter;
    ExpireHomeAdapter expireHomeAdapter;
    DatabaseReference mDatabase;
    TextView time;
    TextView date;
    TextView User;
    TextView Role;
    public static String UserRole="";
    public static String Id= LoginActivity.IdUser;
    public static String idChild;
    public static String NameUser;
    public static String NameChild;
    public static String PhoneUser;
    public static String MailUser;
    public static String AddressUser;
    public static String ClassUser;
    public static int IdNoti;
    public static int IdExpire;
    public static String name;
    public static String nguoiGui;
    public static String decrip;
    public static String idBaiTap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Init FireBase
        mDatabase = FirebaseDatabase.getInstance().getReference();
        setContentView(R.layout.activity_home);
        UserRole="parent";
        //Thời gian
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
        String currentTime = new SimpleDateFormat("HH:mm a", Locale.getDefault()).format(new Date());
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault());
        String Day = new SimpleDateFormat("EEE, d MMM yyyy", Locale.getDefault()).format(new Date());
        Role=(TextView) findViewById(R.id.textView9);
        Role.setText("Parent");
        date=(TextView) findViewById(R.id.textView);
        date.setText(Day);

        time = (TextView) findViewById(R.id.textView10);
        time.setText(currentTime);




        //getUser
        arrayListParent=new ArrayList<>();

        User = (TextView) findViewById(R.id.textView4);


        mDatabase.child("PhuHuynh").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Parent parent = snapshot.getValue(Parent.class);
                String key = snapshot.getKey();
                if(key.equals(Id)){
                    arrayListParent.add(new Parent(key,parent.getEmail(),parent.getName(),parent.getPhone(),parent.getSinhVien(),parent.getAddress()));
                    User.setText("Wellcome, " + arrayListParent.get(0).getName());
                    idChild=arrayListParent.get(0).getSinhVien();
                    NameUser=arrayListParent.get(0).getName();
                    PhoneUser=arrayListParent.get(0).getPhone();
                    MailUser=arrayListParent.get(0).getEmail();
                    AddressUser=arrayListParent.get(0).getAddress();
                }
                notiHomeAdapter.notifyDataSetChanged();
                mDatabase.child("SinhVien").addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                        Student student = snapshot.getValue(Student.class);
                        String key = snapshot.getKey();
                        if(key.equals(idChild)){
                            arrayListStudent.add(new Student(key,student.getEmail(),student.getLop(),student.getPhone(),student.getName(),student.getAddress(),student.getMSSV()));
                            NameChild=arrayListStudent.get(0).getName();
                        }
                        notiHomeAdapter.notifyDataSetChanged();
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
                ArrayList<BaiTapSV> baitapsv = new ArrayList<>();
                mDatabase.child("BaiTapSV").addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                        BaiTapSV baitap = snapshot.getValue(BaiTapSV.class);
                        String key = snapshot.getKey();
                        baitapsv.add(new BaiTapSV(key,baitap.getBaiTap(),baitap.getComment(),baitap.getDiem(),baitap.getNgayNop(),baitap.getSinhVien(),baitap.getThoiGian()));
                        if(ParentHome.idChild.equals(baitap.getSinhVien())){
                            idBaiTap=baitap.getBaiTap();
                        }
                        expireHomeAdapter.notifyDataSetChanged();

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
        arrayListStudent=new ArrayList<>();



        //get BaiTap



        //Khai báo recycleView
        RecyclerView recyclerViewNotiHome =(RecyclerView) findViewById(R.id.noti_home);
        RecyclerView recyclerViewExpireHome =(RecyclerView) findViewById(R.id.expire_home);
        recyclerViewNotiHome.setHasFixedSize(true);
        recyclerViewExpireHome.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewNotiHome.setLayoutManager(layoutManager);
        recyclerViewExpireHome.setLayoutManager(layoutManager2);
        arrayListNotificate = new ArrayList<>();
//        arrayListNotificate.add(new Noti_Home("a","a","a","a"));
//        arrayListNotificate.add(new Noti_Home("a","a","a","a"));
//        arrayListNotificate.add(new Noti_Home("a","a","a","a"));
//        arrayListNotificate.add(new Noti_Home("a","a","a","a"));
        notiHomeAdapter = new NotiHomeAdapter(arrayListNotificate, this);
        recyclerViewNotiHome.setAdapter(notiHomeAdapter);
        notiHomeAdapter.notifyDataSetChanged();

        arrayList2 = new ArrayList<>();
//        arrayList2.add(new Expire_Home("Xác suất thống kê", "Bài tập vui", "10:00 PM","a","a"));

        expireHomeAdapter = new ExpireHomeAdapter(arrayList2, this);
        recyclerViewExpireHome.setAdapter(expireHomeAdapter);
        expireHomeAdapter.notifyDataSetChanged();
//        arrayList2.add(new Expire_Home("Xác suất thống kê 2", "Bài tập vui", "10:00 PM"));
//        arrayList2.add(new Expire_Home("Xác suất thống kê 3", "Bài tập vui", "10:00 PM"));
//        arrayList2.add(new Expire_Home("Xác suất thống kê 4 ", "Bài tập vui", "10:00 PM"));
//        arrayList2.add(new Expire_Home("Xác suất thống kê 5", "Bài tập vui", "10:00 PM"));





//        Student m=new Student("LinhLamDong","0344153456","18110CL1A","Linh08052000@gmail.com");
//        mDatabase.child("SinhVien").push().setValue(m);



        mDatabase.child("ThongBao").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Noti_Home notification = snapshot.getValue(Noti_Home.class);
                arrayListNotificate.add(new Noti_Home(notification.getTitle(),notification.getNoiDung(),notification.getNguoiGui(),notification.getNgayGui()));
                notiHomeAdapter.notifyDataSetChanged();
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
        mDatabase.child("BaiTap").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Expire_Home expire = snapshot.getValue(Expire_Home.class);
                String key = snapshot.getKey();
                arrayList2.add(new Expire_Home(key,expire.getName(),expire.getGiaoVien(),expire.getBaitapSV(),expire.getNoiDung(),expire.getBaiGiang(),expire.getNgayTao(),expire.getThoiGianNop(),expire.getThoiGianTao()));

//                if(Home.idBaiTap.equals(key)){
//                }
                expireHomeAdapter.notifyDataSetChanged();
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





//        GetId();
        Button btn_Schedule = (Button) findViewById(R.id.btn_Schedule);
        btn_Schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ParentHome.this, Schedule.class));
            }
        });

        Button btn_testSchedule = (Button) findViewById(R.id.btn_testSchedule);
        btn_testSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ParentHome.this, TestSchedule.class));
            }
        });

        Button btn_dealine = (Button) findViewById(R.id.btn_deadline);
        btn_dealine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ParentHome.this, Deadline.class));
            }
        });

        Button btn_point= (Button) findViewById(R.id.btn_point);
        btn_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ParentHome.this, Point.class));
            }
        });

        Button btn_profile= (Button) findViewById(R.id.btn_profileStudent);
        btn_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ParentHome.this, ProfileStudent.class));
            }
        });
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerViewNotiHome);
        ItemTouchHelper itemTouchHelper2 = new ItemTouchHelper(simpleCallback2);
        itemTouchHelper2.attachToRecyclerView(recyclerViewExpireHome);
    }
    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            int position = viewHolder.getLayoutPosition();
            IdNoti=position;
            IdExpire=-1;
            switch (direction){
                case ItemTouchHelper.LEFT:
                    arrayListNotificate.remove(position);
                    notiHomeAdapter.notifyItemRemoved(position);
                    break;
                case ItemTouchHelper.RIGHT:
                    name=arrayListNotificate.get(position).getTitle();
                    arrayListNotificate.remove(position);
                    notiHomeAdapter.notifyItemRemoved(position);
                    nguoiGui=arrayListNotificate.get(position).getNguoiGui();
                    decrip=arrayListNotificate.get(position).getNoiDung();
                    startActivity(new Intent(ParentHome.this, StydyPriceDetail.class));
                    break;
            }
        }
    };
    ItemTouchHelper.SimpleCallback simpleCallback2 = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView2, @NonNull RecyclerView.ViewHolder viewHolder2, @NonNull RecyclerView.ViewHolder target2) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder2, int direction2) {
            int position2 = viewHolder2.getLayoutPosition();
            IdExpire=position2;
            IdNoti=-1;
            switch (direction2){
                case ItemTouchHelper.LEFT:
                    arrayList2.remove(position2);
                    expireHomeAdapter.notifyItemRemoved(position2);
                    break;
                case ItemTouchHelper.RIGHT:
//                    arrayList2.remove(position2);
//                    expireHomeAdapter.notifyItemRemoved(position2);
                    name=arrayList2.get(position2).getName();
                    nguoiGui=arrayList2.get(position2).getThoiGianNop();
                    decrip=arrayList2.get(position2).getNoiDung();
                    startActivity(new Intent(ParentHome.this, StydyPriceDetail.class));
                    break;
            }
        }
    };
//    public void GetId(){
//        for (int i=0;i<arrayListStudent.size();i++){
//            if(arrayListStudent.get(i).id == Id){
//                NameUser=arrayListStudent.get(i).getName();
//                MailUser=arrayListStudent.get(i).getMail();
//                PhoneUser=arrayListStudent.get(i).getPhone();
//                ClassUser=arrayListStudent.get(i).getClasses();
//            }
//        }
//        User = (TextView) findViewById(R.id.textView4);
//        User.setText("Wellcome, " + NameUser);
//    }
}
