package com.example.laptrinhandroidnhom6.profile;

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

import androidx.appcompat.app.AppCompatActivity;

import com.example.laptrinhandroidnhom6.R;
import com.example.laptrinhandroidnhom6.database.ContactDB;
import com.example.laptrinhandroidnhom6.database.UserDB;
import com.example.laptrinhandroidnhom6.model.ContactM;
import com.example.laptrinhandroidnhom6.model.User;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Contact extends AppCompatActivity {
    Spinner spinner;
    EditText te;
    TextInputLayout tl;
    String[] problem;
    ImageView imageView;
    ArrayAdapter<String> arrayAdapter;
    Button button;
    User user;
    ContactDB cdb;
    UserDB db;
    boolean isOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact);
        getSupportActionBar().hide();

        cdb = new ContactDB();
        db = new UserDB();
        user = Profile.getStaticUser();

        spinner = findViewById(R.id.contactType);
        imageView = findViewById(R.id.returnPC);
        button = findViewById(R.id.contactButton);
        te = findViewById(R.id.textArea_information);
        tl = findViewById(R.id.textCt);

        problem = new String[4];

        problem[0] = "Thức ăn";
        problem[1] = "Dịch vụ";
        problem[2] = "Thanh Toán";
        problem[3] = "Góp ý";

        arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, problem);
        spinner.setAdapter(arrayAdapter);

        spinnerEvent();
        checkMessage();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isOK) {
                    cdb.insertContact(saveContact());
                    if(cdb.isOk()){
                        System.out.println("Whoops");
                    }
                }
            }
        });
    }

    public void spinnerEvent() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) parent.getChildAt(0)).setTextSize(18);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void checkMessage(){
        te.addTextChangedListener(new TextWatcher() {
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
                if(s.length() < 3){
                    tl.setError("Vui lòng không để trống tin nhắn");
                    isOK = false;
                }
                    else {
                        tl.setError(null);
                        isOK = true;
                    }
            }
        });
    }

    public ContactM saveContact(){
        ContactM m = new ContactM();

        String type = spinner.getSelectedItem().toString();
        String content = te.getText().toString();
        String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
        String status = "Chưa xử lý";
        String idUser = user.getIdUser();

        m.setIdUser(idUser);
        m.setContent(content);
        m.setDateCreate(date);
        m.setType(type);
        m.setStatus(status);

        return m;

    }
}
