package com.zhang.testing.bean;

import org.springframework.context.annotation.Configuration;

import java.sql.*;

@Configuration
public class MysqlBean {

    private Connection connection = null;
    private ResultSet resultSet;
    private String driverName = "com.mysql.jdbc.Driver";
    private String serverName = "localhost";
    private String userName = "root";
    private String password = "123456";

    public MysqlBean(){
        try {
            String mydatabase = "mysql";
            String url = "jdbc:mysql://" + serverName + "/" +
                    mydatabase;
            Class.forName(driverName);
            connection = DriverManager.getConnection("jdbc:mysql://" + serverName +
                    ":3306/" + mydatabase + "?user=" +
                    userName + "&useSSL=false&password=" +
                    password + "&useUnicode=true&characterEncoding=UTF-8");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }


    public ResultSet getResultSet(String sql) throws Exception {
        try {
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return resultSet;
    }


    public int executeUpdate(String sql) {
        int count = 0;
        try {
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            count = statement.executeUpdate(sql);

            if (count != 0) {
                ;
            } else {
                ;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return count;
    }


    public void Close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
