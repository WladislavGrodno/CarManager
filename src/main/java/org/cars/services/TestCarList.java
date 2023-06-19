package org.cars.services;

import org.cars.imp.CarLinkedList;
import org.cars.model.Car;

public class TestCarList extends CarLinkedList {
    public TestCarList(FileService<CarLinkedList> service) {
        super(service);
        add(new Car(1973, "Fiat", "123", 123L));
        add(new Car(1963, "UAZ", "Buhanka", 1230L));
        add(new Car(1953, "UAZ", "Patriot", 1023L));
        add(new Car(1943, "UAZ", "469", 1203L));
        add(new Car(1978, "Bugatti", "BigAuto", 423L));
        add(new Car(1949, "Honda", "Element", 723L));
        add(new Car(1974, "Samand", "Horse", 8123L));
        add(new Car(1966, "BelAZ", "90", 800123L));
        add(new Car(1953, "MZKT", "4444", 1000123L));
        add(new Car(1999, "Ferrari", "777", 6723L));
    }
}
