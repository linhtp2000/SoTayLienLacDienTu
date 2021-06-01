package com.example.contactapp.Quanly.YourClass.QuanlySV;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.contactapp.Quanly.YourClass.YourClass;
import com.example.contactapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link QuanlySV#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuanlySV extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public static String tenlop;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ListView lstLophoc;
    ListViewLopHocAdapter adapter;
    ArrayList<DongLopHoc> dongLopHocArrayList;
    TextView txtCourse;
    public QuanlySV() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment QuanlySV.
     */
    // TODO: Rename and change types and number of parameters
    public static QuanlySV newInstance(String param1, String param2) {
        QuanlySV fragment = new QuanlySV();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public static Fragment newInstance()
    {
        QuanlySV QuanlySV = new QuanlySV();
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
        View view= inflater.inflate(R.layout.fragment_quanly_s_v, container, false);
        AnhXA(view);
        lstLophoc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fragment fg;
                fg= QuanlyDSSV.newInstance();
                replaceFragment(fg);
                tenlop=dongLopHocArrayList.get(position).getLopHoc();
            }
        });
        return view;
    }
    private void AnhXA(View view)
    {
        txtCourse=view.findViewById(R.id.txtCouseQuanlySV);
        lstLophoc=view.findViewById(R.id.listviewLophoc);
        dongLopHocArrayList= new ArrayList<>();
        dongLopHocArrayList.add(new DongLopHoc("18110CL1A"));
        dongLopHocArrayList.add(new DongLopHoc("18110CL2A"));
        adapter=new ListViewLopHocAdapter(getActivity(),R.layout.custom_dong_lop_hoc,dongLopHocArrayList);
        lstLophoc.setAdapter(adapter);
        txtCourse.setText(YourClass.Tencoursetam);
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