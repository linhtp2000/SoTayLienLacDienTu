package com.example.contactapp.Admin.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactapp.Admin.ListStudent;
import com.example.contactapp.Models.Lop;
import com.example.contactapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AdapterClass  extends  RecyclerView.Adapter<AdapterClass.MyViewHolder>  {

    Context context;
    ArrayList<Lop> list;






    private RecyclerVieWClickListener listener ;



    public AdapterClass(Context context, ArrayList<Lop> list, RecyclerVieWClickListener listener) {
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
        Lop lop=list.get(position);
        holder.course.setText(lop.getName());

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
            database= FirebaseDatabase.getInstance().getReference().child("Lop");


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(v.getContext(), ListStudent.class);

                    intent.putExtra("key",course.getText().toString());

                    v.getContext().startActivity(intent);
                }
            });

            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)  {

                    database.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            //list=new ArrayList<>();

                            for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                                //  Lop lop=dataSnapshot.getValue(Lop.class);
                                Lop lop=dataSnapshot.getValue(Lop.class);
                                lop.setId(dataSnapshot.getKey());



                                String a=lop.getName().toString();
                                String b=course.getText().toString();
                                    String c=lop.getId();
                                if(a.equals(b)==true) {

                                   database.child(c).setValue(null);
                                   list.clear();






                                }



                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });











//                    list.clear();

                }
            });
        }




    }




}
