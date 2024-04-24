package com.example.entity;

public class Currency {
    private int id;
    private String name;
    private String abbreviation;
    private double rate;

    public Currency() {
    }

    public Currency(int id, String name, String abbreviation, double rate) {
        this.id = id;
        this.name = name;
        this.abbreviation = abbreviation;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public double getRate() {
        return rate;
    }
}
