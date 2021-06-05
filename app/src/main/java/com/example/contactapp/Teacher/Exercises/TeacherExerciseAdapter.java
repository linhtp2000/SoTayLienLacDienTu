package com.example.contactapp.Teacher.Exercises;

import android.content.Context;
import android.content.Intent;
import android.provider.BaseColumns;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactapp.Models.BaiGiang;
import com.example.contactapp.Models.BaiTap;
import com.example.contactapp.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TeacherExerciseAdapter extends RecyclerView.Adapter<TeacherExerciseAdapter.TeacherExerciseViewHolder>
 {
    BaiGiang bg;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    List<BaiTap> lstBaiTap=new ArrayList<>();
    private ChildEventListener mChildListener;
    Context context;
    private static final String TAG = "ReadAndWriteSnippets";


    public TeacherExerciseAdapter(BaiGiang baigiang){
        bg= baigiang;
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference=mFirebaseDatabase.getReference().child("BaiTap");
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snap:dataSnapshot.getChildren()) {
                   BaiTap bt = snap.getValue(BaiTap.class);
                    bt.setId(snap.getKey());
                    if(bt.getBaiGiang()!=null) {
                        if (bt.getBaiGiang().equals(baigiang.getId())) {
                            lstBaiTap.add(bt);
                            notifyItemInserted(lstBaiTap.size() - 1);
                        }
                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        });
//            mChildListener= new ChildEventListener() {
//                @Override
//                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                    BaiTap bt = snapshot.getValue(BaiTap.class);
//                    bt.setId(snapshot.getKey());
//                    if (bt.getBaiGiang() != null) {
//                        if (bt.getBaiGiang().equals(baigiang.getId())) {
//                            lstBaiTap.add(bt);
//                            notifyItemInserted(lstBaiTap.size() - 1);
//                        }
//                    }
//                }
//
//                @Override
//                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//                }
//
//                @Override
//                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//
//                }
//
//                @Override
//                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError error) {
//
//                }
//            };
    }
    @Override
    public TeacherExerciseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context= parent.getContext();
        View itemView= LayoutInflater.from(context)
                .inflate(R.layout.teacher_item_exercise,parent,false);
        return new TeacherExerciseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TeacherExerciseViewHolder holder, int position) {
        BaiTap bt= lstBaiTap.get(position);
        holder.tvMon.setText(bg.getName());
        holder.tvDate.setText(bt.getDeadline());
        holder.tvTenbt.setText(bt.getName());
        holder.tvTime.setText(bt.getThoiGianNop());
    }

    @Override
    public int getItemCount() {
        return lstBaiTap.size();
    }


    public class TeacherExerciseViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvMon,tvTenbt,tvDate,tvTime;
        ConstraintLayout layout;
        public TeacherExerciseViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMon=itemView.findViewById(R.id.tvMon);
            tvTenbt=itemView.findViewById(R.id.tvTenbt);
            tvDate=itemView.findViewById(R.id.tvDate);
            tvTime=itemView.findViewById(R.id.tvTime);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=getLayoutPosition();
                    BaiTap bt=lstBaiTap.get(position);
                    Intent intent= new Intent(v.getContext(), TeacherExerciseEdit.class);
                    intent.putExtra("Baitap",  bt);
                    intent.putExtra("Baigiang",  bg);
                    v.getContext().startActivity(intent);
                }
            });
        }


    }
}
