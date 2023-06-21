package org.cars;

import org.cars.imp.CarLinkedList;
import org.cars.imp.FileJson;
import org.cars.imp.CarServiceImp;
import org.cars.imp.FileTxt;
import org.cars.services.FileService;
import org.cars.services.TestCarList;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        FileService<CarLinkedList> fileService = new FileJson();
        CarLinkedList carsJson = new TestCarList(fileService);
        CarServiceImp carServiceImp = new CarServiceImp(fileService);
//        CarLinkedList carsJson = new TestCarList(new FileTxt());
//        CarServiceImp carServiceImp = new CarServiceImp(new FileTxt());


        File jsonFile = new File("src/test/resources/employee.txt");

        carsJson.save(jsonFile);


        CarLinkedList carsNew = carsJson.load(jsonFile);

        if (carsNew != null) carsNew.showCars();


        System.out.println(carsJson.getMaxPricedCar());
        System.out.println(carsJson.getMinPricedCar());

        System.out.println();

        carsJson.sort("maker").showCars();

        System.out.println();

        carsJson.sort("price").showCars();

        carsJson.filter("maker", "UAZ").showCars();
        carsJson.filter("maker", "BelAZ").showCars();
        carsJson.filter("price", 1200L, 10000L).showCars();



    }


}