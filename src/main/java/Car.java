import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private Integer year = -1;
    private String producer = "";
    private String model = "";
    private Long price = 0L;

    /**
     * Возвращает значение поля в виде строки
     * @param field поле
     * @return строковое выражение поля
     */
    public String getString(String field){
        switch (field){
            case "producer" -> {return producer;}
            case "model" -> {return model;}
            case "price" -> {
                return String.format("%17d.%02d",price / 100, price % 100);
            }
            default -> {return null;}
        }
    }

    /**
     * Возвращает значение поля в виде числа
     * @param field поле
     * @return числовое выражение поля
     */
    public Long getNumber(String field){
        switch (field){
            case "year" -> {return year.longValue();}
            case "price" -> {return price;}
            default -> {return null;}
        }
    }

    public String toString(){
        if (year == -1) return "";
        return String.format("%15s: %15s, %5d. %s",
                producer,
                model,
                year,
                getString("price"));
    }

    public void showCar(){
        System.out.println(this);
    }

    /**
     * Экспорт объекта в Json-строку
     * @return Json-строка
     */
    public String toJsonString(){
        try {
            return JsonService.toJsonString(this);
        }
        catch (JsonProcessingException e){
            System.out.println(e.getMessage());
            return "";
        }
    }

    /**
     * Импорт списка из Json-строки
     * @param jsonCar Json-строка
     * @return объект Car
     */
    public static Car loadJson(String jsonCar){
        try {
            return JsonService.jsonStringToCar(jsonCar);
        }
        catch (JsonProcessingException e){
            System.out.println(e.getMessage());
            return new Car();
        }
    }

    /**
     * Загрузка списка из Json-файла
     * @param file Json-файл
     * @return объект Car
     */
    public static Car loadJson(File file){
        try {
            return JsonService.loadJsonCar(file);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
            return new Car();
        }
    }

    /**
     * Сохранение объекта в Json-файл
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

