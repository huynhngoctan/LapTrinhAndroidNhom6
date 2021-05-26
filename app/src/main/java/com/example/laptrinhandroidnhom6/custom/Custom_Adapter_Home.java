package com.example.laptrinhandroidnhom6.custom;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.laptrinhandroidnhom6.R;
import com.example.laptrinhandroidnhom6.load_image_internet.LoadImage;
import com.example.laptrinhandroidnhom6.model.ItemOfListOrder;

import java.util.ArrayList;

public class Custom_Adapter_Home extends BaseAdapter {
    private ArrayList<ItemOfListOrder> listOrder;
    private Activity activity;

    public Custom_Adapter_Home(ArrayList<ItemOfListOrder> listOrder, Activity activity) {
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
        convertView = inflater.inflate(R.layout.item_home, null);

        TextView name,  price;
        ImageView img;
        img = convertView.findViewById(R.id.img);
        name = convertView.findViewById(R.id.nameFood);

        price = convertView.findViewById(R.id.price);

        //sử dụng ảnh online

        //ánh xạ
        new LoadImage(img).execute(listOrder.get(position).getImg());
        name.setText(listOrder.get(position).getName());

        price.setText(listOrder.get(position).getPrice()+"");

        return convertView;
    }

}
