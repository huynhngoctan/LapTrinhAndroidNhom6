package com.example.laptrinhandroidnhom6.profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.laptrinhandroidnhom6.MainActivity;
import com.example.laptrinhandroidnhom6.R;
import com.example.laptrinhandroidnhom6.database.UserDB;
import com.example.laptrinhandroidnhom6.model.User;
import com.google.android.gms.dynamic.ObjectWrapper;

public class Profile extends Fragment{
    TextView textView1, textView2, textView3, textView5;
    String id ;
    UserDB db;
    public static User user;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        db = new UserDB();
        db.getUser("00001");
        View view = inflater.inflate(R.layout.profile, container, false);
        textView1 = (TextView) view.findViewById(R.id.textv1);
        textView2 = (TextView) view.findViewById(R.id.textv2);
        textView3 = (TextView) view.findViewById(R.id.textv3);
        textView5 = (TextView) view.findViewById(R.id.textv5);

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(db.isOk()) {
                    user = db.getUser();
                    toUpdateInfo();
                }
                else {
                    System.out.println("Tan pro");
                }
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(db.isOk()) {
                    user = db.getUser();
                    toChangePass();
                }
                else {
                    System.out.println("Tan pro");
                }
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(db.isOk()) {
                    user = db.getUser();
                    toVerifyCode();
                }
            }
        });
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(db.isOk()) {
                    user = db.getUser();
                    toContact();
                }
            }
        });

        return view;
    }

    public void toUpdateInfo(){
//        User user = db.getUser();
        Intent i = new Intent(getActivity(), UpdateInfo.class);
        i.putExtra("user", user);
        startActivity(i);

    }

    public void toChangePass(){
        Intent i = new Intent(getActivity(), ChangePassword.class);
        User user = db.getUser();
        i.putExtra("user", user);
        startActivity(i);
    }

    public void toContact(){
        Intent i = new Intent(getActivity(), Contact.class);
        startActivity(i);
    }

    public void toOrderHistory(){
        Intent i = new Intent(getActivity(), ChangePhone.class);
        startActivity(i);
    }

    public void toVerifyCode(){
        Intent i = new Intent(getActivity(), VerifyCode.class);
        startActivity(i);
    }



    public static User getStaticUser(){
        return user;
    }

}