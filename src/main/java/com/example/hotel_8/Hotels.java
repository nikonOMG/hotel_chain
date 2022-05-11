package com.example.hotel_8;

public class Hotels {
    String name;

    public Hotels(String name, int clients) {
        this.name = name;
        this.clients = clients;
    }

    int clients;
    int workers;

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public Hotels(String name, int clients, int workers, int stars, int rooms, String address, long finances) {
        this.name = name;
        this.clients = clients;
        this.workers = workers;
        this.stars = stars;
        this.rooms = rooms;
        Address = address;
        this.finances = finances;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Hotels(String name, int clients, int workers, int id, int stars, long finances, String address, int rooms) {
        this.name = name;
        this.clients = clients;
        this.workers = workers;
        this.id = id;
        this.stars = stars;
        this.rooms = rooms;
        Address = address;
        this.finances = finances;
    }

    int id;

    int stars;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClients() {
        return clients;
    }

    public void setClients(int clients) {
        this.clients = clients;
    }

    public int getWorkers() {
        return workers;
    }

    public void setWorkers(int workers) {
        this.workers = workers;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public long getFinances() {
        return finances;
    }

    public void setFinances(long finances) {
        this.finances = finances;
    }

    int rooms;
    String Address;
    long finances;

    public Hotels(String name, int clients, int workers, int rooms, String address, long finances) {
        this.name = name;
        this.clients = clients;
        this.workers = workers;
        this.rooms = rooms;
        Address = address;
        this.finances = finances;
    }

}
