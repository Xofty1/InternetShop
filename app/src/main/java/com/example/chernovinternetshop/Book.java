package com.example.chernovinternetshop;

import java.io.Serializable;

public class Book implements Serializable {
    private int ident;
    private int cost;
    private String name;
    private boolean isCheck;
    private int  image;

    public Book(int ident, int cost, String name, boolean isCheck, int image) {
        this.ident = ident;
        this.cost = cost;
        this.name = name;
        this.isCheck = isCheck;

    }

    public int getImage() {
        return image;
    }

    public int getIdent() {
        return ident;
    }

    public boolean getCheck() {
        return isCheck;
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public void setIdent(int ident) {
        this.ident = ident;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }
}
