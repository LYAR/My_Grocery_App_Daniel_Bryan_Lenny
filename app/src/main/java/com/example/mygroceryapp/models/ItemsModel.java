package com.example.mygroceryapp.models;

import java.io.Serializable;

public class ItemsModel implements Serializable {
    int id, image;
    String name, desc, price;

    public ItemsModel() {
    }

    public ItemsModel(int id, int image, String name, String desc, String price) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.desc = desc;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
