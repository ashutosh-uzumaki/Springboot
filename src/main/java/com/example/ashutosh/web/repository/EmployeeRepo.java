package com.example.ashutosh.web.repository;

import com.example.ashutosh.web.dto.EmployeeDTO;
import com.example.ashutosh.web.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    List<Employee> findAll();
}
