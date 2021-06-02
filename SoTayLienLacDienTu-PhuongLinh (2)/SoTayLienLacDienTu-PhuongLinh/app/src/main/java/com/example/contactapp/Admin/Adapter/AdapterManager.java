package com.example.contactapp.Admin.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactapp.Admin.ManagerInfo;
import com.example.contactapp.Models.QuanLy;
import com.example.contactapp.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AdapterManager  extends  RecyclerView.Adapter<AdapterManager.MyViewHolder>  {

    Context context;
    ArrayList<QuanLy> list;






    private RecyclerVieWClickListener listener ;



    public AdapterManager(Context context, ArrayList<QuanLy> list, RecyclerVieWClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener=listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.item_manager,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        QuanLy quanLy=list.get(position);
        holder.manager.setText(quanLy.getName());
        holder.id.setText(quanLy.getId());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public interface RecyclerVieWClickListener{
        void onClick(View v, int positon);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder  {
        TextView manager;
        TextView id;




        public MyViewHolder(@NonNull View itemView) {

            super(itemView);


            manager=itemView.findViewById(R.id.txtItemManager);
            id=itemView.findViewById(R.id.txtid);


            DatabaseReference  database;
            database= FirebaseDatabase.getInstance().getReference().child("QuanLy");


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(v.getContext(), ManagerInfo.class);


                    intent.putExtra("IdManager",id.getText().toString());

                    v.getContext().startActivity(intent);
                }
            });


        }




    }




}
