package com.example.laptrinhandroidnhom6.profile;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.laptrinhandroidnhom6.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class UpdateInfo extends AppCompatActivity {
    Spinner spinner, spinner2;
    Button button;
    String[] year;
    String[] gender;
    ArrayAdapter<String> arrayAdapter;
    ArrayAdapter<String> arrayAdapter2;
    TextInputLayout textInputLayout;
    TextInputEditText textInputEditText;
    boolean isOK; //Check if email field is good

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_info);
        getSupportActionBar().hide();

        spinner = findViewById(R.id.spinerYear);
        spinner2 = findViewById(R.id.spinerGender);
        textInputLayout = findViewById(R.id.textIL);
        textInputEditText = findViewById(R.id.textIET);
        button = findViewById(R.id.updateButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirm(v);
            }
        });

        isOK = false;


        year = new String[72];
        gender = new String[2];
        for (int i = 0; i < year.length; i++){
            year[i] = 1950 + i + "";
        }

        gender[0] = "Nam";
        gender[1] = "Nữ";

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, year);
        spinner.setAdapter(arrayAdapter);
        arrayAdapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, gender);
        spinner2.setAdapter(arrayAdapter2);

        spinnerEvent();
        checkEmail();
    }

    public void returnBack(View v){
        finish();
    }

    public void spinnerEvent(){
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextSize(18);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextSize(18);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void checkEmail(){
        textInputEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String mail = s.toString();
                System.out.println(mail);
                if(s.length() > 35){
                    textInputLayout.setError("Email không quá 35 ký tự");
                    isOK = false;
                }
                else {
                    if(!isValidEmailAddress(mail)){
                        textInputLayout.setError("Email không hợp lệ");
                        isOK = false;
                    }
                    else {
                        textInputLayout.setError(null);
                        isOK = true;
                    }
                }
            }
        });
    }

    public void confirm(View v){
        if(!isOK){
            Toast.makeText(this, "Fuck you", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "ok boiz", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }
}
