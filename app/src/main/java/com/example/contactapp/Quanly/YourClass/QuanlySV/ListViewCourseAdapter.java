package com.example.contactapp.Quanly.YourClass.QuanlySV;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.contactapp.R;

import java.util.List;

public class ListViewCourseAdapter extends BaseAdapter {
    private Context context;
    private int Layout;
    private List<dongCourse> dongCourses;

    public ListViewCourseAdapter(Context context, int layout, List<dongCourse> dongCourses) {
        this.context = context;
        Layout = layout;
        this.dongCourses = dongCourses;
    }

    @Override
    public int getCount() {
        return dongCourses.size();
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
        TextView Course;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHorder viewHorder;
        if(convertView==null)
        {
            LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(Layout,null);
            viewHorder=new ViewHorder();
            viewHorder.Course= convertView.findViewById(R.id.txtCourse2018);
            convertView.setTag(viewHorder);
        }
        else {
            viewHorder = (ViewHorder) convertView.getTag();
        }
        dongCourse dongCourse= dongCourses.get(position);
        viewHorder.Course.setText(dongCourse.getCourse());
        return convertView;
    }
}
