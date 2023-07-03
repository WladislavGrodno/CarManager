package com.education.project.cars.manager.carsmanager;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

//@Service
public class C1 {

//    @PostConstruct
    public void c1(){
        System.out.println("hello, leather");
        Main main = new Main();
        main.run();
    }
}
