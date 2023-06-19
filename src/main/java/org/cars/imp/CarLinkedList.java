package org.cars.imp;

import org.cars.model.Car;
import org.cars.services.CarList;
import org.cars.services.CarService;
import org.cars.services.Comparator;
import org.cars.services.FileService;

import java.io.File;
import java.util.LinkedList;

public class CarLinkedList
        extends LinkedList<Car>
        implements CarList<CarLinkedList> {

    private final FileService<CarLinkedList> fileService;
    private final  CarService carServiceImp;

    public CarLinkedList(FileService<CarLinkedList> service) {
        fileService = service;
        carServiceImp = new CarServiceImp(service);
    }

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
        Long ethanol = carServiceImp.getNumberField(ethanolCar, field);
        // эталонное численное значение сравниваемого поля
        for (Car car : this){
            Long param = carServiceImp.getNumberField(car, field);
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
    public CarLinkedList sort(String field){
        if (carServiceImp.getNumberField(get(0), field) != null)
            // сортировать по численному значению поля
            sort(java.util.Comparator.comparing(
                    car -> carServiceImp.getNumberField(car, field)));
        else if (carServiceImp.getStringField(get(0), field) != null)
            // сортировать по строковому значению поля
            sort(java.util.Comparator.comparing(
                    car -> carServiceImp.getStringField(car, field)));
        return this;
    }

    /**
     * Фильтрация списка по строковому значению поля
     * @param field поле
     * @param ethanol эталонная строка
     * @return отфильтрованный список
     */
    public CarLinkedList filter(String field, String ethanol){
        CarLinkedList newList = new CarLinkedList(fileService);
        for (Car car : this) {
            if (carServiceImp.getStringField(car, field).equals(ethanol))
                newList.add(car);
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
    public CarLinkedList filter(String field, Long min, Long max){
        CarLinkedList newList = new CarLinkedList(fileService);
        for (Car car : this) {
            Long n = carServiceImp.getNumberField(car, field);
            if (n >= min && n <= max) newList.add(car);
        }
        return newList;
    }

    /**
     * Отображает этот список автомобилей
     */
    public void showCars(){
        this.forEach(car-> System.out.println(car.toString()));
        System.out.println();
    }

    /**
     * Загрузка списка из Json-файла
     * @param file Json-файл
     * @return список org.example.Model.CarList
     */
    public CarLinkedList load(File file){
        return fileService.loadCarList(file);
    }

    /**
     * Сохранение списка в Json-файл
     * @param file Json-файл
     */
    public void save(File file){
        fileService.save(file, this);
    }
}
