package com.example.contactapp.Student;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.contactapp.Model.Test_Schedule_Item;
import com.example.contactapp.R;

import java.util.ArrayList;

public class TestScheduleAdapter extends  RecyclerView.Adapter<TestScheduleAdapter.ViewHolder> {
    ArrayList<Test_Schedule_Item> listTestSchedule;
    Context context;

    public TestScheduleAdapter(ArrayList<Test_Schedule_Item> listTestSchedule, Context context) {
        this.listTestSchedule = listTestSchedule;
        this.context = context;
    }

    @Override
    public TestScheduleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.list_test_schedule_item, parent, false);
        return new TestScheduleAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TestScheduleAdapter.ViewHolder holder, int position) {
        holder.title.setText(listTestSchedule.get(position).getTitle());
        holder.time.setText(listTestSchedule.get(position).getTime());
        holder.date.setText(listTestSchedule.get(position).getDate());
    }

    @Override
    public int getItemCount() {
        return listTestSchedule.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView time;
        TextView date;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.test_item_title);
            time = (TextView) itemView.findViewById(R.id.test_item_time);
            date = (TextView) itemView.findViewById(R.id.test_item_date);
        }
    }
}
