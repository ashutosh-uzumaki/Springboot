package com.example.ashutosh.web.services;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

import com.example.ashutosh.web.dto.EmployeeDTO;
import com.example.ashutosh.web.entities.Employee;
import com.example.ashutosh.web.repository.EmployeeRepo;
import com.example.ashutosh.web.configs.MapperConfig;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    private final ModelMapper mapper;
    EmployeeService(EmployeeRepo employeeRepo, ModelMapper mapper){
        this.employeeRepo = employeeRepo;
        this.mapper = mapper;
    }

    public List<EmployeeDTO> getAllEmployees(){
        List<Employee> employees = employeeRepo.findAll();
        List<EmployeeDTO> employeeDTOS = employees.stream().map(employee -> mapper.map(employee, EmployeeDTO.class)).collect(Collectors.toList());
        return employeeDTOS;
    }

    public EmployeeDTO getEmployee(Long id){
        Optional<Employee> employee = employeeRepo.findById(id);
        if(employee.isPresent()){
            return mapper.map(employee.get(), EmployeeDTO.class);
        }
        return null;
    }

    public EmployeeDTO save(Employee employee){
        Employee savedEmployee = employeeRepo.save(employee);
        return mapper.map(savedEmployee, EmployeeDTO.class);
    }

    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO, Long employeeId){
        Employee employee = mapper.map(employeeDTO, Employee.class);
        employee.setId(employeeId);
        EmployeeDTO updatedEmployee = save(employee);
        return updatedEmployee;
    }

    public void deleteEmployeeById(Long employeeId){
        try{
            employeeRepo.deleteById(employeeId);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public EmployeeDTO patchData(Map<String, Object> updates, Long employeeId){
        boolean employeeExists = employeeRepo.existsById(employeeId);
        if(!employeeExists){
            return null;
        }
        Employee employee = employeeRepo.findById(employeeId).get();
        updates.forEach((field, value)-> {
            Field fieldTOBeUpdated = ReflectionUtils.findField(Employee.class, field);
            fieldTOBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldTOBeUpdated, employee, value);
        });
        employeeRepo.save(employee);
        return mapper.map(employee, EmployeeDTO.class);
    }

}
