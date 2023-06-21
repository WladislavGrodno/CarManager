package org.cars.imp;

import org.cars.model.Car;
import org.cars.services.FileService;
import org.cars.util.CarsPostgreSql;

import java.io.File;
import java.io.IOException;


public class FilePostgre
        implements FileService<CarLinkedList> {

    private final CarsPostgreSql postgre = new CarsPostgreSql();
    private int status = 0;

    public FilePostgre() {
        if (postgre.getStatus() == 0) {
            status = -1;//
            return;
        }

    }


    @Override
    public void save(File file, Car car) {
        try {
            writeValue(file, car);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void save(File file, CarLinkedList cars) {
        try {
            writeValue(file, cars);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Car load(File file) {
        try {
            return readValue(file, Car.class);
        }
        catch (IOException e){
            System.out.print("bad " + file);
            System.out.println(e.getMessage());
            return new Car();
        }
    }

    @Override
    public CarLinkedList loadCarList(File file) {
        try {
            return readValue(file, CarLinkedList.class);
        }
        catch (IOException e){
            System.out.print("bad " + file);
            System.out.println(e.getMessage());
            return new CarLinkedList(this);
        }
    }
}



