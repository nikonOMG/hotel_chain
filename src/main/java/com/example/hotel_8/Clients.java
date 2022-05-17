package com.example.hotel_8;

import java.sql.Date;

public class Clients {

    int room;
    String name;
    Date birth;
    Date checkin;
    Date checkout;
    String passport;

    public Clients(String name, Date birth, Date checkin, Date checkout, String passport, String hotel) {
        this.name = name;
        this.birth = birth;
        this.checkin = checkin;
        this.checkout = checkout;
        this.passport = passport;
        this.hotel = hotel;
    }

    String hotel;

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public Clients(int room, String name, Date birth, Date checkin, Date checkout, String passport) {
        this.room = room;
        this.name = name;
        this.birth = birth;
        this.checkin = checkin;
        this.checkout = checkout;
        this.passport = passport;
    }


    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Date getCheckin() {
        return checkin;
    }

    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }
}
