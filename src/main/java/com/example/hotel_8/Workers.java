package com.example.hotel_8;

public class Workers {
    String name;
    String passport;
    int salary;
    String post;
    String email;

    public Workers(String name, String passport, int salary, String post, String email) {
        this.name = name;
        this.passport = passport;
        this.salary = salary;
        this.post = post;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
