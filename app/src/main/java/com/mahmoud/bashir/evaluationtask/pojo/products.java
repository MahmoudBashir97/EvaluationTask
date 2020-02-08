package com.mahmoud.bashir.evaluationtask.pojo;

import java.io.Serializable;
import java.util.List;

public class products implements Serializable {
    String id ;
    String name;
    String weight;
    String price;
    String product_img;

    public products(String id, String name, String weight, String price, String product_img) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.product_img = product_img;
    }

    public products() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProduct_img() {
        return product_img;
    }

    public void setProduct_img(String product_img) {
        this.product_img = product_img;
    }
}
