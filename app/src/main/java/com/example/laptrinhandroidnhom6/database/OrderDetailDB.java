package com.example.laptrinhandroidnhom6.database;

import android.content.Context;
import android.widget.ListView;

import com.example.laptrinhandroidnhom6.model.ContactM;
import com.example.laptrinhandroidnhom6.model.Order;
import com.example.laptrinhandroidnhom6.model.OrderDetail;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class OrderDetailDB {

    DatabaseReference fbDatabase;
    private ContactM contactM = null;
    boolean ok;
    String idOrder;


    public OrderDetailDB() {
        fbDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public void insertOrder(Order order) {
        try {

            String childID = fbDatabase.child("Order").push().getKey();
            order.setIdOrder(childID);
            idOrder = childID;
            fbDatabase.child("Order").child(childID).setValue(order);
            ok = true;
        } catch (DatabaseException e) {
            e.printStackTrace();
            ok = false;
        }

    }

    public void insertOrderDetail(OrderDetail orderDetail, ArrayList listFood) {
        try {
            for (int i = 0; i<listFood.size();i++){
                String childID = fbDatabase.child("OrderDetail").push().getKey();
                orderDetail.setIdOrderDetail(childID);
                orderDetail.setIdOrder(idOrder);
                fbDatabase.child("OrderDetail").child(childID).setValue(orderDetail);
                ok = true;
            }
        } catch (DatabaseException e) {
            e.printStackTrace();
            ok = false;
        }

    }

}
