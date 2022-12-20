package com.java.entity;

public class Items {
    private int id;
    private String name;
    private String city;
    private int price;
    private int number;
    private String picture;

    public Items() {
    }

    public Items(int id, String name, String city, int price, int number, String picture) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.price = price;
        this.number = number;
        this.picture = picture;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "商品编号：" + getId() + ",商品名称：" + getName();
    }

    @Override
    public int hashCode() {
        return getId() + getName().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Items) {
            Items i = (Items) obj;
            if (getId() == i.getId() && getName().equals(i.getName())) return true;
            else return false;
        } else return false;
    }
}
