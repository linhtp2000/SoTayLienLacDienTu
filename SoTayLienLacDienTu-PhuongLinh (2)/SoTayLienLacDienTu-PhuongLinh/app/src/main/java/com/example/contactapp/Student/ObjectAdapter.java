package com.example.contactapp.Student;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.contactapp.R;

import java.util.ArrayList;

public class ObjectAdapter extends  RecyclerView.Adapter<ObjectAdapter.ViewHolder> {
    ArrayList<Object> listObject;
    Context context;

    public ObjectAdapter(ArrayList<Object> listObject, Context context) {
        this.listObject = listObject;
        this.context = context;
    }

    @Override
    public ObjectAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.state_item, parent, false);
        return new ObjectAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ObjectAdapter.ViewHolder holder, int position) {
        holder.name.setText(listObject.get(position).getName());;
    }

    @Override
    public int getItemCount() {
        return listObject.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        public ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.state_NameObject);
        }
    }
}
