package com.education.project.cars.manager.carsmanager.utils;

import com.education.project.cars.manager.carsmanager.model.Car;
import com.education.project.cars.manager.carsmanager.service.CarList;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
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

    public String insertCarListQuery(CarList list, String table){
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

    public String insertCarQuery(Car car, String table){
        return String.format("INSERT INTO %s " +
                "(Year, Brand, Model, Cost) VALUES (%d, '%s', '%s', %d);",
                table,
                car.getYear(), car.getBrand(), car.getModel(), car.getCost());
    }
}
