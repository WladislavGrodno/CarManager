package org.cars.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private Integer year = -1;
    private String maker = "";
    private String model = "";
    private Long price = 0L;

    public String toString(){
        if (year == -1) return "";
        return String.format("%15s: %15s, %5d. %17d.%02d",
                maker,
                model,
                year,
                price,
                price
        );
    }
}

