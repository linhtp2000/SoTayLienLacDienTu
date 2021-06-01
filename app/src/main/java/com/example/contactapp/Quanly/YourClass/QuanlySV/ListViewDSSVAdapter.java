package com.example.contactapp.Quanly.YourClass.QuanlySV;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.contactapp.R;

import java.util.List;

public class ListViewDSSVAdapter extends BaseAdapter {
    private Context context;
    private int Layout;
    private List<DongDSSV> dongDSSVS;

    public ListViewDSSVAdapter(Context context, int layout, List<DongDSSV> dongDSSVS) {
        this.context = context;
        Layout = layout;
        this.dongDSSVS = dongDSSVS;
    }

    @Override
    public int getCount() {
        return dongDSSVS.size();
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
        TextView STT,Ten,MSSV;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHorder viewHorder;
        if(convertView==null)
        {
            LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(Layout,null);
            viewHorder=new ViewHorder();
            viewHorder.STT= convertView.findViewById(R.id.txtSTT);
            viewHorder.Ten=convertView.findViewById(R.id.txtTenSV);
            viewHorder.MSSV=convertView.findViewById(R.id.txtMSSV);
            convertView.setTag(viewHorder);
        }
        else{
            viewHorder= (ViewHorder) convertView.getTag();
        }


        DongDSSV dongDSSV= dongDSSVS.get(position);
        int po=position+1;
        viewHorder.STT.setText(po+"");
        viewHorder.Ten.setText(dongDSSV.getName());
        viewHorder.MSSV.setText(dongDSSV.getMSSV());
        return convertView;
    }
}
