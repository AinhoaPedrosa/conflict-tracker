package com.example.conflict_tracker.web;

import com.example.conflict_tracker.domain.ConflictStatus;

import java.time.LocalDate;
import java.util.Set;

public class ConflictDto {
    private int id;
    private String name;
    private LocalDate startConflict;
    private ConflictStatus status;
    private String description;
    private Set<Integer> countrysId;

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

    public LocalDate getStartConflict() {
        return startConflict;
    }

    public void setStartConflict(LocalDate startConflict) {
        this.startConflict = startConflict;
    }

    public ConflictStatus getStatus() {
        return status;
    }

    public void setStatus(ConflictStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Integer> getCountrysId() {
        return countrysId;
    }

    public void setCountrysId(Set<Integer> countrysId) {
        this.countrysId = countrysId;
    }
}
