package com.example.laptrinhandroidnhom6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.laptrinhandroidnhom6.Adapter.AdapterItem;
import com.example.laptrinhandroidnhom6.model.ItemModel;

import java.util.ArrayList;

public class AItemDetail extends AppCompatActivity implements StartActivity{
    RecyclerView recyclerView ;
    ArrayList<ItemModel> itemModels ;
    AdapterItem adapterItem ;
    ImageView back ;
    Button btnaddCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_aitem_detail);
        createListItem();
        back = findViewById(R.id.back_home) ;
        recyclerView = findViewById(R.id.recyclerView_detail) ;
        adapterItem = new AdapterItem(this.itemModels , this);
        recyclerView.setAdapter(adapterItem);
        recyclerView.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false));
        btnaddCart = findViewById(R.id.addCart);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AItemDetail.this , MainActivity.class) ;
                startActivity(intent);
                finish();

            }
        });
        btnaddCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCart = new Intent(AItemDetail.this,Cart.class);
                startActivity(intentCart);

            }
        });
    }
    public void createListItem(){
        this.itemModels = new ArrayList<>();
        ItemModel m1 = new ItemModel(R.drawable.batcom , "Tấn Đập Choai" , "5.0" , "  $ 20");
        ItemModel m2 = new ItemModel(R.drawable.batcom , "Tấn Đập Choai" , "5.0" , "  $ 25");
        ItemModel m3 = new ItemModel(R.drawable.batcom , "Tấn Cơm Tró" , "5.0" , "  $ 30");
        ItemModel m4 = new ItemModel(R.drawable.batcom , "Tấn CƠm Tró" , "5.0" , "  $ 35");
        ItemModel m5 = new ItemModel(R.drawable.batcom , "Tấn Đập Choai" , "5.0" , "  $ 40");
        ItemModel m6 = new ItemModel(R.drawable.batcom , "Tấn Cơm Tró" , "5.0" , "  $ 45");
        this.itemModels.add(m1);
        this.itemModels.add(m2);
        this.itemModels.add(m3);
        this.itemModels.add(m4);
        this.itemModels.add(m5);
        this.itemModels.add(m6);
        this.itemModels.add(m6);
        this.itemModels.add(m6);
        this.itemModels.add(m6);
        this.itemModels.add(m6);
        this.itemModels.add(m6);
        this.itemModels.add(m6);
        this.itemModels.add(m6);
        this.itemModels.add(m6);
        this.itemModels.add(m6);


    }

    @Override
    public void startActivity() {

    }
}