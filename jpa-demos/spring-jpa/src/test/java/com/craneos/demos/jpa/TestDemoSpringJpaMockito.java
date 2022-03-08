package com.craneos.demos.jpa;

import com.craneos.demos.jpa.database.entity.Employee;
import com.craneos.demos.jpa.database.repository.EmployeeRepository;
import com.craneos.demos.jpa.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class TestDemoSpringJpaMockito {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeServiceImpl;

    @Test
    void testFindAll() {
        List<Employee> employees = generateEmployeeData();
        given(employeeRepository.findAll()).willReturn(employees);

        List<Employee> result = employeeServiceImpl.findAll();

        assertThat(result).isNotEmpty();
        assertThat(result).hasSize(3);
        assertThat(result.get(0).getCode()).isEqualTo("001");
        assertThat(result.get(0).getPid()).isEqualTo("11M");
        assertThat(result.get(0).getName()).isEqualTo("Jules");
        assertThat(result.get(0).getSurname1()).isEqualTo("Pierre");
        assertThat(result.get(0).getSurname2()).isEqualTo("Mao");
        assertThat(result.get(0).getEmail()).isEqualTo("jules@onuprison.com");
        assertThat(result.get(0).getPhone()).isEqualTo("111");
    }

    private List<Employee> generateEmployeeData() {
        List<Employee> employees = new ArrayList<>();
        employees.add(buildEmployee("001", "11M", "Jules", "Pierre", "Mao", "jules@onuprison.com", "111"));
        employees.add(buildEmployee("002", "15M", "Hari", "Seldon", "", "creator@foundation.com", "555"));
        employees.add(buildEmployee("003", "8M", "Holden", "Rocinante", "", "holden@rocinante.com", "777"));
        return employees;
    }

    private Employee buildEmployee(String code, String pid, String name, String surname1, String surname2, String email, String phone){
        Employee employee = new Employee();
        employee.setCode(code);
        employee.setPid(pid);
        employee.setName(name);
        employee.setSurname1(surname1);
        employee.setSurname2(surname2);
        employee.setEmail(email);
        employee.setPhone(phone);
        employee.setCreated(new Timestamp(System.currentTimeMillis()));
        return employee;
    }
}