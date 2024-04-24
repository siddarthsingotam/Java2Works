package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "currency")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "abbreviation")
    private String abbreviation;

    @Column(name = "rate")
    private double rate;

    public Currency() {}

    public Currency(String abbreviation, String name, double rate) {
        super();
        this.abbreviation = abbreviation;
        this.name = name;
        this.rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name != null && !name.isBlank()) {
            this.name = name;
        }
    }

    public String getAbbreviation() {
        return this.abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        if (abbreviation != null && !abbreviation.isBlank()) {
            this.abbreviation = abbreviation;
        }
    }

    public double getRate() {
        return this.rate;
    }

    public void setRate(double rate) {
        if (rate > 0) {
            this.rate = rate;
        }
    }
}
