package com.craneos.demos.jpa;

import com.craneos.demos.jpa.database.entity.Employee;
import com.craneos.demos.jpa.service.IEmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.sql.Timestamp;
import java.util.List;

@SpringBootApplication
public class SpringJpaInsertDemo implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringJpaInsertDemo.class);

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private IEmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaInsertDemo.class, args);
    }

    @Override
    public void run(String... args) {
        LOGGER.debug("applicationContext --> {}", applicationContext.getDisplayName());
        LOGGER.info("applicationContext --> {}", applicationContext.getDisplayName());
        LOGGER.error("applicationContext --> {}", applicationContext.getDisplayName());
        //
        List<Employee> employeeList1 = employeeService.findAll();
        LOGGER.debug("applicationContext size before save --> {}",employeeList1.size());
        //
        employeeService.save(buildEmployee());
        //
        List<Employee> employeeList2 = employeeService.findAll();
        LOGGER.debug("applicationContext size after save --> {}",employeeList2.size());
    }

    private static Employee buildEmployee(){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Employee employee = new Employee();
        employee.setCode("003");
        employee.setEmail("email@email.com");
        employee.setCreated(timestamp);
        return employee;
    }
}
