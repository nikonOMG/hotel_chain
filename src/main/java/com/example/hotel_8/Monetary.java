package com.example.hotel_8;

import java.sql.Date;

public class Monetary {
    Date date;
    String des;
    int price;

    public Monetary(Date date, String des, int price) {
        this.date = date;
        this.des = des;
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


}
