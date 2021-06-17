package com.example.laptrinhandroidnhom6.database;

import android.content.Context;
import android.widget.ListView;

import com.example.laptrinhandroidnhom6.model.ContactM;
import com.example.laptrinhandroidnhom6.model.OrderDetail;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class OrderDetailDB {

    DatabaseReference fbDatabase;
    private ContactM contactM = null;
    boolean ok;

    public OrderDetailDB() {
        fbDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public void insertContact(OrderDetail orderDetail) {
        try {
            String childID = fbDatabase.child("OrderDetail").push().getKey();
            orderDetail.setIdOrder(childID);
            fbDatabase.child("OrderDetail").child(childID).setValue(orderDetail);
            ok = true;
        } catch (DatabaseException e) {
            e.printStackTrace();
            ok = false;
        }

}}
