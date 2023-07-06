package com.education.project.cars.manager.carsmanager.utils;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class Get {
    public Scanner sc = new Scanner(System.in);

    public int intNumber(){
        while (!sc.hasNextInt()){
            System.out.println("Не надо букв... Цифра надо...");
            sc.next();
        }
        return sc.nextInt();
    }

    public String string(){
        String line;
        do {
            if (sc.hasNextLine()){
                line = sc.nextLine();
                if (line.length() > 0)
                    return line;
            }
        } while (true);
    }
}
