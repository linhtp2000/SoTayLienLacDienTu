package com.example.contactapp.Quanly.YourClass.QuanlySV;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.contactapp.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThongtinSV#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThongtinSV extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    EditText edtPhone,edtGmail,edtAddress;
    Button btnEdit;
    public ThongtinSV() {
        // Required empty public constructor
    }
    public static Fragment newInstance()
    {
        ThongtinSV QuanlySV = new ThongtinSV();
        return QuanlySV;
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ThongtinSV.
     */
    // TODO: Rename and change types and number of parameters
    public static ThongtinSV newInstance(String param1, String param2) {
        ThongtinSV fragment = new ThongtinSV();
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
        View view= inflater.inflate(R.layout.fragment_thongtin_s_v, container, false);
        Anhxa(view);
        final Boolean[] a = {true};
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(a[0] ==true)
                {
                    edtPhone.setEnabled(true);
                    edtGmail.setEnabled(true);
                    edtAddress.setEnabled(true);
                    btnEdit.setText("Save");
                    a[0] =false;
                }
                else {
                    edtPhone.setEnabled(false);
                    edtGmail.setEnabled(false);
                    edtAddress.setEnabled(false);
                    btnEdit.setText("Edit");
                    a[0] =true;
                }
            }
        });
        return view;
    }
    private void Anhxa(View view)
    {
        edtPhone=view.findViewById(R.id.edtPhoneSV);
        edtGmail=view.findViewById(R.id.edtGmailSV);
        edtAddress=view.findViewById(R.id.edtAddressSV);
        btnEdit=view.findViewById(R.id.btnEditThongTinSV);
    }
}