package com.example.chernovinternetshop;

public class Book {
    private int ident;
    private int cost;
    private String name;

    public Book(int ident, int cost, String name) {
        this.ident = ident;
        this.cost = cost;
        this.name = name;
    }

    public int getIdent() {
        return ident;
    }

    public int getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }
}
