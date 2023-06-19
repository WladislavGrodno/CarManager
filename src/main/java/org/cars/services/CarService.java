package org.cars.services;

import org.cars.model.Car;
import java.io.File;

public interface CarService {
    String getStringField(Car car, String field);
    Long getNumberField(Car car, String field);
    Car load(File file);
    void save(Car car, File file);
    void show(Car car);
}
