package com.example.saleapp07062022.data.model;

public class User {
    private String email;
    private String name;
    private String phone;
    private String token;

    public User(String email, String name, String phone, String token) {
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.token = token;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
