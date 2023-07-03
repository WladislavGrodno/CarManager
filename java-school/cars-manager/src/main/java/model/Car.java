package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    private Integer year = -1;
    private String brand = "";
    private String model = "";
    private Integer cost = 0;

    public String toString() {
        if (year == -1) return "";
        return String.format("%15s: %15s, %5d. %17d",
                brand,
                model,
                year,
                cost
        );
    }
}
