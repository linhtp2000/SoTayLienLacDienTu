package com.example.contactapp.Quanly.YourClass.QuanlySV;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.contactapp.R;

import java.util.List;

public class ListViewDiemTBAdapter extends BaseAdapter {
    private Context context;
    private int Layout;
    private List<DongDiemTB> dongDiemTBS;

    public ListViewDiemTBAdapter(Context context, int layout, List<DongDiemTB> dongDiemTBS) {
        this.context = context;
        Layout = layout;
        this.dongDiemTBS = dongDiemTBS;
    }

    @Override
    public int getCount() {
        return dongDiemTBS.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    public class ViewHorder{
        TextView ten,mssv,diemtb,xeploai;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHorder viewHorder;
        if(convertView==null)
        {
            LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(Layout,null);
            viewHorder=new ViewHorder();
            viewHorder.ten= convertView.findViewById(R.id.txtTenTongDiemTB);
            viewHorder.mssv=convertView.findViewById(R.id.txtMSSVTongDiemTB);
            viewHorder.diemtb=convertView.findViewById(R.id.txtDiemTongDiemTB);
            viewHorder.xeploai=convertView.findViewById(R.id.txtXeploaiTongDiemTB);
            convertView.setTag(viewHorder);
        }
        else{
            viewHorder= (ViewHorder) convertView.getTag();
        }


        DongDiemTB dongDiemTB= dongDiemTBS.get(position);
        viewHorder.ten.setText(dongDiemTB.getTen());
        viewHorder.mssv.setText(dongDiemTB.getMSSV());
        viewHorder.diemtb.setText(dongDiemTB.getDiemTB());
        viewHorder.xeploai.setText(dongDiemTB.getXepLoai());
        return convertView;
    }
}
