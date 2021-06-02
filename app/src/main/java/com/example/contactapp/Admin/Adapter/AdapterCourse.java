package com.example.contactapp.Admin.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactapp.Admin.ListClass;
import com.example.contactapp.Admin.ListCourse;
import com.example.contactapp.Admin.ListStudent;
import com.example.contactapp.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import static com.firebase.ui.auth.AuthUI.getApplicationContext;

public class AdapterCourse extends RecyclerView.Adapter<AdapterCourse.MyViewHolder> {
    Context context;
    ArrayList<String> list;
    Dialog dialog;


    private RecyclerVieWClickListener listener ;



    public AdapterCourse(Context context, ArrayList<String> list, RecyclerVieWClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener=listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String course=list.get(position);
        holder.course.setText(course);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public interface RecyclerVieWClickListener{
        void onClick(View v, int positon);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder  {
        TextView course;
        Button delete;

        public MyViewHolder(@NonNull View itemView) {

            super(itemView);
            delete=itemView.findViewById(R.id.btnDeleteCourse);
            course=itemView.findViewById(R.id.txtItemCourse);

            DatabaseReference  database;
            database= FirebaseDatabase.getInstance().getReference().child("KhoaHoc");


            course.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(v.getContext(), ListClass.class);

                    intent.putExtra("key",list.get(getAbsoluteAdapterPosition()));

                    v.getContext().startActivity(intent);
                }
            });

            delete.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {


                    database.child(list.get(getAbsoluteAdapterPosition())).setValue(null);
                    list.clear();



                }
            });
        }




    }













}
