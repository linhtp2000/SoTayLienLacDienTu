package com.example.contactapp.Student;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.contactapp.R;

import java.util.ArrayList;

public class ExpireHomeAdapter extends  RecyclerView.Adapter<ExpireHomeAdapter.ViewHolder>{
    ArrayList<Expire_Home> listExpireHome;
    Context context;

    public ExpireHomeAdapter(ArrayList<Expire_Home> listExpireHome, Context context) {
        this.listExpireHome = listExpireHome;
        this.context = context;
    }

    @Override
    public ExpireHomeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.expire_home_item, parent,false);
        return new ExpireHomeAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ExpireHomeAdapter.ViewHolder holder, int position) {
        holder.title.setText(listExpireHome.get(position).getTitle());
        holder.deb.setText(listExpireHome.get(position).getDebcription());
        holder.time.setText(listExpireHome.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return listExpireHome.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView deb;
        TextView time;
        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.expire_home_title);
            deb = (TextView)itemView.findViewById(R.id.expire_home_decription);
            time = (TextView) itemView.findViewById(R.id.expire_home_time);
        }
    }
}
