//import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        CarList cars = new CarList();
        cars.add(new Car(1973, "Fiat", "123", 123L));
        cars.add(new Car(1963, "UAZ", "Buhanka", 1230L));
        cars.add(new Car(1953, "UAZ", "Patriot", 1023L));
        cars.add(new Car(1943, "UAZ", "469", 1203L));
        cars.add(new Car(1978, "Bugatti", "BigAuto", 423L));
        cars.add(new Car(1949, "Honda", "Element", 723L));
        cars.add(new Car(1974, "Samand", "Horse", 8123L));
        cars.add(new Car(1966, "BelAZ", "90", 800123L));
        cars.add(new Car(1953, "MZKT", "4444", 1000123L));
        cars.add(new Car(1999, "Ferrari", "777", 6723L));

        String jsonCar = Json.carToJsonString(cars.getMaxPricedCar());
        String jsonCars = Json.carsToJsonString(cars);
        System.out.println(jsonCar);
        System.out.println(jsonCars);

        Json.jsonStringToCar(jsonCar).showCar();
        System.out.println();

        Json.jsonStringToCarList(jsonCars).showCars();

        File jsonFile = new File("src/test/resources/employee.json");

        Json.saveJsonCarList(jsonFile, cars);

        CarList carsNew = Json.loadJsonCarList(jsonFile);
        carsNew.showCars();
/*
        cars.getMaxPricedCar().showCar();
        cars.getMinPricedCar().showCar();

        System.out.println();

        cars.sort("producer").showCars();

        System.out.println();

        cars.sort("price").showCars();

        cars.filter("producer", "UAZ").showCars();
        cars.filter("producer", "BelAZ").showCars();
        cars.filter("price", 1200L, 10000L).showCars();

 */

    }


}