package com.example.ashutosh.web.controllers;

import com.example.ashutosh.web.dto.EmployeeDTO;
import com.example.ashutosh.web.entities.Employee;
import com.example.ashutosh.web.repository.EmployeeRepo;
import com.example.ashutosh.web.services.EmployeeService;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;
    EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
    @GetMapping()
    public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false) Integer age){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployee(@PathVariable Long employeeId){
        return employeeService.getEmployee(employeeId);
    }

    @PostMapping()
    public EmployeeDTO addEmployee(@RequestBody Employee employee){
//        return "Created Employee: "+employeeDTO.getName();
        return employeeService.save(employee);
    }

    @PutMapping("/{employeeId}")
    public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long employeeId){
        return employeeService.updateEmployee(employeeDTO, employeeId);
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployeeById(@PathVariable Long employeeId){
        employeeService.deleteEmployeeById(employeeId);
    }

    @PatchMapping("/{employeeId}")
    public EmployeeDTO patchData(@RequestBody Map<String, Object> updates, @PathVariable Long employeeId){
        return employeeService.patchData(updates, employeeId);
    }
}
