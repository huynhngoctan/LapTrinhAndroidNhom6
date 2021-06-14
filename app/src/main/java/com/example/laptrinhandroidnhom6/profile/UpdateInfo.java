package com.example.laptrinhandroidnhom6.profile;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.laptrinhandroidnhom6.MainActivity;
import com.example.laptrinhandroidnhom6.R;
import com.example.laptrinhandroidnhom6.database.UserDB;
import com.example.laptrinhandroidnhom6.model.User;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class UpdateInfo extends AppCompatActivity {
    Spinner spinner, spinner2;
    EditText name, username, phoneU;
    Button button;
    String[] year;
    String[] gender;
    ImageView iv;
    ArrayAdapter<String> arrayAdapter;
    ArrayAdapter<String> arrayAdapter2;
    TextInputLayout textInputLayout;
    TextInputEditText textInputEditText;
    boolean isOK; //Check if email field is good
    User user;
    UserDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_info);
        getSupportActionBar().hide();

        db = new UserDB();

        spinner = findViewById(R.id.spinerYear);
        spinner2 = findViewById(R.id.spinerGender);
        textInputLayout = findViewById(R.id.textIL);
        textInputEditText = findViewById(R.id.textIET);
        button = findViewById(R.id.updateButton);
        name = findViewById(R.id.name);
        username = findViewById(R.id.username);
        phoneU = findViewById(R.id.phoneU);
        iv = findViewById(R.id.returnPU);


//        user = (User) getIntent().getSerializableExtra("user");
        user = Profile.getStaticUser();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(confirm(v)){
                    update();
                    db.updateUser(user);
                    returnBack(v);
                }

            }
        });

        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnBack(v);
            }
        });

        isOK = true;

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

        username.setText(user.getUsername());
        phoneU.setText(String.valueOf(user.getPhone()));
        textInputEditText.setText(user.getEmail());
        name.setText(user.getName());
        setSpinner1(user.getYearOfBirth());
        setSpinner2(user.getGender());
        spinnerEvent();
        checkEmail();
    }

    public void returnBack(View v){
        Intent intent = new Intent(UpdateInfo.this , MainActivity.class);
        intent.putExtra( "profile","profile");
        intent.putExtra("number" , 3);
        startActivity(intent);
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

    public boolean confirm(View v){
        if(!isOK){
            return false;
        }
        else {
            return true;
        }
    }

    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    public void setSpinner1(long yearOfBirth){
        String y = Long.toString(yearOfBirth);
        System.out.println("y = " + y);
        for(int i = 0; i < year.length; i++){
            if(year[i].equals(y)){
                spinner.setSelection(i);
            }
        }
    }

    public void setSpinner2(String gen){
        for(int i = 0; i < gender.length; i++){
            if(gender[i].equals(gen)){
                spinner2.setSelection(i);
            }
        }
    }

    public void update(){
        String un = username.getText().toString();
        String n = name.getText().toString();
        long y = Long.valueOf(spinner.getSelectedItem().toString());
        String e = textInputEditText.getText().toString();
        String g = spinner2.getSelectedItem().toString();

        user.setUsername(un);
        user.setName(n);
        user.setYearOfBirth(y);
        user.setEmail(e);
        user.setGender(g);
    }
}
