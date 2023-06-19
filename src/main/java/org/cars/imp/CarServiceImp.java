package org.cars.imp;

import org.cars.model.Car;
import org.cars.services.CarService;
import org.cars.services.FileService;

import java.io.File;

public class CarServiceImp implements CarService {
    private final FileService<CarLinkedList> fileService;

    public CarServiceImp(FileService<CarLinkedList> service){
        fileService = service;
    };
    /**
     * Возвращает значение поля в виде строки
     * @param field поле
     * @return строковое выражение поля
     */
    @Override
    public String getStringField(Car car, String field){
        switch (field){
            case "maker" -> {return car.getMaker();}
            case "model" -> {return car.getModel();}
            case "price" -> {
                long price = car.getPrice();
                return String.format("%17d.%02d",price / 100, price % 100);
            }
            default -> {return "";}
        }
    }

    /**
     * Возвращает значение поля в виде числа
     * @param field поле
     * @return числовое выражение поля
     */
    @Override
    public Long getNumberField(Car car, String field){
        switch (field){
            case "year" -> {return car.getYear().longValue();}
            case "price" -> {return car.getPrice();}
            default -> {return null;}
        }
    }

    /**
     * Загрузка объекта из Json-файла
     * @param file Json-файл
     * @return объект org.example.Model.Car
     */
    @Override
    public Car load(File file){
        return fileService.load(file);
    }

    /**
     * Сохранение объекта в Json-файл
     * @param file Json-файл
     */
    @Override
    public void save(Car car, File file){
        fileService.save(file, car);
    }

    @Override
    public void show(Car car) {
        System.out.println(car);
    }
}
