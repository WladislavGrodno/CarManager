package org.cars.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.cars.model.Car;
import org.cars.model.CarList;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Список объектов с инструментами поиска экстремального объекта, фильтрации,
 * сортировки
 */
public class CarListServices extends LinkedList<Car> {
    private final JsonService json = new JsonService();

    /**
     * Поиск в списке автомобиля с максимальной ценой
     * @return  автомобиль с максимальной ценой
     */
    public Car getMaxPricedCar(){
        return getExtremeCar("price", (o1, o2) -> (o1 < o2));
    }

    /**
     * Поиск в списке автомобиля с минимальной ценой
     * @return  автомобиль с минимальной ценой
     */
    public Car getMinPricedCar(){
        return getExtremeCar("price", (o1, o2) -> (o1 > o2));
    }

    /**
     * Поиск экстремального объекта в списке
     * @param field поле поиска
     * @param c принцип отбора, где o1 - эталон, o2 - альтернативное
     *         значение
     * @return экстремальный объект
     */
    private Car getExtremeCar(String field, Comparator c){
        Car ethanolCar = get(0);
        // начальный объект
        Long ethanol = ethanolCar.getNumber(field);
        // эталонное численное значение сравниваемого поля
        for (Car car : this){
            Long param = car.getNumber(field);
            // численное значение поля альтернативного объекта
            if (c.compare(ethanol, param)){
                ethanol = param;
                ethanolCar = car;
            }
        }
        return ethanolCar;
    }

    /**
     * Сортировка списка по заданному полю
     * @param field поле сортировки
     * @return отсортированный список
     */
    public CarList sort(String field){
        if (get(0).getNumber(field) != null)
            // сортировать по численному значению поля
            sort(java.util.Comparator.comparing(car -> car.getNumber(field)));
        else if (get(0).getString(field) != null)
            // сортировать по строковому значению поля
            sort(java.util.Comparator.comparing(car -> car.getString(field)));
        return (CarList) this;
    }

    /**
     * Фильтрация списка по строковому значению поля
     * @param field поле
     * @param ethanol эталонная строка
     * @return отфильтрованный список
     */
    public CarList filter(String field, String ethanol){
        CarList newList = new CarList();
        for (Car car : this) {
            if (car.getString(field).equals(ethanol)) newList.add(car);
        }
        return newList;
    }

    /**
     * Фильтрация списка по числовому значению поля
     * @param field поле
     * @param min минимально допустимое значение
     * @param max максимально допустимое значение
     * @return отфильтрованный список
     */
    public CarList filter(String field, Long min, Long max){
        CarList newList = new CarList();
        for (Car car : this) {
            Long n = car.getNumber(field);
            if (n >= min && n <= max) newList.add(car);
        }
        return newList;
    }

    /**
     * Отображает этот список автомобилей
     */
    public void showCars(){
        forEach(Car::showCar);
        System.out.println();
    }

    /**
     * Экспорт списка в Json-строку
     * @return Json-строка
     */
    public String toJsonString(){
        try {
            return json.toJsonString((CarList) this);
        }
        catch (JsonProcessingException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Импорт списка из Json-строки
     * @param jsonCars Json-строка
     * @return список org.example.Model.CarList
     */
    public CarList loadJson(String jsonCars){
        try {
            return json.jsonStringToCarList(jsonCars);
        }
        catch (JsonProcessingException e){
            System.out.println(e.getMessage());
            return new CarList();
        }
    }

    /**
     * Загрузка списка из Json-файла
     * @param file Json-файл
     * @return список org.example.Model.CarList
     */
    public CarList loadJson(File file){
        try {
            return json.loadJsonCarList(file);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
            return new CarList();
        }
    }

    /**
     * Сохранение списка в Json-файл
     * @param file Json-файл
     */
    public void saveJson(File file){
        try {
            json.saveJson(file, (CarList) this);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}

