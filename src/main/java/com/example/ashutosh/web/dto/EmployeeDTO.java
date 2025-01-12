package com.example.ashutosh.web.dto;


import java.time.LocalDate;

import jakarta.validation.constraints.*;

public class EmployeeDTO {
    private Long id;
    @NotBlank(message = "name should not be null")
    @Size(min=3, message = "name length should be atleast 3 chars long")
    private String name;
    @Max(value = 100, message = "Age should not be greater than 100")
    private int age;
    private LocalDate joiningDate;
    @AssertTrue(message = "employee should be active")
    private boolean isActive;
    @Email(message = "not a valid email")
    private String email;

    public EmployeeDTO(){}
    public EmployeeDTO(Long id, String name, int age, LocalDate joiningDate, boolean isActive, String email){
        this.id = id;
        this.name = name;
        this.age = age;
        this.joiningDate = joiningDate;
        this.isActive = isActive;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
