package com.education.project.cars.manager.carsmanager.IOServce;

import com.education.project.cars.manager.carsmanager.service.CarList;

public interface WriteService {
    void fileWriter(CarList list, String fileName);
}
