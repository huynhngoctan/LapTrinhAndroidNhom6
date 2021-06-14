package com.example.laptrinhandroidnhom6.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.laptrinhandroidnhom6.R;
import com.google.android.material.textfield.TextInputEditText;

public class ChangePhone extends AppCompatActivity {
    private TextInputEditText t;
    ImageView button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_phone);
        getSupportActionBar().hide();

        t = findViewById(R.id.phoneF);
        button = findViewById(R.id.returnP);

        findViewById(R.id.changeP).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = t.getText().toString();
                Intent i = new Intent(ChangePhone.this, UpdatePhone.class).putExtra("phone", phone);
                startActivity(i);
                finish();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnToProfile();
            }
        });
    }

    public void returnToProfile(){
        finish();
    }


}
