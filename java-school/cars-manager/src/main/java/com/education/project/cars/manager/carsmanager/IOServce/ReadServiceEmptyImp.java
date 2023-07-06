package com.education.project.cars.manager.carsmanager.IOServce;

import org.springframework.stereotype.Service;
import com.education.project.cars.manager.carsmanager.service.CarList;

@Service
public class ReadServiceEmptyImp implements ReadService{
    @Override
    public CarList fileReader(String fileName) {
        return null;
    }
}
