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
import com.example.contactapp.Models.Khoa;
import com.example.contactapp.Models.KhoaHoc;
import com.example.contactapp.R;
import com.example.contactapp.Teacher.Class.TeacherClassActivity;
import com.example.contactapp.Teacher.Class.TeacherClassAdapter;
import com.example.contactapp.Teacher.Exercises.TeacherExercisesActivity;
import com.google.firebase.auth.FirebaseAuth;
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
    List<String> lstKhoahoc=new ArrayList<>();
    private ChildEventListener mChildListener;
    private FirebaseAuth auth;
    Context context;
    private static final String TAG = "ReadAndWriteSnippets";


    public TeacherCourseAdapter(){
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference=mFirebaseDatabase.getReference().child("KhoaHoc");
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snap:dataSnapshot.getChildren()) {
                    String kh = snap.getKey();
                    lstKhoahoc.add(kh);
                    notifyItemInserted(lstKhoahoc.size() - 1);
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
                .inflate(R.layout.teacher_item_course,parent,false);
        return new TeacherCourseAdapter.TeacherCourseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TeacherCourseAdapter.TeacherCourseViewHolder holder, int position) {
        String kh= lstKhoahoc.get(position);
        holder.tvCourse.setText(kh);

    }

    @Override
    public int getItemCount() {
        return lstKhoahoc.size();
    }

    public class TeacherCourseViewHolder extends RecyclerView.ViewHolder {
        TextView tvCourse;
        ConstraintLayout layout;

        public TeacherCourseViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCourse = itemView.findViewById(R.id.tvCourse);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getLayoutPosition();
                    String kh = lstKhoahoc.get(position);
                    Intent intent = new Intent(v.getContext(), TeacherClassActivity.class);
                    intent.putExtra("KhoaHoc", kh);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}

