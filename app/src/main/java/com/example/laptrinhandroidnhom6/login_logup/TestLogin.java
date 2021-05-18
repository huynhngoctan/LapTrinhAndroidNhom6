package com.example.laptrinhandroidnhom6.login_logup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.laptrinhandroidnhom6.R;
import com.google.firebase.auth.FirebaseAuth;

public class TestLogin extends AppCompatActivity {
    TextView tvEmailName;
    Button btnSignout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_login);

        tvEmailName = findViewById(R.id.textViewEmailName);
        btnSignout = findViewById(R.id.buttonSignout);
        Intent intent = getIntent();
        tvEmailName.setText(intent.getStringExtra("email"));
        btnSignout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
            }
        });

    }
}