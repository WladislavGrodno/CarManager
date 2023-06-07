import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonService {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Преобразует объект сar в строку Json
     * @param car исходный объект
     * @return строка в Json-формате
     * @throws JsonProcessingException здесь могут быть прерывания
     */
    public static String toJsonString(Car car)
            throws JsonProcessingException {
        return objectMapper.writeValueAsString(car);
    }

    /**
     * Преобразует список CarList сars в строку Json
     * @param cars исходный список
     * @return строка в Json-формате
     * @throws JsonProcessingException здесь могут быть прерывания
     */
    public static String toJsonString(CarList cars)
            throws JsonProcessingException {
        return objectMapper.writeValueAsString(cars);
    }

    /**
     * Преобразует Json-строку в объект Car
     * @param json строка в Json-формате
     * @return объект Car
     * @throws JsonProcessingException здесь могут быть прерывания
     */
    public static Car jsonStringToCar(String json)
            throws JsonProcessingException {
        return objectMapper.readValue(json, Car.class);
    }

    /**
     * Преобразует Json-строку в список CarList
     * @param json строка в Json-формате
     * @return список CarList
     * @throws JsonProcessingException здесь могут быть прерывания
     */
    public static CarList jsonStringToCarList(String json)
            throws JsonProcessingException {
        return objectMapper.readValue(json, CarList.class);
    }


    /**
     * Сохраняет объект Car в Json-файл
     * @param file объект File, например
     *            new File("src/test/resources/employee.json")
     * @param car объект Car
     * @throws IOException здесь могут быть прерывания
     */
    public static void saveJson(File file, Car car)
            throws IOException {
        objectMapper.writeValue(file, car);
    }

    /**
     * Сохраняет список CarList в Json-файл
     * @param file объект File, например
     *            new File("src/test/resources/employee.json")
     * @param cars список CarList
     * @throws IOException здесь могут быть прерывания
     */
    public static void saveJson(File file, CarList cars)
            throws IOException {
        objectMapper.writeValue(file, cars);
    }

    /**
     * Загружает объект Car из Json-файла
     * @param file объект File, например
     *            new File("src/test/resources/employee.json")
     * @return объект Car
     * @throws IOException здесь могут быть прерывания
     */
    public static Car loadJsonCar(File file)
            throws IOException {
        return objectMapper.readValue(file, Car.class);
    }

    /**
     * Загружает список CarList из Json-файла
     * @param file объект File, например
     *       new File("src/test/resources/employee.json")
     * @return список CarList
     * @throws IOException здесь могут быть прерывания
     */
    public static CarList loadJsonCarList(File file)
            throws IOException {
        return objectMapper.readValue(file, CarList.class);
    }
}
