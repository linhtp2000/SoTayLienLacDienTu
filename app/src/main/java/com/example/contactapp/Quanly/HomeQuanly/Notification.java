package com.example.contactapp.Quanly.HomeQuanly;

import android.app.Dialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.contactapp.Models.BaiTapSV;
import com.example.contactapp.Models.ThongBao;
import com.example.contactapp.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Notification#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Notification extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static int luu=-1;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ListView lstThonBao;
    ListViewNotificationAdapter adapter;
    ArrayList<DongThongBao> dongThongBaos;
    ImageView imgAdd,imgDelete;
    String thongbao="-Mani41ECDNVf6ioRvn5";
    DatabaseReference databaseReference;
    public Notification() {
        // Required empty public constructor
    }
    public static Fragment newInstance()
    {
        Notification notification = new Notification();
        return notification;
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Notification.
     */
    // TODO: Rename and change types and number of parameters
    public static Notification newInstance(String param1, String param2) {
        Notification fragment = new Notification();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_notification, container, false);
        AnhXa(view);
        imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog();
            }
        });
        imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fg;
                fg= AddNotification.newInstance();
                replaceFragment(fg);
            }
        });
        return view;
    }
    private void AnhXa(View view)
    {
        databaseReference= FirebaseDatabase.getInstance().getReference();
        lstThonBao=view.findViewById(R.id.lstnotification);
        dongThongBaos= new ArrayList<>();
        adapter=new ListViewNotificationAdapter(getActivity(),R.layout.dong_notification,dongThongBaos);
        lstThonBao.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        imgAdd=view.findViewById(R.id.ButtonAddNotification);
        imgDelete=view.findViewById(R.id.ButtonDeleteNotification);
        databaseReference.child("ThongBao").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                DongThongBao dongThongBaoa=snapshot.getValue(DongThongBao.class);
                dongThongBaos.add(new DongThongBao(dongThongBaoa.getNgayGui(),dongThongBaoa.getNguoiGui(),dongThongBaoa.getNoiDung(),dongThongBaoa.getTitle()));
                adapter.notifyDataSetChanged();
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
    private void getNotification(){

    }
    private void Dialog(){
        final Dialog dialog=new Dialog(getActivity());

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.custom_dialog);
        dialog.setCanceledOnTouchOutside(false);
        Button btnOk= dialog.findViewById(R.id.btnOK) ;
        Button btnCancel=dialog.findViewById(R.id.btnCancel);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(luu==-1)
                {
                    Toast.makeText(getActivity(),"Chưa chọn",Toast.LENGTH_LONG).show();
                    dialog.cancel();
                }
                else{
                    dongThongBaos.remove(luu);
                    adapter.notifyDataSetChanged();
                    luu = -1;
                    dialog.cancel();
                }

            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();

    }
    private void replaceFragment(Fragment newFragment) {
        FragmentTransaction trasection = getFragmentManager().beginTransaction();

        if(!newFragment.isAdded()) {
            try {
                //FragmentTransaction trasection =
                getFragmentManager().beginTransaction();
                trasection.replace(R.id.linear2, newFragment);
                trasection.addToBackStack(null);
                trasection.commit();
            } catch (Exception e) {
                // TODO: handle exception
                // AppConstants.printLog(e.getMessage());
            }

        }
        else{
            trasection.show(newFragment);
        }
    }
}