package com.example.contactapp.Teacher.Course;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactapp.Models.BaiGiang;
import com.example.contactapp.R;
import com.example.contactapp.Teacher.Class.TeacherClassAdapter;
import com.example.contactapp.Teacher.Exercises.TeacherExercisesActivity;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TeacherCourseAdapter extends RecyclerView.Adapter<TeacherCourseAdapter.TeacherCourseViewHolder>{
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    List<BaiGiang> lstBaiGiang=new ArrayList<>();
    private ChildEventListener mChildListener;
    Context context;
    private static final String TAG = "ReadAndWriteSnippets";

    public void setData(List<BaiGiang>list) {
        this.lstBaiGiang=list;
        notifyDataSetChanged();
    }

    public TeacherCourseAdapter(){
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference=mFirebaseDatabase.getReference().child("BaiGiang");
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snap:dataSnapshot.getChildren()) {
                    BaiGiang bg = snap.getValue(BaiGiang.class);
                    bg.setId(snap.getKey());

                    // if (bg.getGiaoVien() == 2000) {
                    lstBaiGiang.add(bg);
                    notifyItemInserted(lstBaiGiang.size() - 1);

                    //  }
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        });
    }
    @Override
    public TeacherCourseAdapter.TeacherCourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context= parent.getContext();
        View itemView= LayoutInflater.from(context)
                .inflate(R.layout.teacher_item_class,parent,false);
        return new TeacherCourseAdapter.TeacherCourseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TeacherCourseAdapter.TeacherCourseViewHolder holder, int position) {
        BaiGiang bg= lstBaiGiang.get(position);
        holder.tvClass.setText(bg.getName());

    }

    @Override
    public int getItemCount() {
        return lstBaiGiang.size();
    }

    public class TeacherCourseViewHolder extends RecyclerView.ViewHolder {
        TextView tvClass;
        ConstraintLayout layout;

        public TeacherCourseViewHolder(@NonNull View itemView) {
            super(itemView);
            tvClass = itemView.findViewById(R.id.tvClass);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getLayoutPosition();
                    BaiGiang bg = lstBaiGiang.get(position);
                    Intent intent = new Intent(v.getContext(), TeacherExercisesActivity.class);
                    intent.putExtra("Baigiang", bg);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}

