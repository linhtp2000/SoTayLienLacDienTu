package com.example.contactapp.Student;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.contactapp.Model.Noti_Home;
import com.example.contactapp.R;

import java.util.ArrayList;

public class NotiHomeAdapter extends  RecyclerView.Adapter<NotiHomeAdapter.ViewHolder>{
    ArrayList<Noti_Home> listNotiHome;
    Context context;

    public NotiHomeAdapter(ArrayList<Noti_Home> listNotiHome, Context context) {
        this.listNotiHome = listNotiHome;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.noti_home_item, parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText(listNotiHome.get(position).getTitle());
        holder.deb.setText(listNotiHome.get(position).getNoiDung());
    }

    @Override
    public int getItemCount() {
        return listNotiHome.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView deb;
        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.noti_home_title);
            deb = (TextView)itemView.findViewById(R.id.noti_home_decription);

        }
    }
}
