package com.example.contactapp.Teacher.Profile;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.contactapp.MainActivity;
import com.example.contactapp.Models.GiaoVien;
import com.example.contactapp.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class TeacherBackgroundProfile extends AppCompatActivity {
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;

    private static final int PICTURE_RESULT=42;
    private ChildEventListener mChildListener;
    private FirebaseAuth auth;
    private FirebaseUser mFirebaseUser;
    Button btnProfile, btnImage;
    ImageView imgView;
    TextView tvName;
GiaoVien giaoVien;
    //Firebase Storage
    private FirebaseStorage mStorage;
    private StorageReference mStorageRef;

    private static final String TAG = "ReadAndWriteSnippets";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_profile);

        tvName = findViewById(R.id.tvName);

        btnProfile = findViewById(R.id.btnProfile);
        btnImage = findViewById(R.id.btnImage);

        getData();

        btnImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
              intent.setType("image/jpeg");
              intent.putExtra(Intent.EXTRA_LOCAL_ONLY,true);
              startActivityForResult(intent.createChooser(intent,"Insert Picture"),42);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==PICTURE_RESULT && requestCode==RESULT_OK){
            Uri imageUri=data.getData();
            mStorage=FirebaseStorage.getInstance();
            mStorageRef=mStorage.getReference().child("GiaoVien_pictures");
            StorageReference ref=mStorageRef.child(imageUri.getLastPathSegment());
            ref.putFile(imageUri).addOnSuccessListener(this, new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    String url=taskSnapshot.getUploadSessionUri().toString();
                    giaoVien= new GiaoVien();
                    giaoVien.setImage(url);

                }
            });
        }
    }

    private void getData()
    {

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();
        mDatabaseReference=mFirebaseDatabase.getReference().child("GiaoVien");
        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot:dataSnapshot.getChildren()) {
                    GiaoVien gv = snapshot.getValue(GiaoVien.class);
                    gv.setId(snapshot.getKey());
                    String uid=auth.getCurrentUser().getUid();
                    if(gv.getId().equals(uid))
                    {
                        tvName.setText(gv.getName());
                       return;
                    }
                }

            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Getting Post failed, log a message
                Log.w(TAG, "loadPost:onCancelled", databaseError.toException());
            }
        });
    }

}

