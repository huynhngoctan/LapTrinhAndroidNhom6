package com.example.laptrinhandroidnhom6;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.laptrinhandroidnhom6.Adapter.AdapterCategories;
import com.example.laptrinhandroidnhom6.Adapter.AdapterItem;
import com.example.laptrinhandroidnhom6.model.CategoriesModel;
import com.example.laptrinhandroidnhom6.model.ItemModel;

import java.util.ArrayList;

public class Home extends Fragment implements StartActivity {
    RecyclerView recyclerView ;
    AdapterCategories adapterCategories ;
    ArrayList<CategoriesModel> listCategories  ;

    RecyclerView recyclerViewItem ;
    AdapterItem adapterItem ;
    ArrayList<ItemModel> itemModels ;
    @Nullable

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable  ViewGroup container, @Nullable  Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.home_new , container , false) ;
        createListCategories();
        createListItem();
        recyclerView = view.findViewById(R.id.categories_rv) ;
        adapterCategories = new AdapterCategories(this.listCategories) ;
        recyclerView.setAdapter(adapterCategories);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext() , LinearLayoutManager.HORIZONTAL , false));

        recyclerViewItem = view.findViewById(R.id.item_detail_rv);
        adapterItem = new AdapterItem(this.itemModels , this);
        recyclerViewItem.setAdapter(adapterItem);
        recyclerViewItem.setLayoutManager(new GridLayoutManager(getContext() ,3));

        return view ;
    }
    public void createListCategories(){
        this.listCategories = new ArrayList<>() ;
        CategoriesModel m1 = new CategoriesModel(" Cà Phê" , R.drawable.caphe) ;
        CategoriesModel m2 = new CategoriesModel("Trà Sữa" , R.drawable.trasua) ;
        CategoriesModel m3 = new CategoriesModel(" Cơm"  , R.drawable.com) ;
        CategoriesModel m4 = new CategoriesModel("Phở" , R.drawable.pho) ;
        this.listCategories.add(m1) ;
        this.listCategories.add(m2) ;
        this.listCategories.add(m3) ;
        this.listCategories.add(m4) ;
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
        Intent intent = new Intent(getContext() , AItemDetail.class) ;
        startActivity(intent);
    }
}
