package com.example.saleapp07062022.data.model;

import java.util.List;

public class Cart {
    private String id;
    private List<Product> products;
    private String idUser;
    private long price;

    public Cart(String id, List<Product> products, String idUser, long price) {
        this.id = id;
        this.products = products;
        this.idUser = idUser;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id='" + id + '\'' +
                ", products=" + products +
                ", idUser='" + idUser + '\'' +
                ", price=" + price +
                '}';
    }
}
