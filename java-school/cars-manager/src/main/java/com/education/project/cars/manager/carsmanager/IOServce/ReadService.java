package com.education.project.cars.manager.carsmanager.IOServce;

import com.education.project.cars.manager.carsmanager.service.CarList;

public interface ReadService {
    CarList fileReader(String fileName);
}
