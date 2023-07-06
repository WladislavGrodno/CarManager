package com.education.project.cars.manager.carsmanager.IOServce;

import org.springframework.stereotype.Service;
import com.education.project.cars.manager.carsmanager.service.CarList;

@Service
public class WriteServiceEmptyImp implements WriteService{
    @Override
    public void fileWriter(CarList list, String fileName) {}
}
