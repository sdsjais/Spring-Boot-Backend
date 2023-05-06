package com.springBootDemo.Initial.controller;

import com.springBootDemo.Initial.model.Employee;
import com.springBootDemo.Initial.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/employee")
public class EmployeeControllerV2 {
    @Autowired
    @Qualifier("employeeServiceV2Impl")
    private EmployeeService employeeService;

    @PostMapping
    public Employee save (@RequestBody Employee employee){
        return employeeService.save(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployee (){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public  Employee getEmployeeById(@PathVariable("id") String id){
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable("id") String id){
        return employeeService.deleteEmployeeById(id);
    }
}
