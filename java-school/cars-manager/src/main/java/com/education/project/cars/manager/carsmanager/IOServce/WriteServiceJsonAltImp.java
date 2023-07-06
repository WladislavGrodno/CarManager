package com.education.project.cars.manager.carsmanager.IOServce;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.education.project.cars.manager.carsmanager.service.CarList;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class WriteServiceJsonAltImp
        extends ObjectMapper implements WriteService{

    @Override
    public void fileWriter(CarList cars, String file) {
        try {
            writeValue(new File(file), cars);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
