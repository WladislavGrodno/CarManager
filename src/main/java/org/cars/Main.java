package org.cars;

import org.cars.model.Car;
import org.cars.model.CarList;
import org.cars.services.CarListServices;
import org.cars.services.TestCarList;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        //System.out.println("Test SSH");

        CarList cars = new TestCarList();

        String jsonCar = cars.getMaxPricedCar().toJsonString();
        String jsonCars = cars.toJsonString();
        System.out.println(jsonCar);
        System.out.println(jsonCars);

        //CarList.
        //CarListServices.
        //CarList carsLoaded =
        cars.loadJson(jsonCars).showCars();

        //jsonCars..loadJson(jsonCars).showCars();
        Car.loadJson(jsonCar).showCar();

        System.out.println();

        File jsonFile = new File("src/test/resources/employee.json");

        cars.saveJson(jsonFile);


        CarList carsNew = cars.loadJson(jsonFile);

        if (carsNew != null) carsNew.showCars();


        cars.getMaxPricedCar().showCar();
        cars.getMinPricedCar().showCar();

        System.out.println();

        cars.sort("producer").showCars();

        System.out.println();

        cars.sort("price").showCars();

        cars.filter("producer", "UAZ").showCars();
        cars.filter("producer", "BelAZ").showCars();
        cars.filter("price", 1200L, 10000L).showCars();



    }


}