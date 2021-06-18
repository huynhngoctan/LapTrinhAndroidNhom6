package com.example.laptrinhandroidnhom6.model;

public class Order {

    String idOrder;
    String idUser;
    String dateCreate;
    String dateDelivery;
    String status;
    String dateUpdate;
    int totalPrice;
    String paymentOption;
    String location;

    public Order(String idOrder, String idUser, String dateCreate, String dateDelivery, String status, String dateUpdate, int totalPrice, String paymentOption, String location) {
        this.idOrder = idOrder;
        this.idUser = idUser;
        this.dateCreate = dateCreate;
        this.dateDelivery = dateDelivery;
        this.status = status;
        this.dateUpdate = dateUpdate;
        this.totalPrice = totalPrice;
        this.paymentOption = paymentOption;
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(String idOrder) {
        this.idOrder = idOrder;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getDateDelivery() {
        return dateDelivery;
    }

    public void setDateDelivery(String dateDelivery) {
        this.dateDelivery = dateDelivery;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(String dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPaymentOption() {
        return paymentOption;
    }

    public void setPaymentOption(String paymentOption) {
        this.paymentOption = paymentOption;
    }
}
