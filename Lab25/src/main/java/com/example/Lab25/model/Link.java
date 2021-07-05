package com.example.Lab25.model;

public class Link {
    private int id;
    private String url;
    private String description;
    private int minus;
    private int plus;

    public Link(int id, String url, String description, int plus, int minus) {
        this.id = id;
        this.url = url;
        this.description = description;
        this.minus = minus;
        this.plus = plus;
    }

    public Link(String url, String description, int plus, int minus) {
        this.url = url;
        this.description = description;
        this.minus = minus;
        this.plus = plus;
    }

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public int getMinus() {
        return minus;
    }

    public int getPlus() {
        return plus;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMinus(int minus) {
        this.minus = minus;
    }

    public void setPlus(int plus) {
        this.plus = plus;
    }
}
