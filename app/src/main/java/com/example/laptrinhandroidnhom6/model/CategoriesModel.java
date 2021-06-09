package com.example.laptrinhandroidnhom6.model;

public class CategoriesModel {
     private  String name ;
     private  int img ;

     public CategoriesModel(String name , int img){
         this.name = name ;
         this.img = img ;
     }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
