package com.falcontech.gradeit.models;

public class Subject { 
    private int id;
    private String name;
    private int credits;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setId(int id) {
        this.id = id;
    }
}