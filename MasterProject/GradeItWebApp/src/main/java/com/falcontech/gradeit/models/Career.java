package com.falcontech.gradeit.models;

public class Career { 
    private int id;
    private String name;
    private Pensum pensum;

    public int getId() {
        return id;
    }

    public Pensum getPensum() {
        return pensum;
    }

    public void setPensum(Pensum pensum) {
        this.pensum = pensum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
}