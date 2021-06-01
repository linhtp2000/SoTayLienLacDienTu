package com.example.contactapp.Quanly.HomeQuanly;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.contactapp.Quanly.YourClass.QuanlySV.QuanlydiemtongketSV;
import com.example.contactapp.Quanly.YourClass.YourClass;
import com.example.contactapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home_Quanly#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home_Quanly extends Fragment {
    private ViewPager viewPager;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RelativeLayout btnNotification,btnYourClass;

    public Home_Quanly(ViewPager viewPager) {
        // Required empty public constructor
        this.viewPager=viewPager;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home_Quanly.
     */
    // TODO: Rename and change types and number of parameters
    public static Home_Quanly newInstance(String param1, String param2,ViewPager viewPager) {
        Home_Quanly fragment = new Home_Quanly(viewPager);
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
        View view= inflater.inflate(R.layout.fragment_home__quanly, container, false);
        AnhXa(view);
        view.findViewById(R.id.ButtonYourClass).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });
        return view;
    }
    private void AnhXa(View view)
    {
        btnNotification=view.findViewById(R.id.ButtonNotification);
        btnYourClass=view.findViewById(R.id.ButtonYourClass);

        btnNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fg;
                fg= Notification.newInstance();
                replaceFragment(fg);
            }
        });
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