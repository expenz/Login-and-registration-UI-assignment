package com.casio.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UIReview extends AppCompatActivity {

    private EditText etEmail, etpassword;
    private Button btnlogin;
    private TextView tvforgotpassword;

    private String email, password, resetpassword;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_review);

        etEmail = findViewById(R.id.etemail);
        etpassword = findViewById(R.id.etpassword);
        tvforgotpassword = findViewById(R.id.tvforgotpassword);
        btnlogin = findViewById(R.id.btnlogin);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = etEmail.getText().toString().trim();
                password = etpassword.getText().toString().trim();

                validate();
            }
        });

        tvforgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity2 btnreset = new MainActivity2();
                validate();
            }
        });
    }

    private void validate() {
        if (email.isEmpty()) {
            etEmail.setError("email cannot bet empty");}
        else if (password.isEmpty() || password.length() < 4){
            etpassword.setError("password cannot be empty or less than 4");}
        else {
            Toast.makeText(getApplicationContext(), "credentials succesfully entered", Toast.LENGTH_LONG).show();}
    }
}
