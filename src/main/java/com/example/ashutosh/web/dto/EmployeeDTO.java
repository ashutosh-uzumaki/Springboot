package com.example.ashutosh.web.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

public class EmployeeDTO {
    private Long id;
    private String name;
    private int age;
    private LocalDate joiningDate;

    private boolean isActive;

    public EmployeeDTO(){}
    public EmployeeDTO(Long id, String name, int age, LocalDate joiningDate, boolean isActive){
        this.id = id;
        this.name = name;
        this.age = age;
        this.joiningDate = joiningDate;
        this.isActive = isActive;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean getActive() {
        return isActive;
    }
}
