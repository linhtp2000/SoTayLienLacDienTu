package com.example.contactapp.Quanly.YourClass.QuanlySV;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.contactapp.Quanly.YourClass.QuanlyGV.QuanlyGV;
import com.example.contactapp.Quanly.YourClass.QuanlyPH.QuanlyPH;
import com.example.contactapp.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuanlyDSSV#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuanlyDSSV extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ListView lstDSSV;
    ListViewDSSVAdapter adapter;
    ArrayList<DongDSSV> dongDSSVArrayList;
    LinearLayout linearLayoutBottomsheet;
    BottomSheetBehavior bottomSheetBehavior;
    Button btnXemThongtin,btnXemDiem;
    public QuanlyDSSV() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuanlyDSSV.
     */
    // TODO: Rename and change types and number of parameters
    public static QuanlyDSSV newInstance(String param1, String param2) {
        QuanlyDSSV fragment = new QuanlyDSSV();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public static Fragment newInstance()
    {
        QuanlyDSSV QuanlySV = new QuanlyDSSV();
        return QuanlySV;
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
        View view= inflater.inflate(R.layout.fragment_quanly_d_s_s_v, container, false);
        AnhXA(view);
        lstDSSV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(bottomSheetBehavior.getState()!=BottomSheetBehavior.STATE_EXPANDED)
                {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
                else {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                }
            }
        });

        btnXemThongtin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick(v);
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        });
        btnXemDiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick(v);
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        });
        return view;
    }
    private void AnhXA(View view)
    {
        linearLayoutBottomsheet=view.findViewById(R.id.bottomsheetXemthongtin_xemdiem);
        bottomSheetBehavior=BottomSheetBehavior.from(linearLayoutBottomsheet);
        btnXemThongtin=view.findViewById(R.id.btnXemThongTin);
        btnXemDiem=view.findViewById(R.id.btnXemDiem);
        lstDSSV=view.findViewById(R.id.lstDSSV);
        dongDSSVArrayList= new ArrayList<>();
        dongDSSVArrayList.add(new DongDSSV("1","Phạm Thành Trung","18110222"));
        adapter=new ListViewDSSVAdapter(getActivity(),R.layout.custom_dong_sinh_vien,dongDSSVArrayList);
        lstDSSV.setAdapter(adapter);
    }
    public void onButtonClick(View v) {
        Fragment fg;

        switch (v.getId()) {
            case R.id.btnXemThongTin:
                fg= ThongtinSV.newInstance();
                replaceFragment(fg);
                break;
            case R.id.btnXemDiem:
                fg= Xemdiem.newInstance();
                replaceFragment(fg);
                break;
        }
    }

    private void replaceFragment(Fragment newFragment) {
        FragmentTransaction trasection = getFragmentManager().beginTransaction();

        if(!newFragment.isAdded()) {
            try {
                //FragmentTransaction trasection =
                getFragmentManager().beginTransaction();
                trasection.replace(R.id.linear1, newFragment);
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