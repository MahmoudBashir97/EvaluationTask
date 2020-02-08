package com.mahmoud.bashir.evaluationtask.pojo;

import java.io.Serializable;
import java.util.List;

public class categories implements Serializable {

    String id ;
    String name;
    String category_img;
    List<products> products;

    public categories(String id, String name, String category_img, List<com.mahmoud.bashir.evaluationtask.pojo.products> products) {
        this.id = id;
        this.name = name;
        this.category_img = category_img;
        this.products = products;
    }

    public categories() {
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

    public String getCategory_img() {
        return category_img;
    }

    public void setCategory_img(String category_img) {
        this.category_img = category_img;
    }

    public List<com.mahmoud.bashir.evaluationtask.pojo.products> getProducts() {
        return products;
    }

    public void setProducts(List<com.mahmoud.bashir.evaluationtask.pojo.products> products) {
        this.products = products;
    }
}
