package com.example.laptrinhandroidnhom6.profile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.executor.TaskExecutor;

import com.example.laptrinhandroidnhom6.R;
import com.example.laptrinhandroidnhom6.model.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class VerifyCode extends AppCompatActivity {

    private String verifyID;
    private FirebaseAuth fbauth;
    private ProgressBar progressBar;
    private TextInputEditText editText;
    private TextView phone, resend, timeleft;
    private AtomicBoolean isRunning = new AtomicBoolean();
    private Handler handler;
    private int time;
    private TextInputLayout textInputLayout;
    private Thread th;
    int i  ;
    User user;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.verify_code);
        getSupportActionBar().hide();

        user = Profile.getStaticUser();

        time = 60;

        fbauth = FirebaseAuth.getInstance();

        textInputLayout = findViewById(R.id.text369);
        progressBar = findViewById(R.id.progressBar);
        editText = findViewById(R.id.code);
        phone = findViewById(R.id.phonenumber);
        resend = findViewById(R.id.resend);
        timeleft = findViewById(R.id.time);
        timeleft.setText("" + 60);

        handlerEvent();

        String p = user.getPhone().substring(1);
        String phonenumber = "+84" + p;

        phone.setText(phonenumber);

        sendVerificationCode(phonenumber);

        findViewById(R.id.verify).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = editText.getText().toString().trim();
                if(code.isEmpty() || code.length() < 6) {
                    textInputLayout.setError("Mã không đúng");
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                verifyCode(code);
            }
        });

        resend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i>=60){
                    sendVerificationCode(phonenumber);
                    time = 60;
                    i = 0;
                }

            }
        });
    }

    private void verifyCode(String code){
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verifyID, code);
        signInWithCredential(credential);

    }

    private void signInWithCredential(PhoneAuthCredential credential) {
        fbauth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(Task<AuthResult> task) {
                if(task.isSuccessful()){
                    progressBar.setVisibility(View.INVISIBLE);
                    Intent intent = new Intent(VerifyCode.this, ChangePhone.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
                else {
                    textInputLayout.setError("Mã không đúng hoặc đã hết thời gian");

                }
            }
        });
    }

    private void sendVerificationCode(String number){
        PhoneAuthOptions options = PhoneAuthOptions.newBuilder(fbauth).setPhoneNumber(number).setTimeout(
                60L, TimeUnit.SECONDS
        ).setActivity(this).setCallbacks(callBack).build();
        PhoneAuthProvider.verifyPhoneNumber(options);
        countdownTime();
    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks
        callBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);

            verifyID = s;
        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            String code = phoneAuthCredential.getSmsCode();
            if(code != null){
                verifyCode(code);
            }
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(VerifyCode.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    };

    public void handlerEvent(){
        handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                timeleft.setText("" + msg.arg1);
            }
        };
    }

    public void countdownTime(){
        isRunning.set(false);

        th = new Thread(new Runnable() {
            @Override
            public void run() {
                    for (i = 0; i <= 60 && isRunning.get(); i++) {
                        SystemClock.sleep(1000);
                        Message msg = handler.obtainMessage();
                        msg.arg1 = 60 - i;
                        handler.sendMessage(msg);
                    }
                }
        });
        isRunning.set(true);
        th.start();

    }

}
