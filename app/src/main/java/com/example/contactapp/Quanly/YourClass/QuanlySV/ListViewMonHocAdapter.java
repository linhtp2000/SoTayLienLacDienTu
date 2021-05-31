package com.example.contactapp.Quanly.YourClass.QuanlySV;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.contactapp.R;

import java.util.List;

public class ListViewMonHocAdapter extends BaseAdapter {
    private Context context;
    private int Layout;
    private List<DongMonHoc> dongMonHocs;

    public ListViewMonHocAdapter(Context context, int layout, List<DongMonHoc> dongMonHocs) {
        this.context = context;
        Layout = layout;
        this.dongMonHocs = dongMonHocs;
    }

    @Override
    public int getCount() {
        return dongMonHocs.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }
    public class ViewHorder{
        TextView Tenmon;
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
            viewHorder.Tenmon= convertView.findViewById(R.id.txtTenMonHoc);
            convertView.setTag(viewHorder);
        }
        else{
            viewHorder= (ViewHorder) convertView.getTag();
        }


        DongMonHoc dongMonHoc= dongMonHocs.get(position);
        viewHorder.Tenmon.setText(dongMonHoc.getTenMon());
        return convertView;
    }
}
