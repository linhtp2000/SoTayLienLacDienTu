package com.example.contactapp.Quanly.YourClass.QuanlyPH;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.contactapp.Quanly.YourClass.QuanlySV.DongDSSV;
import com.example.contactapp.Quanly.YourClass.QuanlySV.ListViewDSSVAdapter;
import com.example.contactapp.Quanly.YourClass.QuanlySV.ThongtinSV;
import com.example.contactapp.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuanlyPH#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuanlyPH extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ListView lstDSPH;
    ListViewDSSVAdapter adapter;
    ArrayList<DongDSSV> dongDSPHArrayList;
    public QuanlyPH() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuanlyPH.
     */
    // TODO: Rename and change types and number of parameters
    public static QuanlyPH newInstance(String param1, String param2) {
        QuanlyPH fragment = new QuanlyPH();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public static Fragment newInstance()
    {
        QuanlyPH myFragment = new QuanlyPH();
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
        View view= inflater.inflate(R.layout.fragment_quanly_p_h, container, false);
        AnhXA(view);
        lstDSPH.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment fg;
                fg= ThongtinPH.newInstance();
                replaceFragment(fg);
            }
        });
        return view;
    }
    private void AnhXA(View view)
    {
        lstDSPH=view.findViewById(R.id.lstDSPH);
        dongDSPHArrayList= new ArrayList<>();
        dongDSPHArrayList.add(new DongDSSV("1","Phạm Thành Trung","18110222"));
        adapter=new ListViewDSSVAdapter(getActivity(),R.layout.custom_dong_sinh_vien,dongDSPHArrayList);
        lstDSPH.setAdapter(adapter);
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