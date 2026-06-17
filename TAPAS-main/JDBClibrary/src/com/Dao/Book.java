package com.Dao;

public class Book {
    private int id;
    private String sl_no;
    private String author;
    private double price;

    public Book(int id, String sl_no, String author, double price) {
        this.id = id;
        this.sl_no = sl_no;
        this.author = author;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSLNO() {
        return sl_no;
    }

    public void setSLNO(String sl_no) {
        this.sl_no = sl_no;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
