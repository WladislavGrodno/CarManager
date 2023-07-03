package utils;

import model.Car;
import service.CarList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostgresGet {
    public CarList carList(ResultSet rs){
        //ToDo: согласовать размер КарЛиста с количеством записей в резултсете
        CarList carArrayList = new CarList();
        try {
            while (rs.next()) {
                Car car = new Car();
                car.setYear(rs.getInt("Year"));
                car.setBrand(rs.getString("Brand"));
                car.setModel(rs.getString("Model"));
                car.setCost(rs.getInt("Cost"));
                carArrayList.add(car);
            }
        } catch (SQLException e) {
            System.out.println("Can't ");
            System.out.println(e.getMessage());
        }
        return carArrayList;
    }

    public String sqlQuery(CarList list, String table){
        StringBuilder query = new StringBuilder("INSERT INTO " + table +
                " (Year, Brand, Model, Cost) VALUES ");
        list.forEach(c ->
                query.append(String.format("(%d, '%s', '%s', %d), ",
                        c.getYear(), c.getBrand(), c.getModel(), c.getCost()))
        );
        query.delete(query.length()-2, query.length());
        query.append(";");

        return query.toString();
    }
}
