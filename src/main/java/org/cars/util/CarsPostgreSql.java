package org.cars.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CarsPostgreSql extends PostgreSql{
    private int status = 0;
    private Statement statement;

    public CarsPostgreSql() {
        super();
        if (super.getStatus() > 0) {
            statement = super.getStatement();
            checkCarsTable();
        }
    }

    @Override
    public int getStatus() {
        return status;
    }

    private void checkCarsTable(){
        switch (checkTablePresent("cars")){
            case -1 -> status = -2;
            case 0 -> {
                try {
                    ResultSet rsNew = statement.executeQuery(
                            "CREATE TABLE cars (" +
                                    "year smallint," +
                                    "maker varchar(255)," +
                                    "model varchar(255)," +
                                    "price bigint);");
                    status = 1;
                }
                catch (SQLException e){
                    status = -3;
                }
            }
            default -> status = 1;
        }
    }

    public static void main(String[] args) {
        CarsPostgreSql postgre = new CarsPostgreSql();
        //postgre.connectPostgreSql();

        System.out.println(    postgre.checkTablePresent("users"));
        System.out.println(    postgre.checkTablePresent("users1"));
    }
}
