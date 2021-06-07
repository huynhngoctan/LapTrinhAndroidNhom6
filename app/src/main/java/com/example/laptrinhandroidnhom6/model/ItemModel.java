package com.example.laptrinhandroidnhom6.model;

public class ItemModel {
    private  int img  ;
    private  String name ;
    private  String rate ;
    private  String price ;

    public  ItemModel(int img , String name , String rate , String price){
        this.img = img ;
         this.name = name ;
         this.rate = rate ;
         this.price = price  ;

    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
