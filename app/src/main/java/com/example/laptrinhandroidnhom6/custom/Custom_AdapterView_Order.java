package com.example.laptrinhandroidnhom6.custom;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.laptrinhandroidnhom6.R;
import com.example.laptrinhandroidnhom6.model.ItemOfListOrder;

import java.util.ArrayList;

public class Custom_AdapterView_Order extends BaseAdapter {
    private ArrayList<ItemOfListOrder> listOrder;
    private Activity activity;

    public Custom_AdapterView_Order(ArrayList<ItemOfListOrder> listOrder, Activity activity) {
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
        convertView = inflater.inflate(R.layout.items_of_list_order, null);

        TextView img, name, address, price;
        img = convertView.findViewById(R.id.img);
        name = convertView.findViewById(R.id.nameFood);
        address = convertView.findViewById(R.id.address);
        price = convertView.findViewById(R.id.price);
        img.setText(listOrder.get(position).getImg());
        name.setText(listOrder.get(position).getName());
        address.setText(listOrder.get(position).getAddressDelivery());
        price.setText(listOrder.get(position).getPrice());
        return convertView;
    }
}
