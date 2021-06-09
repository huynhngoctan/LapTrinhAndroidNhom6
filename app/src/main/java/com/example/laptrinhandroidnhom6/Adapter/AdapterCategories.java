package com.example.laptrinhandroidnhom6.Adapter;

import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.laptrinhandroidnhom6.R;
import com.example.laptrinhandroidnhom6.model.CategoriesModel;

import java.util.ArrayList;

public class AdapterCategories extends RecyclerView.Adapter<AdapterCategories.Categories> {

    ArrayList<CategoriesModel> listCategories ;
       int itemSelected = 0 ;

    public AdapterCategories( ArrayList<CategoriesModel> listCategories){
        this.listCategories = listCategories  ;
    }

    @NonNull
    @Override
    public Categories onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item , parent , false) ;


        return  new Categories(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  AdapterCategories.Categories holder, int position) {
            if(position==itemSelected){
                holder.nameItem.setText(listCategories.get(position).getName());
                holder.imageItem.setImageResource(listCategories.get(position).getImg()) ;
                holder.linearLayout.setBackgroundResource(R.drawable.bg_item);
                holder.nameItem.setTextColor(Color.parseColor("#3fc979"));
                holder.imageItem.setColorFilter(Color.parseColor("#3fc979"));


            }
            else {
                holder.nameItem.setText(listCategories.get(position).getName());
                holder.imageItem.setImageResource(listCategories.get(position).getImg());
                holder.linearLayout.setBackgroundResource(R.drawable.bg_item_no_selection);
                holder.nameItem.setTextColor(Color.parseColor("#000000"));
                holder.imageItem.setColorFilter(Color.parseColor("#000000"));
            }

    }

    @Override
    public int getItemCount() {
        return listCategories.size();
    }

    public  class Categories extends RecyclerView.ViewHolder{
            ImageView imageItem  ;
            LinearLayout linearLayout ;
            TextView nameItem ;

        public Categories(@NonNull View itemView) {
            super(itemView);

            imageItem = itemView.findViewById(R.id.image_item) ;
            linearLayout = itemView.findViewById(R.id.linearLayout_item);
            nameItem  =itemView.findViewById(R.id.name_item) ;

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemSelected = getAdapterPosition() ;
                    notifyDataSetChanged();
                    //#c7c6c7
                }
            });
        }
    }
}
