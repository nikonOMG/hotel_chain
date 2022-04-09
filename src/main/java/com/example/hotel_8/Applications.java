package com.example.hotel_8;

public class Applications {
    int id;
    String email;
    String title;
    String date;


    public Applications(int id, String email, String title, String date) {
        this.id = id;
        this.email = email;
        this.title = title;
        this.date = date;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }




}
