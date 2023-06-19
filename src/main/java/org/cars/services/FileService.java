package org.cars.services;

import org.cars.model.Car;
import java.io.File;

public interface FileService<T> {

    /**
     * Сохраняет объект org.example.Model.Car в файл
     * @param file объект File
     * @param car объект org.example.Model.Car
     */
    void save(File file, Car car);

    /**
     * Сохраняет список org.example.Model.CarList в файл
     * @param file объект File
     * @param cars список org.example.Model.CarList
     */
    void save(File file, T cars);

    /**
     * Загружает объект org.example.Model.Car из файла
     * @param file объект File
     * @return объект org.example.Model.Car
     */
    Car load(File file);

    /**
     * Загружает список org.example.Model.CarList из файла
     * @param file объект File
     * @return список org.example.Model.CarList
     */
    T loadCarList(File file);
}
