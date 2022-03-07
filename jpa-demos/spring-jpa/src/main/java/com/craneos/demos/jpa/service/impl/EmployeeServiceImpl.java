package com.craneos.demos.jpa.service.impl;

import com.craneos.demos.jpa.database.entity.Employee;
import com.craneos.demos.jpa.database.repository.EmployeeRepository;
import com.craneos.demos.jpa.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }
}
