package com.example.laptrinhandroidnhom6.database;

import com.example.laptrinhandroidnhom6.model.ContactM;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ContactDB {
    DatabaseReference fbDatabase;
    private ContactM contactM = null;
    boolean ok;

    public ContactDB() {
        fbDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public void insertContact(ContactM contact) {
        try {
            String childID = fbDatabase.child("Contact").push().getKey();
            contact.setIdContact(childID);
            fbDatabase.child("Contact").child(childID).setValue(contact);
            ok = true;
        } catch (DatabaseException e) {
            e.printStackTrace();
            ok = false;
        }

    }

    public boolean isOk() {
        return ok;
    }
}
