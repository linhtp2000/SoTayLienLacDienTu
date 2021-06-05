package com.example.contactapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static androidx.core.app.ActivityCompat.startActivityForResult;

public class FirebaseUtil {
    public  static FirebaseDatabase mFirebaseDatabase;
    public static DatabaseReference mDatabaseReference;
    private  static FirebaseUtil firebaseUtil;
    public  static FirebaseAuth mFirebaseAuth;
    public static FirebaseAuth.AuthStateListener mAuthListener;
    public static ArrayList<Register> mDeals;
    private static final int RC_SIGN_IN = 123;
    private  FirebaseUtil(){};
    private static Activity caller;
   public  static void openFbReference(String ref, Activity callerActivity)
   {
       if(firebaseUtil==null){
           firebaseUtil= new FirebaseUtil();
           mFirebaseDatabase=FirebaseDatabase.getInstance();
           mFirebaseAuth=FirebaseAuth.getInstance();
           caller=callerActivity;
           mAuthListener= new FirebaseAuth.AuthStateListener() {
               @Override
               public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                    if(firebaseAuth.getCurrentUser()==null) {
                        FirebaseUtil.signIn();
                    }
                   Toast.makeText(callerActivity.getBaseContext(),"Welcome comeback", Toast.LENGTH_LONG).show();
               }
           };
       }
       mDeals= new ArrayList<Register>();
       mDatabaseReference=mFirebaseDatabase.getReference().child(ref);
   }

   private static void signIn()
   {
       List<AuthUI.IdpConfig> providers = Arrays.asList(
               new AuthUI.IdpConfig.EmailBuilder().build(),
               new AuthUI.IdpConfig.GoogleBuilder().build());

       // Create and launch sign-in intent
       caller.startActivityForResult(
               AuthUI.getInstance()
                       .createSignInIntentBuilder()
                       .setAvailableProviders(providers)
                       .build(),
               RC_SIGN_IN);
   }
   public static  void attachListener(){
       mFirebaseAuth.addAuthStateListener(mAuthListener);
   }
    public static  void detachListener(){
        mFirebaseAuth.removeAuthStateListener(mAuthListener);
    }
}
