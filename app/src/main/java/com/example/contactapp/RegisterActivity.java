package com.example.contactapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.FileUtils;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.contactapp.Models.Admin;
import com.example.contactapp.Models.GiaoVien;
import com.example.contactapp.Models.PhuHuynh;
import com.example.contactapp.Models.QuanLy;
import com.example.contactapp.Models.SinhVien;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class RegisterActivity extends AppCompatActivity {

    private EditText inputEmail, inputPassword;
    private Button btnSignIn, btnSignUp, btnResetPassword;
    private static  FirebaseAuth auth;
    private Spinner spnRole;

    private static final String TAG = "ReadAndWriteSnippets";
    private Button btnSignup, btnLogin;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private ChildEventListener mChildListener;
    public  static FirebaseAuth mFirebaseAuth;
    public static FirebaseAuth.AuthStateListener mAuthListener;
    private String[] lstRole={"GiaoVien","PhuHuynh","SinhVien"};
    int role=0;
    private static int check=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        btnSignIn = (Button) findViewById(R.id.btnLogin);
        btnSignUp = (Button) findViewById(R.id.btnResgister);
        inputEmail = (EditText) findViewById(R.id.edtEmail);
        inputPassword = (EditText) findViewById(R.id.edtPassword);
        spnRole=findViewById(R.id.spnRole);


        ArrayAdapter list = new ArrayAdapter(this, android.R.layout.simple_spinner_item,lstRole);
        list.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spnRole.setAdapter(list);
        spnRole.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                role=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mFirebaseDatabase=FirebaseDatabase.getInstance();
        mDatabaseReference=mFirebaseDatabase.getReference();

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();

                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                    dialogError(Gravity.CENTER);
//                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }

                //create user
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                               // Toast.makeText(RegisterActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();

                                if (!task.isSuccessful()) {
                                    //Email đã tồn tại
                                    if(CheckMailExist(email))
                                    {
                                        Toast.makeText(RegisterActivity.this, "Account has been exist!", Toast.LENGTH_SHORT).show();
                                    }
                                    else {
                                    Toast.makeText(RegisterActivity.this, "Authentication failed." , Toast.LENGTH_SHORT).show();
                                    }
                                }
                                else {
                                    FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
                                    if(role==0)
                                    {
                                        GiaoVien gv= new GiaoVien();
                                        gv.setEmail(email);
                                        gv.setName(null);
                                        gv.setPhone(null);
                                        gv.setId(null);

                                      //  mDatabaseReference.child("GiaoVien").push().setValue(user.getUid());
                                        mDatabaseReference.child("GiaoVien").child(user.getUid()).setValue(gv);
                                    }
                                    if(role==1)
                                    {
                                        PhuHuynh ph= new PhuHuynh();
                                        ph.setEmail(email);
                                        ph.setName(null);
                                        ph.setPhone(null);
                                        ph.setSinhVien(null);

                                      //    mDatabaseReference.child("PhuHuynh").push().setValue(user.getUid());
                                        mDatabaseReference.child("PhuHuynh").child(user.getUid()).setValue(ph.getEmail());
                                    }
                                    if(role==2)
                                    {
                                        SinhVien sv= new SinhVien();
                                        sv.setEmail(email);
                                        sv.setLop(null);
                                        sv.setName(null);
                                        sv.setPhone(null);
                                      //  mDatabaseReference.child("SinhVien").push().setValue(user.getUid());
                                        mDatabaseReference.child("SinhVien").child(user.getUid()).setValue(sv);
                                    }

                                    Toast.makeText(RegisterActivity.this, "Sign up successfully!" , Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                                    finish();
                                }
                            }
                        });
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
     //   progressBar.setVisibility(View.GONE);
    }
    //Kiểm tra Email đã tồn tại
    private boolean CheckMailExist (String email) {
    mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference=mFirebaseDatabase.getReference().child("GiaoVien");
     //   mDatabaseReference=FirebaseDatabase.getInstance().getReference().child("GiaoVien");
        mChildListener= new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                GiaoVien gv =snapshot.getValue(GiaoVien.class);
                if(gv.getEmail().equals(email))
                {
                    check=1;
                }
            }
            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        };
        mDatabaseReference.addChildEventListener(mChildListener);
    if(check==1)
    {return true;}

        return false;
    }
//    public static  void attachListener(){
//        mFirebaseAuth.addAuthStateListener(mAuthListener);
//    }
//    public static  void detachListener(){
//        mFirebaseAuth.removeAuthStateListener(mAuthListener);
//    }
    private void dialogError(int gravity){
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialogerror2);

        Window window = dialog.getWindow();
        if(window == null)
        {
            return;
        }
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = gravity;
        window.setAttributes(windowAttributes);
        if(Gravity.BOTTOM == gravity)
        {
            dialog.setCancelable(true);
        }
        else {
            dialog.setCancelable(false);
        }
        Button btn_oke = (Button) dialog.findViewById(R.id.btn_dialogError_Oke1);
        btn_oke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}

