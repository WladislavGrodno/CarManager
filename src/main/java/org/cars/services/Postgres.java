package org.cars.services;

import java.sql.*;

public class Postgres {
    public void connect() {
        String url = "jdbc:postgresql://localhost:5432/test";
        String name = "user";
        String password = "123456";
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection =
                    DriverManager.getConnection(url, name, password);
            Statement statement = connection.createStatement();

            ResultSet rsNew = statement.executeQuery(
                    "CREATE TABLE users (" +
                            "id smallint," +
                            "firstname varchar(255))");


            ResultSet rs = statement.executeQuery(
                    "SELECT * FROM users WHERE id > 2 AND id < 10");

            while (rs.next()){
                System.out.println("номер в выборке: " + rs.getRow() +
                        " номер в базе: " + rs.getInt("id") +
                        " имя: " + rs.getString("firstname"));
            }

        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        finally {
            try {
                if (connection != null) connection.close();
            }
            catch (SQLException e){
                System.out.println("can't close connection");
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        Postgres postgres = new Postgres();
        postgres.connect();
    }
}
