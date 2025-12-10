package com.example.conflict_tracker.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Faction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Conflict conflict;

    @ManyToMany
    private List<Country> supportCountry = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Conflict getConflict() {
        return conflict;
    }

    public void setConflict(Conflict conflict) {
        this.conflict = conflict;
    }

    public List<Country> getSupportCountry() {
        return supportCountry;
    }

    public void setSupportCountry(List<Country> supportCountry) {
        this.supportCountry = supportCountry;
    }
}
