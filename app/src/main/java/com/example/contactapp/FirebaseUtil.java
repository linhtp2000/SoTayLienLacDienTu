package com.example.contactapp;

import android.app.Activity;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirebaseUtil {
    public  static FirebaseDatabase mFirebaseDatabase;
    public static DatabaseReference mDatabaseReference;
    private  static FirebaseUtil firebaseUtil;
    public  static FirebaseAuth mFirebaseAuth;
    public static FirebaseAuth.AuthStateListener mAuthListener;
   // public static ArrayList<RegisterActivity> mDeals;
    private static final int RC_SIGN_IN = 123;
    public static FirebaseUser mFirebaseUser;
    private  FirebaseUtil(){};
    private static Activity caller;
    private static final String TAG = "ReadAndWriteSnippets";
  //  public static String user;
   public  static void openFbReference(String ref)
   {
       if(firebaseUtil==null){
           firebaseUtil= new FirebaseUtil();
           mFirebaseDatabase=FirebaseDatabase.getInstance();
           mFirebaseAuth=FirebaseAuth.getInstance();
           mFirebaseUser= FirebaseAuth.getInstance().getCurrentUser();
//           caller= callerActivity;
//           mAuthListener= new FirebaseAuth.AuthStateListener() {
//               @Override
//               public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//
//                    if(firebaseAuth.getCurrentUser()==null) {
//                        FirebaseUtil.signIn();
//                    }
//
//                   Toast.makeText(callerActivity.getBaseContext(),"Welcome comeback", Toast.LENGTH_LONG).show();
//               }
//           };
       }
//       mDeals= new ArrayList<Register>();
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
