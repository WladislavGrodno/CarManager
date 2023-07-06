package com.education.project.cars.manager.carsmanager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    private Long id = -1L;
    private Integer year = -1;
    private String brand = "";
    private String model = "";
    private Integer cost = 0;

    public Car(Integer year, String brand, String model, Integer cost) {
        this.year = year;
        this.brand = brand;
        this.model = model;
        this.cost = cost;
    }

    public String toString() {
        if (year == -1) return "";
        return String.format("id = %20d %15s: %15s, %5d. %17d",
                id,
                brand,
                model,
                year,
                cost
        );
    }
}
