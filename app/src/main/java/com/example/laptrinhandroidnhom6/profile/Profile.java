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

import com.example.laptrinhandroidnhom6.R;

public class Profile extends Fragment{
    TextView textView1, textView2, textView3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile, container, false);
        textView1 = (TextView) view.findViewById(R.id.textv1);
        textView2 = (TextView) view.findViewById(R.id.textv2);
        textView3 = (TextView) view.findViewById(R.id.textv3);

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toUpdateInfo();
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toChangePass();
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toChangePhone();
            }
        });

        return view;
    }

    public void toUpdateInfo(){
        Intent i = new Intent(getActivity(), UpdateInfo.class);
        startActivity(i);

    }

    public void toChangePass(){
        Intent i = new Intent(getActivity(), ChangePassword.class);
        startActivity(i);
    }

    public void toChangePhone(){
        Intent i = new Intent(getActivity(), ChangePhone.class);
        startActivity(i);
    }

    public void toOrderHistory(){
        Intent i = new Intent(getActivity(), ChangePhone.class);
        startActivity(i);
    }
}