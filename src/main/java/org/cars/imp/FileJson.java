package org.cars.imp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.cars.model.Car;
import org.cars.services.FileService;

import java.io.File;
import java.io.IOException;

public class FileJson
        extends ObjectMapper
        implements FileService<CarLinkedList> {

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
