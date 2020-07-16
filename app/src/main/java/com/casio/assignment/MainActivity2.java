package com.casio.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    private EditText etemailrec;
    private Button btnreset;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        etemailrec = findViewById(R.id.etemailrec);
        btnreset = findViewById(R.id.btnreset);

        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = etemailrec.getText().toString().trim();

                validate();
            }
        });
    }

    private void validate() {
        if (email.isEmpty()) {
            etemailrec.setError("email cannot bet empty");}
        else {
            Toast.makeText(getApplicationContext(), "Now click the reset botton", Toast.LENGTH_LONG).show();}
    }
}