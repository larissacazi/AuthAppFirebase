package zimmermann.larissa.authapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        //Check if user is logged in
        if(firebaseAuth.getCurrentUser() != null) {
            Log.i(TAG, "User is already logged in!");
            String email = firebaseAuth.getCurrentUser().getEmail();
            Log.i(TAG, "User: " + email);

            //Logout
            firebaseAuth.signOut();
            Log.i(TAG, "Logout!");
        }
        else {
            Log.i(TAG, "Logged out!");
        }

        /*
        //Login
        Task<AuthResult> resultTask = firebaseAuth.signInWithEmailAndPassword("larissa@larissa.com", "123456")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {//success
                            Log.i(TAG, "Successfully signed in!");
                        }
                        else {
                            Log.i(TAG, "User NOT signed in!");
                            FirebaseAuthException e = (FirebaseAuthException )task.getException();
                            Log.i(TAG, "Failed signed in: " + e.getMessage());
                        }
                    }
                });
        */


        /*
        //Register User
        firebaseAuth.createUserWithEmailAndPassword("larissa@larissa.com", "123456")
                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {//success
                            Log.i(TAG, "User successfully registered!");
                        }
                        else {
                            Log.i(TAG, "User NOT registered!");
                            FirebaseAuthException e = (FirebaseAuthException )task.getException();
                            Log.i(TAG, "Failed Registration: " + e.getMessage());
                        }
                    }
                });
        */
    }
}
