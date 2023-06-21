package org.cars.util;

import java.sql.*;

public class PostgreSql {
    private final String URL = "jdbc:postgresql://localhost:5432/test";
    private final String NAME = "user";
    private final String PASSWORD = "123456";
    private Connection connection = null;
    private Statement statement = null;
    private int status = 0;


    public PostgreSql() {
        connect();
    }

    public int getStatus() {
        return status;
    }

    public Statement getStatement() {
        return statement;
    }

    private void connect() {
        try {
            Class.forName("org.postgresql.Driver");
            try {
                connection = DriverManager.getConnection(URL, NAME, PASSWORD);
                try {
                    statement = connection.createStatement();
                }
                catch (SQLException e){
                    status = -3;//не смог сотворить statement
                }
            }
            catch (SQLException e){
                status = -2;//нет подключения к базе данных
            }
        }
        catch (ClassNotFoundException e){
            status = -1;//неподключен драйвер
        }
    }

    protected int checkTablePresent(String table) {
        try {
            ResultSet rs = statement.executeQuery(
                    "SELECT * FROM " + table + " LIMIT 0;");
            return 1;
        }
        catch (SQLException e){
            if(e.getSQLState().equals("42P01")) return 0;
            return -1;
        }
    }
}
