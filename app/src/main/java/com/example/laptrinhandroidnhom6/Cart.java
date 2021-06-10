package com.example.laptrinhandroidnhom6;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.example.laptrinhandroidnhom6.MainActivity;
import com.example.laptrinhandroidnhom6.R;
import com.example.laptrinhandroidnhom6.custom.Custom_Cart;
import com.example.laptrinhandroidnhom6.model.ItemOfListOrder;

import java.util.ArrayList;


public class Cart extends AppCompatActivity {
    Button btnOrder;

    ArrayList<ItemOfListOrder> listItem;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = findViewById(R.id.listOrderComing);
        createListItemOrder();
        Custom_Cart adapter = new Custom_Cart(listItem, this);
        listView.setAdapter(adapter);
        btnOrder = findViewById(R.id.btncart);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnOrder.setText("kkk");
            }
        });
    }

    public void createListItemOrder() {
        listItem = new ArrayList<>();
        listItem.add(new ItemOfListOrder(1, "ăn", "https://img.wattpad.com/cover/123681914-256-k224486.jpg", "SG", 200, "20-02-2021"));
        listItem.add(new ItemOfListOrder(1, "ăn", "https://img.wattpad.com/cover/123681914-256-k224486.jpg", "SG", 200, "20-02-2021"));
        listItem.add(new ItemOfListOrder(1, "ăn", "https://img.wattpad.com/cover/123681914-256-k224486.jpg", "SG", 200, "20-02-2021"));
        listItem.add(new ItemOfListOrder(1, "ăn", "https://img.wattpad.com/cover/123681914-256-k224486.jpg", "SG", 200, "20-02-2021"));
        listItem.add(new ItemOfListOrder(1, "ăn", "https://img.wattpad.com/cover/123681914-256-k224486.jpg", "SG", 200, "20-02-2021"));
        listItem.add(new ItemOfListOrder(1, "ăn", "https://img.wattpad.com/cover/123681914-256-k224486.jpg", "SG", 200, "20-02-2021"));
        listItem.add(new ItemOfListOrder(1, "ăn", "https://img.wattpad.com/cover/123681914-256-k224486.jpg", "SG", 200, "20-02-2021"));

    }


}