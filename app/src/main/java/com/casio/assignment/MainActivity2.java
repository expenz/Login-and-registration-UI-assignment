package com.casio.assignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity2 extends AppCompatActivity {

    private EditText etemailrec;
    private Button btnreset;
    private String email;
    private FirebaseAuth mAuth;
    FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mAuth = FirebaseAuth.getInstance();

        etemailrec = findViewById(R.id.etemailrec);
        btnreset = findViewById(R.id.btnreset);

        etemailrec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = etemailrec.getText().toString().trim();
            }
        });

        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate();
            }
        });
    }

    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        currentUser = mAuth.getCurrentUser();
//        updateUI(currentUser);
    }

    private void proceedReset() {
        mAuth.sendPasswordResetEmail(email)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Log.d("TAG", "Email sent.");
                            Toast.makeText(getApplicationContext(), "Email sent.",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


    private void validate() {
        if (email.isEmpty()) {
            etemailrec.setError("email cannot bet empty");}
        else {
            proceedReset();
        }
    }
}