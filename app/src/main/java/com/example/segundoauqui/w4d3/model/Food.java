package com.example.segundoauqui.w4d3.model;

/**
 * Created by segundoauqui on 8/24/17.
 */

public class Food {

    String type, url, description, price;


    public Food(String type, String url, String description, String price) {
        this.type = type;
        this.url = url;
        this.description = description;
        this.price = price;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
