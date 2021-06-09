package com.example.laptrinhandroidnhom6.profile;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.laptrinhandroidnhom6.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChangePassword extends AppCompatActivity {
    TextInputLayout til1, til2, til3;
    TextInputEditText tiet1, tiet2, tiet3;
    String password;
    boolean check1, check2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.change_pass);
        getSupportActionBar().hide();

        password = "";
        check1 = false;
        check2 = false;

        til1 = findViewById(R.id.textIL1);
        til2 = findViewById(R.id.textIL2);
        til3 = findViewById(R.id.textIL3);
        tiet1 = findViewById(R.id.textIET1);
        tiet2 = findViewById(R.id.textIET2);
        tiet3 = findViewById(R.id.textIET3);
        button = findViewById(R.id.changeP);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirm(v);
            }
        });

        checkPassword(til2, tiet2);
        checkRepeatPass(til3, tiet3);

    }

    public void returnBack(View v){
        finish();
    }

    public void checkPassword(TextInputLayout textL, TextInputEditText textE){
        textE.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String pass = s.toString();
                password = pass;
                if (s.length() < 8){
                    textL.setError("Mật khẩu không nhỏ hơn 8 ký tự");
                    check1 = false;
                }
                else {
                    if (s.length() > 20){
                        textL.setError("Mật khẩu không quá 20 ký tự");
                        check1 = false;
                    }
                    else {
                        if (checkSpecialCharacter(pass)){
                            textL.setError("Mật khẩu không chứa ký tự đặc biệt");
                            check1 = false;
                        }
                        else {
                            textL.setError(null);
                            check1 = true;
                        }
                    }
                }
            }
        });
    }

    public void checkRepeatPass(TextInputLayout textL, TextInputEditText textE){
        textE.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String pass = s.toString();
                if(!pass.equals(password)){
                    textL.setError("Mật khẩu không trùng khớp");
                    check2 = false;
                }
                else{
                    textL.setError(null);
                    check2 = true;
                }
            }
        });
    }

    public boolean checkSpecialCharacter(String s){
        Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        Matcher hasSpecial = special.matcher(s);
        return hasSpecial.find();
    }

    public void confirm(View v){
        if (check1 && check2){
            Toast.makeText(this, "ok master", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "No fuck you leather man", Toast.LENGTH_SHORT).show();
        }
    }

}
