package com.craneos.demos.jpa;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * H2 documentation
 * http://www.h2database.com/html/features.html#database_url
 */
public class TestDemoJpa {

    private static Connection dbConnection;

    @BeforeAll
    public static void setup() throws SQLException {
        String jdbcUrl = "jdbc:h2:mem:demos;MODE=Mysql;INIT=RUNSCRIPT FROM 'classpath:schema-h2.sql'";
        dbConnection = DriverManager.getConnection(jdbcUrl);
    }

    @AfterAll
    public static void finish() throws Exception {
        dbConnection.close();
    }

    @Test
    public void testLoadDatabase() throws SQLException {
        Statement stmt = TestDemoJpa.dbConnection.createStatement();
        ResultSet resultset = stmt.executeQuery("select * from employee");
        while (resultset.next()) {
            System.out.println("----------------");
            System.out.println("code: "+resultset.getString(1));
            System.out.println("name: "+resultset.getString(2));
        }
        assertNotNull(resultset);
    }
}
