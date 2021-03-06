package com.example.contactapp.Admin;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.contactapp.Admin.Adapter.AdapterClass;
import com.example.contactapp.Models.SinhVien;
import com.example.contactapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Student extends AppCompatActivity {



    DatabaseReference database;

    private AdapterClass.RecyclerVieWClickListener listener;
    Dialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_sv);
        TextView studentName=findViewById(R.id.txtNameStudentEdit);

        Bundle extras=getIntent().getExtras();
        dialog=new Dialog(Student.this);
        studentName.setText(extras.getString("name"));
        TextView mail=findViewById(R.id.editTextMailManager);
        mail.setText(extras.getString("mail"));






        database= FirebaseDatabase.getInstance().getReference("SinhVien");
        database.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //list=new ArrayList<>();

                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    //  Lop lop=dataSnapshot.getValue(Lop.class);
                    SinhVien student=dataSnapshot.getValue(SinhVien.class);
                    student.setId(dataSnapshot.getKey());

                    if((student.getEmail()).equals(mail.getText().toString()))
                    {
                        TextView txtPhone=findViewById(R.id.editTextName);
                        txtPhone.setText(student.getPhone());
                        TextView txtId=findViewById(R.id.txtId);
                        txtId.setText(student.getId());
                        TextView txtAddr=findViewById(R.id.txtAddressStudent);
                        txtAddr.setText(student.getAddress());
                        TextView txtMSSV=findViewById(R.id.txtMssv);
                        txtMSSV.setText(student.getMSSV());


                        TextView txtclass=findViewById(R.id.txtClassNameStudent);
                        txtclass.setText(student.getLop());




                    }







                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        Button btnDelete=findViewById(R.id.btnDeleteStudent);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openDialogSure();

            }
        });
        Button btnEdit=findViewById(R.id.btnOkSure);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txtPhone=findViewById(R.id.editTextName);
                TextView txtclass=findViewById(R.id.txtClassNameStudent);

                TextView id=findViewById(R.id.txtId);
                TextView txtMSSV=findViewById(R.id.txtMssv);
                TextView Addr=findViewById(R.id.txtAddressStudent);

                Intent intent=new Intent(v.getContext(), EditStudent.class);
                intent.putExtra("id", id.getText().toString());

                intent.putExtra("class", txtclass.getText().toString());
                intent.putExtra("mail",mail.getText().toString());
                intent.putExtra("name", studentName.getText().toString());
                intent.putExtra("phone",txtPhone.getText().toString());
                intent.putExtra("address", Addr.getText().toString());
                intent.putExtra("mssv", txtMSSV.getText().toString());


                v.getContext().startActivity(intent);
            }
        });











    }





    private void openDialogSure(){
        dialog.setContentView(R.layout.dialogsure);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        Button btnOk=dialog.findViewById(R.id.btnOkSure);
        Button btnCancle =dialog.findViewById(R.id.btnCancleSure);
        TextView txtClassName=findViewById(R.id.txtClassNameStudent);
        dialog.show();

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView id=findViewById(R.id.txtId);
                String Id=id.getText().toString();
                database.child(Id).setValue(null);
                Toast.makeText(getApplicationContext(), "X??a th??nh c??ng",Toast.LENGTH_LONG).show();
                Intent intent= new Intent(v.getContext(),ListStudent.class);
                intent.putExtra("key",txtClassName.getText().toString());
                v.getContext().startActivity(intent);

            }
        });
        btnCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

    }
}
