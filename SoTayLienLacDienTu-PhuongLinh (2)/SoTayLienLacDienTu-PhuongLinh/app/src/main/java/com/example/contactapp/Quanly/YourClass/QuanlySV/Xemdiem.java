package com.example.contactapp.Quanly.YourClass.QuanlySV;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.contactapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Xemdiem#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Xemdiem extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView txtSemester2018_2019;
    LinearLayout linearState1,linearState2,lineSemester2018_2019;
    Button btnSemester2018_State1;
    int a=0;
    public Xemdiem() {
        // Required empty public constructor
    }
    public static Fragment newInstance()
    {
        Xemdiem XemdiemSV = new Xemdiem();
        return XemdiemSV;
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Xemdiem.
     */
    // TODO: Rename and change types and number of parameters
    public static Xemdiem newInstance(String param1, String param2) {
        Xemdiem fragment = new Xemdiem();
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
        View view= inflater.inflate(R.layout.fragment_xemdiem, container, false);
        AnhXa(view);
        return view;
    }
    private void AnhXa(View view){
        txtSemester2018_2019=view.findViewById(R.id.txtSemester2018_2019);
        linearState1=view.findViewById(R.id.linearState1);
        linearState2=view.findViewById(R.id.linearState2);
        lineSemester2018_2019=view.findViewById(R.id.linearSemester2018_2019);
        btnSemester2018_State1=view.findViewById(R.id.btn_semester2018_2019_State1);
        txtSemester2018_2019.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a==0)
                {
                    linearState1.setVisibility(View.VISIBLE);
                    linearState2.setVisibility(View.VISIBLE);
                    txtSemester2018_2019.setBackgroundResource(R.drawable.custom_semester);
                    a=1;
                }
                else {
                    linearState1.setVisibility(View.GONE);
                    linearState2.setVisibility(View.GONE);
                    txtSemester2018_2019.setBackgroundResource(R.drawable.custom_editsearch);
                    a=0;
                }
            }
        });
        btnSemester2018_State1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fg;
                fg= QuanlydiemtongketSV.newInstance();
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