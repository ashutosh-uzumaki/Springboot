package com.example.ashutosh.web.controllers;

import com.example.ashutosh.web.dto.EmployeeDTO;
import com.example.ashutosh.web.exception.ResourceNotFoundException;
import com.example.ashutosh.web.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Long employeeId) throws ResourceNotFoundException {
        Optional<EmployeeDTO> employeeDTO = employeeService.getEmployee(employeeId);
        return employeeDTO.map(employee->ResponseEntity.ok(employee)).orElseThrow(() -> new ResourceNotFoundException("Employee Not found"));
    }

    @PostMapping()
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody @Valid EmployeeDTO employeeDTO){
        Optional<EmployeeDTO> savedEmployeeDTO = Optional.ofNullable(employeeService.save(employeeDTO));
        return savedEmployeeDTO.map(savedEmployeeDTO1 -> ResponseEntity.ok(savedEmployeeDTO1))
                .orElseThrow(() -> new RuntimeException("could not save the data"));
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
