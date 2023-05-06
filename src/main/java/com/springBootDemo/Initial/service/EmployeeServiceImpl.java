package com.springBootDemo.Initial.service;

import com.springBootDemo.Initial.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    List<Employee> employeeList = new ArrayList<Employee>();
    @Override
    public Employee save(Employee employee) {
        if(employee.getEmployeeId() == null || employee.getEmployeeId().isEmpty()){
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        employeeList.add(employee);
        return employee;
    }

    @Override
    public List<Employee> getAllEmployee(){
        return employeeList;
    }

    @Override
    public Employee getEmployeeById(String id){
//        for(Employee emp : employeeList){
//            if(emp.employeeId.compareTo( id)==0)return emp;
//        }
//        return null;
//        -------------Employee not found Exception (Custom Error) && below code is stream implemented----------
//        return employeeList
//                .stream()
//                .filter(employee -> employee.getEmployeeId().equals(id))
//                .findFirst()
//                .orElseThrow(()->new EmployeeNotFoundException("Employee Not Found "+id));
//        ---------- generic exception
        return employeeList
                .stream()
                .filter(employee -> employee.getEmployeeId().equals(id))
                .findFirst()
                .orElseThrow(()->new RuntimeException("Employee Not Found "+ id));
    }

    @Override
    public String deleteEmployeeById(String id){
        Employee employee = employeeList
                .stream()
                .filter(e -> e.getEmployeeId().equals(id) )
                .findFirst()
                .get();
        employeeList.remove(employee);
        return "Employee deleted from List of Id "+ id;
    }
}
