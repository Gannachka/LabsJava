package com.example.Lab25.model;

public class Comment {
    private int id;
    private int linkId;
    private String date;
    private String text;
    private String author;
    private String sessionId;

    public Comment(int id, int linkId, String date, String text, String author, String sessionId) {
        this.date = date;
        this.id = id;
        this.linkId = linkId;
        this.text = text;
        this.author = author;
        this.sessionId = sessionId;
    }

    public Comment() {}

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public int getLinkId() {
        return linkId;
    }

    public String getText() {
        return text;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLinkId(int linkId) {
        this.linkId = linkId;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
