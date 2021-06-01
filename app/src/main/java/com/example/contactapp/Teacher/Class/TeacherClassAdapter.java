package com.example.contactapp.Teacher.Class;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contactapp.LoginActivity;
import com.example.contactapp.Models.BaiGiang;
import com.example.contactapp.Models.GiaoVien;
import com.example.contactapp.R;
import com.example.contactapp.RegisterActivity;
import com.example.contactapp.Teacher.Exercises.TeacherExercisesActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static androidx.core.content.ContextCompat.startActivity;

public class TeacherClassAdapter extends RecyclerView.Adapter<TeacherClassAdapter.TeacherClassViewHolder>
implements View.OnClickListener{

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    List<BaiGiang> lstBaiGiang=new ArrayList<>();
    private FirebaseAuth auth;
    String kh;
    private ChildEventListener mChildListener;
    Context context;
    private static final String TAG = "ReadAndWriteSnippets";


    @Override
    public void onClick(View view) {

    }

    public void setData(List<BaiGiang>list) {
        this.lstBaiGiang=list;
        notifyDataSetChanged();
    }

    public TeacherClassAdapter(String kh){
         auth = FirebaseAuth.getInstance();
         String uid= auth.getCurrentUser().getUid();
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference=mFirebaseDatabase.getReference().child("BaiGiang");
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snap:dataSnapshot.getChildren()) {
                    BaiGiang bg = snap.getValue(BaiGiang.class);
                    bg.setId(snap.getKey());
                    if(bg.getKhoaHoc()==Integer.parseInt(kh)&&bg.getGiaoVien().equals(uid)) {
                        lstBaiGiang.add(bg);
                        notifyItemInserted(lstBaiGiang.size() - 1);
                    }
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        });
//        mFirebaseDatabase = FirebaseDatabase.getInstance();
//        mDatabaseReference=mFirebaseDatabase.getReference().child("BaiGiang");
//     //   mDatabaseReference=FirebaseDatabase.getInstance().getReference().child("GiaoVien");
//        mChildListener= new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                BaiGiang bg =snapshot.getValue(BaiGiang.class);
//                if(bg.getKhoaHoc()==2018)
//                {
//                    lstBaiGiang.add(bg);
//                    notifyItemInserted(lstBaiGiang.size()-1);
//                }
//            }
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        };
//        mDatabaseReference.addChildEventListener(mChildListener);

    }
    @Override
    public TeacherClassAdapter.TeacherClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context= parent.getContext();
        View itemView= LayoutInflater.from(context)
                .inflate(R.layout.teacher_item_class,parent,false);
        return new TeacherClassViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TeacherClassViewHolder holder, int position) {
            BaiGiang bg= lstBaiGiang.get(position);
            holder.tvClass.setText(bg.getName());

    }

    @Override
    public int getItemCount() {
        return lstBaiGiang.size();
    }

    public class TeacherClassViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvClass;
        ConstraintLayout layout;
        public TeacherClassViewHolder(@NonNull View itemView) {
            super(itemView);
            tvClass=itemView.findViewById(R.id.tvClass);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=getLayoutPosition();
                   BaiGiang bg=lstBaiGiang.get(position);
                    Intent intent= new Intent(v.getContext(), TeacherExercisesActivity.class);
                    intent.putExtra("Baigiang", bg);
                    v.getContext().startActivity(intent);
                }
            });
        }

//        @Override
//        public void onClick(View view) {
//            int position=getLayoutPosition();
//            String baigiangId=lstBaiGiang.get(position).getId();
//            Intent intent= new Intent(view.getContext(), TeacherExercisesActivity.class);
//             intent.putExtra("BaigiangId",baigiangId);
//             view.getContext().startActivity(intent);
//
//        }
   }
}
