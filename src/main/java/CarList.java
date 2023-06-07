import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.File;
import java.io.IOException;

public class CarList extends  CarListServices{

    /**
     * Отображает этот список автомобилей
     */
    public void showCars(){
//        if (this.isEmpty()) return;
//        else {
            forEach(Car::showCar);
            System.out.println();
//        }
    }

    /**
     * Экспорт списка в Json-строку
     * @return Json-строка
     */
    public String toJsonString(){
        try {
            return JsonService.toJsonString(this);
        }
        catch (JsonProcessingException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Импорт списка из Json-строки
     * @param jsonCars Json-строка
     * @return список CarList
     */
    public static CarList loadJson(String jsonCars){
        try {
            return JsonService.jsonStringToCarList(jsonCars);
        }
        catch (JsonProcessingException e){
            System.out.println(e.getMessage());
            return new CarList();
        }
    }

    /**
     * Загрузка списка из Json-файла
     * @param file Json-файл
     * @return список CarList
     */
    public static CarList loadJson(File file){
        try {
            return JsonService.loadJsonCarList(file);
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
            JsonService.saveJson(file, this);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
