package com.example.mygroceryapp.models;

import java.io.Serializable;

public class CartModel implements Serializable {
    String item_id, name, desc, quantity, price;

    public CartModel() {
    }

    public CartModel(String item_id, String name, String desc, String quantity, String price) {
        this.item_id = item_id;
        this.name = name;
        this.desc = desc;
        this.quantity = quantity;
        this.price = price;
    }



    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
