package com.cbt.tests.day12_could_be_last_day;

import org.junit.jupiter.api.Test;

import java.sql.*;

public class JDBCExampleReview {

    String url = "jdbc:oracle:thin:@34.203.75.130:1521:xe";
    String username = "hr";
    String password = "hr";

    @Test
    public void readSomeData() throws SQLException {
        // create connection
        Connection connection = DriverManager.getConnection(url, username, password);
        String sqlQuery = "SELECT * FROM regions";

        Statement statement = connection.createStatement();
        // execute a query
        // save the result
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        // go through the result
        while (resultSet.next()) {
            String name = resultSet.getString("region_name");
            System.out.println(name);
        }

        // execute another query
        sqlQuery = "SELECT * FROM countries";
        resultSet = statement.executeQuery(sqlQuery);

        // go through the results and print country names
        while (resultSet.next()) {
            String name = resultSet.getString(2);
            System.out.println(name);
        }

    }
}
