package com.craneos.demos.jpa.service;

import com.craneos.demos.jpa.database.entity.Employee;

import java.util.List;

public interface IEmployeeService {

    List<Employee> findAll();

    void save(Employee employee);

}
