package com.example.ashutosh.web.controllers;

import com.example.ashutosh.web.dto.EmployeeDTO;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping
    public String getAllEmployees(@RequestParam(required = false) Integer age){
        return "Hi employee with age: "+age;
    }

    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployee(@PathVariable Long employeeId){
        return new EmployeeDTO(1l, "Ashutosh", 26, LocalDate.now(), true);
    }

    @PostMapping()
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employeeDTO){
//        return "Created Employee: "+employeeDTO.getName();
        employeeDTO.setJoiningDate(LocalDate.now());
        return employeeDTO;
    }
}
