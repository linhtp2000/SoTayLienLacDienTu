package com.example.contactapp.Student;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.contactapp.R;

import java.util.ArrayList;

public class DeadlineAdapter extends  RecyclerView.Adapter<DeadlineAdapter.ViewHolder> {
    ArrayList<Deadline_item> listDeadline;
    Context context;

    public DeadlineAdapter(ArrayList<Deadline_item> listDeadline, Context context) {
        this.listDeadline = listDeadline;
        this.context = context;
    }

    @Override
    public DeadlineAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.deadline_item, parent, false);
        return new DeadlineAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DeadlineAdapter.ViewHolder holder, int position) {
        holder.title.setText(listDeadline.get(position).getTitle());
        holder.debcription.setText(listDeadline.get(position).getDebcription());
        holder.date.setText(listDeadline.get(position).getDate());
        holder.time.setText(listDeadline.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return listDeadline.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView debcription;
        TextView date;
        TextView time;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.deadline_item_title);
            debcription = (TextView) itemView.findViewById(R.id.deadline_item_debcription);
            date = (TextView) itemView.findViewById(R.id.deadline_item_date);
            time = (TextView) itemView.findViewById(R.id.deadline_item_time);
        }
    }
}
