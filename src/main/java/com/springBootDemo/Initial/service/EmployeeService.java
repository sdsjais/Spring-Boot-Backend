package com.springBootDemo.Initial.service;

import com.springBootDemo.Initial.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    public Employee save (Employee employee);
    public List<Employee> getAllEmployee();
    public Employee getEmployeeById(String id);
    public String deleteEmployeeById(String id);
}
