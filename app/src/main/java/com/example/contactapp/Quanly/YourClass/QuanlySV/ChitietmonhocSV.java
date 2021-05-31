package com.example.contactapp.Quanly.YourClass.QuanlySV;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;

import com.example.contactapp.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChitietmonhocSV#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChitietmonhocSV extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ListView lstMonHoc;
    ListViewMonHocAdapter adapter;
    ArrayList<DongMonHoc> dongMonHocArrayList;
    public ChitietmonhocSV() {
        // Required empty public constructor
    }
    public static Fragment newInstance()
    {
        ChitietmonhocSV chitietmonhocSV = new ChitietmonhocSV();
        return chitietmonhocSV;
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChitietmonhocSV.
     */
    // TODO: Rename and change types and number of parameters
    public static ChitietmonhocSV newInstance(String param1, String param2) {
        ChitietmonhocSV fragment = new ChitietmonhocSV();
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
        View view= inflater.inflate(R.layout.fragment_chitietmonhoc_s_v, container, false);
        AnhXa(view);
        return view;
    }
    private void AnhXa(View view)
    {
        lstMonHoc=view.findViewById(R.id.lstMonHoc);
        dongMonHocArrayList= new ArrayList<>();
        dongMonHocArrayList.add(new DongMonHoc("Toán 2"));
        dongMonHocArrayList.add(new DongMonHoc("Toán rời rạc"));
        dongMonHocArrayList.add(new DongMonHoc("Xác suất thống kê & ứng dung"));
        dongMonHocArrayList.add(new DongMonHoc("Lập trình web"));
        dongMonHocArrayList.add(new DongMonHoc("Lập trình android"));
        adapter=new ListViewMonHocAdapter(getActivity(),R.layout.dong_mon_hoc,dongMonHocArrayList);
        lstMonHoc.setAdapter(adapter);
    }
}