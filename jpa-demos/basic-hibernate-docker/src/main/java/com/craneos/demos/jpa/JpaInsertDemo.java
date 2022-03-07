package com.craneos.demos.jpa;

import com.craneos.demos.jpa.database.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Timestamp;

public class JpaInsertDemo {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence-demos");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // INSERT
        entityManager.getTransaction().begin();
        //
        Employee employee = buildEmployee();
        //
        entityManager.persist(employee);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
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
