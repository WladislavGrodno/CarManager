package org.cars.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.cars.model.Car;
import org.cars.model.CarList;

import java.io.File;
import java.io.IOException;

public class JsonService extends ObjectMapper{

    /**
     * Преобразует объект сar в строку Json
     * @param car исходный объект
     * @return строка в Json-формате
     * @throws JsonProcessingException здесь могут быть прерывания
     */
    public String toJsonString(Car car)
            throws JsonProcessingException {
        return writeValueAsString(car);
    }

    /**
     * Преобразует список org.example.Model.CarList сars в строку Json
     * @param cars исходный список
     * @return строка в Json-формате
     * @throws JsonProcessingException здесь могут быть прерывания
     */
    public String toJsonString(CarList cars)
            throws JsonProcessingException {
        return writeValueAsString(cars);
    }

    /**
     * Преобразует Json-строку в объект org.example.Model.Car
     * @param json строка в Json-формате
     * @return объект org.example.Model.Car
     * @throws JsonProcessingException здесь могут быть прерывания
     */
    public Car jsonStringToCar(String json)
            throws JsonProcessingException {
        return readValue(json, Car.class);
    }

    /**
     * Преобразует Json-строку в список org.example.Model.CarList
     * @param json строка в Json-формате
     * @return список org.example.Model.CarList
     * @throws JsonProcessingException здесь могут быть прерывания
     */
    public CarList jsonStringToCarList(String json)
            throws JsonProcessingException {
        return readValue(json, CarList.class);
    }


    /**
     * Сохраняет объект org.example.Model.Car в Json-файл
     * @param file объект File, например
     *            new File("src/test/resources/employee.json")
     * @param car объект org.example.Model.Car
     * @throws IOException здесь могут быть прерывания
     */
    public void saveJson(File file, Car car)
            throws IOException {
        writeValue(file, car);
    }

    /**
     * Сохраняет список org.example.Model.CarList в Json-файл
     * @param file объект File, например
     *            new File("src/test/resources/employee.json")
     * @param cars список org.example.Model.CarList
     * @throws IOException здесь могут быть прерывания
     */
    public void saveJson(File file, CarList cars)
            throws IOException {
        writeValue(file, cars);
    }

    /**
     * Загружает объект org.example.Model.Car из Json-файла
     * @param file объект File, например
     *            new File("src/test/resources/employee.json")
     * @return объект org.example.Model.Car
     * @throws IOException здесь могут быть прерывания
     */
    public Car loadJsonCar(File file)
            throws IOException {
        return readValue(file, Car.class);
    }

    /**
     * Загружает список org.example.Model.CarList из Json-файла
     * @param file объект File, например
     *       new File("src/test/resources/employee.json")
     * @return список org.example.Model.CarList
     * @throws IOException здесь могут быть прерывания
     */
    public CarList loadJsonCarList(File file)
            throws IOException {
        return readValue(file, CarList.class);
    }
}
