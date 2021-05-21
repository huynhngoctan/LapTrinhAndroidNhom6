package com.example.laptrinhandroidnhom6.model;

public class ItemOfListOrder {
    private int id;
    private String name;
    private String img;
    private String addressDelivery;
    private int price;

    public ItemOfListOrder(int id, String name, String img, String addressDelivery, int price) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.addressDelivery = addressDelivery;
        this.price = price;
    }

    public ItemOfListOrder() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAddressDelivery() {
        return addressDelivery;
    }

    public void setAddressDelivery(String addressDelivery) {
        this.addressDelivery = addressDelivery;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
