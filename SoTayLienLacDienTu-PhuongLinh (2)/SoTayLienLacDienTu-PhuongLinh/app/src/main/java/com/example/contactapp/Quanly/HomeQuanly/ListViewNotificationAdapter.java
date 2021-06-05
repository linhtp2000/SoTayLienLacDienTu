package com.example.contactapp.Quanly.HomeQuanly;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.contactapp.Quanly.YourClass.QuanlySV.DongDiemTB;
import com.example.contactapp.Quanly.YourClass.QuanlySV.DongLopHoc;
import com.example.contactapp.Quanly.YourClass.QuanlySV.ListViewLopHocAdapter;
import com.example.contactapp.R;

import java.util.List;

public class ListViewNotificationAdapter extends BaseAdapter {
    private Context context;
    private int Layout;
    private List<DongThongBao> dongThongBaoList;
    private boolean[] a = {true};
    public ListViewNotificationAdapter(Context context, int layout, List<DongThongBao> dongThongBaoList) {
        this.context = context;
        Layout = layout;
        this.dongThongBaoList = dongThongBaoList;
    }

    @Override
    public int getCount() {
        return dongThongBaoList.size();
    }

    public class ViewHorder{
        TextView TenThongBao,NoiDungThongBao;
        ImageView imgHinhCheck;
    }
    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHorder viewHorder;
        if(convertView==null)
        {

            LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(Layout,null);
            viewHorder=new ViewHorder();
            viewHorder.TenThongBao= convertView.findViewById(R.id.txtTenThongbao);
            viewHorder.NoiDungThongBao=convertView.findViewById(R.id.txtNoiDungThongBao);
            viewHorder.imgHinhCheck=convertView.findViewById(R.id.hinhcheck);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if( v.findViewById(R.id.hinhcheck).getVisibility()==View.GONE){
                        v.findViewById(R.id.hinhcheck).setVisibility(ImageView.VISIBLE);
                        Notification.luu=position;
                    }
                    else {
                        v.findViewById(R.id.hinhcheck).setVisibility(ImageView.GONE);
                        Notification.luu=-1;
                    }
                }
            });
            convertView.setTag(viewHorder);
        }
        else{
            viewHorder= (ViewHorder) convertView.getTag();
        }


        DongThongBao dongThongBao= dongThongBaoList.get(position);
        viewHorder.TenThongBao.setText(dongThongBao.getTenThongBao());
        viewHorder.NoiDungThongBao.setText(dongThongBao.getNoiDungThongBao());
        return convertView;
    }
}
