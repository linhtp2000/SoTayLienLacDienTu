package com.example.contactapp.Quanly.YourClass.QuanlyGV;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.contactapp.Quanly.YourClass.QuanlyPH.ThongtinPH;
import com.example.contactapp.Quanly.YourClass.QuanlySV.DongDSSV;
import com.example.contactapp.Quanly.YourClass.QuanlySV.ListViewDSSVAdapter;
import com.example.contactapp.Quanly.YourClass.QuanlySV.QuanlySV;
import com.example.contactapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuanlyGV#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuanlyGV extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ListView lstDSGV;
    ListViewDSSVAdapter adapter;
    ArrayList<DongDSSV> dongDSGVArrayList;
    public QuanlyGV() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuanlyGV.
     */
    // TODO: Rename and change types and number of parameters
    public static QuanlyGV newInstance(String param1, String param2) {
        QuanlyGV fragment = new QuanlyGV();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public static Fragment newInstance()
    {
        QuanlyGV myFragment = new QuanlyGV();
        return myFragment;
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
        View view= inflater.inflate(R.layout.fragment_quanly_g_v, container, false);
        Anhxa(view);
        lstDSGV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment fg;
                fg= ThongtinGV.newInstance();
                replaceFragment(fg);
            }
        });
        return view;
    }
    private void Anhxa(View view){
        lstDSGV=view.findViewById(R.id.lstDSGV);
        dongDSGVArrayList= new ArrayList<>();
        dongDSGVArrayList.add(new DongDSSV("1","Phạm Thành Trung","GV-01"));
        adapter=new ListViewDSSVAdapter(getActivity(),R.layout.custom_dong_sinh_vien,dongDSGVArrayList);
        lstDSGV.setAdapter(adapter);
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