package com.example.laptrinhandroidnhom6.model;

public class OrderDetail {
    String idOrder;
    String idFood;
    int priceFood;
    int quantity;

    public OrderDetail(String idOrder, String idFood, int priceFood, int quantity) {
        this.idOrder = idOrder;
        this.idFood = idFood;
        this.priceFood = priceFood;
        this.quantity = quantity;
    }

    public OrderDetail() {
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public String getIdFood() {
        return idFood;
    }

    public void setIdFood(String idFood) {
        this.idFood = idFood;
    }

    public int getPriceFood() {
        return priceFood;
    }

    public void setPriceFood(int priceFood) {
        this.priceFood = priceFood;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
