package com.example.contactapp.Quanly.YourClass;

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
import android.widget.TextView;
import android.widget.Toast;

import com.example.contactapp.Quanly.YourClass.QuanlyGV.QuanlyGV;
import com.example.contactapp.Quanly.YourClass.QuanlyGV.ThongtinGV;
import com.example.contactapp.Quanly.YourClass.QuanlyPH.QuanlyPH;
import com.example.contactapp.Quanly.YourClass.QuanlyPH.ThongtinPH;
import com.example.contactapp.Quanly.YourClass.QuanlySV.DongLopHoc;
import com.example.contactapp.Quanly.YourClass.QuanlySV.ListViewCourseAdapter;
import com.example.contactapp.Quanly.YourClass.QuanlySV.ListViewLopHocAdapter;
import com.example.contactapp.Quanly.YourClass.QuanlySV.QuanlyDSSV;
import com.example.contactapp.Quanly.YourClass.QuanlySV.QuanlySV;
import com.example.contactapp.Quanly.YourClass.QuanlySV.ThongtinSV;
import com.example.contactapp.Quanly.YourClass.QuanlySV.dongCourse;
import com.example.contactapp.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link YourClass#newInstance} factory method to
 * create an instance of this fragment.
 */
public class YourClass extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    LinearLayout linearLayoutBottomsheet;
    BottomSheetBehavior bottomSheetBehavior;
    Button btnQuanlySV,btnQuanlyPH,btnQuanlyGV;
    ListView lstCourse;
    ListViewCourseAdapter adapter;
    ArrayList<dongCourse> dongCourses;
    int tam=-1;
    public YourClass() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment YourClass.
     */
    // TODO: Rename and change types and number of parameters
    public static YourClass newInstance(String param1, String param2) {
        YourClass fragment = new YourClass();
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
        View view= inflater.inflate(R.layout.fragment_your_class, container, false);
        AnhXa(view);
       lstCourse.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               if(bottomSheetBehavior.getState()!=BottomSheetBehavior.STATE_EXPANDED)
               {
                   bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                   tam=position;
               }
               else {
                   bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                   tam=-1;
               }
           }
       });
        btnQuanlySV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick(v);
                QuanlySV.Courseluu=dongCourses.get(tam).getCourse();
                QuanlyDSSV.tenCoure=dongCourses.get(tam).getCourse();
                ThongtinSV.Tencoursetam=dongCourses.get(tam).getCourse();
                ThongtinPH.CourseThongtinPH=dongCourses.get(tam).getCourse();
                ThongtinGV.CourseThongtinGV=dongCourses.get(tam).getCourse();
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

            }
        });
        btnQuanlyPH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick(v);
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        });
        btnQuanlyGV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onButtonClick(v);
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        });
        return view;
    }
    private void AnhXa(View view)
    {
        lstCourse=view.findViewById(R.id.lstCourse);
        dongCourses= new ArrayList<>();
        dongCourses.add(new dongCourse("Course - 2018"));
        dongCourses.add(new dongCourse("Course - 2019"));
        dongCourses.add(new dongCourse("Course - 2020"));
        dongCourses.add(new dongCourse("Course - 2021"));
        adapter=new ListViewCourseAdapter(getActivity(),R.layout.dong_course,dongCourses);
        lstCourse.setAdapter(adapter);
        linearLayoutBottomsheet=view.findViewById(R.id.bottomsheet);
        bottomSheetBehavior=BottomSheetBehavior.from(linearLayoutBottomsheet);
        btnQuanlySV=view.findViewById(R.id.btnQuanlySV);
        btnQuanlyPH=view.findViewById(R.id.btnQuanlyPH);
        btnQuanlyGV=view.findViewById(R.id.btnQuanlyGV);
    }
    public void onButtonClick(View v) {
        Fragment fg;

        switch (v.getId()) {
            case R.id.btnQuanlySV:
                fg= QuanlySV.newInstance();
                replaceFragment(fg);
                break;
            case R.id.btnQuanlyPH:
                fg= QuanlyPH.newInstance();
                replaceFragment(fg);
                break;
            case R.id.btnQuanlyGV:
                fg= QuanlyGV.newInstance();
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