package com.example.hotel_8;

import java.sql.Date;

public class Cleaner {
    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Cleaner(Date start, Date end, String description, int WorkerID) {
        this.start = start;
        this.end = end;
        this.description = description;
        this.WorkerID = WorkerID;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWorkerID() {
        return WorkerID;
    }

    public void setWorkerID(int WorkerID) {
        this.WorkerID = WorkerID;
    }

    public Cleaner(Date start, Date end, String description) {
        this.start = start;
        this.end = end;
        this.description = description;
    }

    Date start;
    Date end;
    String description;
    int WorkerID;

    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cleaner(Date start, Date end, String description, int id, String name) {
        this.start = start;
        this.end = end;
        this.description = description;
        this.id = id;
        this.name = name;
    }

    public Cleaner(Date start, Date end, String description, String name) {
        this.start = start;
        this.end = end;
        this.description = description;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;
}
