package com.example.contactapp.Quanly.YourClass.QuanlySV;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.contactapp.R;

import java.util.List;

public class ListViewLopHocAdapter extends BaseAdapter {
    private Context context;
    private int Layout;
    private List<DongLopHoc> dongLopHocList;

    public ListViewLopHocAdapter(Context context, int layout, List<DongLopHoc> dongLopHocList) {
        this.context = context;
        Layout = layout;
        this.dongLopHocList = dongLopHocList;
    }

    @Override
    public int getCount() {
        return dongLopHocList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    public class ViewHorder{
        TextView Tenlop;
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
            viewHorder.Tenlop= convertView.findViewById(R.id.txttenLop);
            convertView.setTag(viewHorder);
        }
        else{
            viewHorder= (ViewHorder) convertView.getTag();
        }


        DongLopHoc dongLopHoc= dongLopHocList.get(position);
        viewHorder.Tenlop.setText(dongLopHoc.getLopHoc());
        return convertView;
    }
}
