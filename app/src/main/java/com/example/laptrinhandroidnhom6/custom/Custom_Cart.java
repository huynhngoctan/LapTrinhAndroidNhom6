package com.example.laptrinhandroidnhom6.custom;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.laptrinhandroidnhom6.R;
import com.example.laptrinhandroidnhom6.load_image_internet.LoadImage;
import com.example.laptrinhandroidnhom6.model.ItemOfListOrder;

import java.util.ArrayList;

public class Custom_Cart extends BaseAdapter {
    private ArrayList<ItemOfListOrder> listOrder;
    private Activity activity;

    public Custom_Cart(ArrayList<ItemOfListOrder> listOrder, Activity activity) {
        this.listOrder = listOrder;
        this.activity = activity;
    }


    @Override
    public int getCount() {
        return listOrder.size();
    }

    @Override
    public Object getItem(int position) {
        return listOrder.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        convertView = inflater.inflate(R.layout.item_cart, null);
        TextView  name,price,quantity;
        ImageView img;
        Button btnDiscount,btnIncrease;
        img = convertView.findViewById(R.id.img);
        name = convertView.findViewById(R.id.nameFood);
        price = convertView.findViewById(R.id.price);
//        btnDiscount = convertView.findViewById(R.id.btnDiscount);
//        btnIncrease = convertView.findViewById(R.id.btnIncrease);
//        quantity = convertView.findViewById(R.id.quantity);

        new LoadImage(img).execute(listOrder.get(position).getImg());
        name.setText(listOrder.get(position).getName());
        price.setText(listOrder.get(position).getPrice()+"");



        return convertView;
    }

}
