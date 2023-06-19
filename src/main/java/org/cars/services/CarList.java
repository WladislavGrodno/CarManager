package org.cars.services;

import org.cars.model.Car;

import java.io.File;

public interface CarList<T> {
    Car getMaxPricedCar();
    Car getMinPricedCar();

    T sort(String field);
    T filter(String field, String ethanol);
    T filter(String field, Long min, Long max);
    T load(File file);
    void save(File file);
    void showCars();
}
