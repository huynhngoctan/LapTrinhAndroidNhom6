package com.example.laptrinhandroidnhom6.database;

import androidx.annotation.NonNull;

import com.example.laptrinhandroidnhom6.model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UserDB {
    DatabaseReference fbDatabase;
    private User user = null;
    boolean ok;

    public UserDB(){
        fbDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public List<User> getData(){
        List<User> user = new ArrayList<>();
        fbDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot d : snapshot.getChildren()){
                    User u = new User();
                    u = d.getValue(User.class);
                    user.add(u);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return user;
    }

    public void getUser(String id){
        fbDatabase.child("User").child(id).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                    setUser(snapshot.getValue(User.class));
                    ok = true;
                    System.out.println(user.toString());


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public boolean updateUser(User user){
        try{
            fbDatabase.child("User").child(user.getIdUser()).setValue(user);
            return true;
        }
        catch (DatabaseException e){
            e.printStackTrace();
            return false;
        }
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user){
        this.user = user;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }
}
