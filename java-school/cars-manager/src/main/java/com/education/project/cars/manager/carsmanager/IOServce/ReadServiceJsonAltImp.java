package com.education.project.cars.manager.carsmanager.IOServce;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import com.education.project.cars.manager.carsmanager.service.CarList;

import java.io.IOException;

@Service
public class ReadServiceJsonAltImp
        extends ObjectMapper implements ReadService{
    @Override
    public CarList fileReader(String file) {
        try {
            return readValue(file, CarList.class);
        }
        catch (IOException e){
            System.out.print("bad " + file);
            System.out.println(e.getMessage());
            return new CarList();
        }
    }

}
