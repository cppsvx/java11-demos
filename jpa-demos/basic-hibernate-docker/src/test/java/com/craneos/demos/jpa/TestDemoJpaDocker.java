package com.craneos.demos.jpa;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.MariaDBContainer;
import org.testcontainers.ext.ScriptUtils;
import org.testcontainers.jdbc.JdbcDatabaseDelegate;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@Testcontainers
public class TestDemoJpaDocker {

    /** Using the @Container annotation is an easy way to add a Testcontainer but the problem is that your Testcontainers
     * will be started and stopped for each test class. A better way is to use the singleton pattern and use an abstract
     * class to start our Testcontainers. The singleton container is started only once when the base class is loaded and
     * the container can then be reused by all inheriting test classes. At the end of the test suite the Ryuk container,
     * that is started by Testcontainers core, will take care of stopping the singleton container.
     *
     * More info:
     *      https://merikan.com/2020/10/getting-started-with-testcontainers/
     *      https://phauer.com/2017/dont-use-in-memory-databases-tests-h2/
     **/
    @Container
    private static final MariaDBContainer mariaDBContainer;

    static {
        mariaDBContainer = new MariaDBContainer<>(DockerImageName.parse("mariadb:10.5.5"))
                .withDatabaseName("demos")
                .withUsername("test")
                .withPassword("test")
                .withInitScript("schema-demos.sql");
        mariaDBContainer.start();
    }

    @BeforeAll
    public static void init(){
        ScriptUtils.runInitScript(new JdbcDatabaseDelegate(mariaDBContainer, ""), "jpa-insert-demo-test.sql");
    }

    @AfterAll
    public static void destroy(){
        mariaDBContainer.close();
    }

    @Test
    public void testMariadbContainer(){
        String jdbcUrl = mariaDBContainer.getJdbcUrl();
        String username = mariaDBContainer.getUsername();
        String password = mariaDBContainer.getPassword();
        try(Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            ResultSet resultSet = connection.createStatement().executeQuery("SELECT 1");
            resultSet.next();
            int result = resultSet.getInt(1);
            Assertions.assertEquals(1, result);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try(Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            ResultSet resultset = connection.createStatement().executeQuery("select * from employee");
            while (resultset.next()) {
                System.out.println("----------------");
                System.out.println("code: "+resultset.getString(1));
                System.out.println("id: "+resultset.getString(2));
            }
            Assertions.assertNotNull(resultset);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
