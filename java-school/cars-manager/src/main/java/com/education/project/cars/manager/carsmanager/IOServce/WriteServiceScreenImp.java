package com.education.project.cars.manager.carsmanager.IOServce;

import com.education.project.cars.manager.carsmanager.service.CarList;
import org.springframework.stereotype.Service;

@Service
public class WriteServiceScreenImp implements WriteService{
    @Override
    public void fileWriter(CarList list, String fileName) {
        System.out.printf(
                "%15s: %15s, %5s. %20s%n","Марка", "Модель", "Год", "Цена");
        list.forEach(System.out::println);
    }
}
