package com.example.contactapp.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;


import com.example.contactapp.Admin.ListStudent;
import com.example.contactapp.Admin.Student;
import com.example.contactapp.Models.SinhVien;
import com.example.contactapp.R;


import java.util.ArrayList;

public class AdapterStudent  extends  RecyclerView.Adapter<AdapterStudent.MyViewHolder>  {

    Context context;
    ArrayList<SinhVien> list;


    public AdapterStudent(Context context, ArrayList<SinhVien> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.item_student,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SinhVien sinhVien=list.get(position);
        holder.name.setText(sinhVien.getName());
        holder.mail.setText(sinhVien.getEmail());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
//    public interface RecyclerVieWClickListener{
//        void onClick(View v, int positon);
//    }

    public class MyViewHolder extends RecyclerView.ViewHolder  {
        TextView name;
        TextView mail;



        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            name=itemView.findViewById(R.id.txtItemNameStudent);
            mail=itemView.findViewById(R.id.txtItemMail);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(v.getContext(), Student.class);


                    intent.putExtra("mail",mail.getText().toString());
                    intent.putExtra("name", name.getText().toString());

                    v.getContext().startActivity(intent);
                }
            });





        }




    }





}
