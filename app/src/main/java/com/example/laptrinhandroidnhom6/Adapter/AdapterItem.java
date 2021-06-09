package com.example.laptrinhandroidnhom6.Adapter;

import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.laptrinhandroidnhom6.MainActivity;
import com.example.laptrinhandroidnhom6.R;
import com.example.laptrinhandroidnhom6.StartActivity;
import com.example.laptrinhandroidnhom6.model.ItemModel;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterItem extends RecyclerView.Adapter<AdapterItem.ItemViewHolder> {
    ArrayList<ItemModel> listItem ;
    StartActivity startActivity ;

    public  AdapterItem(ArrayList<ItemModel> list , StartActivity startActivity){

        this.listItem = list ;
        this.startActivity = startActivity ;
    }

    @NonNull
    @Override


    public ItemViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail , parent , false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  AdapterItem.ItemViewHolder holder, int position) {

        holder.circleImageView.setImageResource(listItem.get(position).getImg());
        holder.name.setText(listItem.get(position).getName());
        holder.price.setText(listItem.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public  class ItemViewHolder extends RecyclerView.ViewHolder{
            LinearLayout linearLayout ;
            CircleImageView circleImageView ;
            TextView name , price  ;
            RatingBar ratingBar ;
        public ItemViewHolder( View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.image_circle_item);
            name = itemView.findViewById(R.id.name_item);
            price = itemView.findViewById(R.id.item_price);
            ratingBar = itemView.findViewById(R.id.rating_bar);
            linearLayout = itemView.findViewById(R.id.linearLayout_categories_detail);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                startActivity.startActivity();
                }
            });
        }
    }
}
