import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Car {
    private Integer year;
    private String producer;
    private String model;
    private Long price;

    /**
     * Возвращает значение поля в виде строки
     * @param field поле
     * @return строковое выражение поля
     */
    public String getString(String field){
        switch (field){
            case "producer" -> {return producer;}
            case "model" -> {return model;}
            case "price" -> {
                return String.format("%17d.%02d",price / 100, price % 100);
            }
            default -> {return null;}
        }
    }

    /**
     * Возвращает значение поля в виде числа
     * @param field поле
     * @return числовое выражение поля
     */
    public Long getNumber(String field){
        switch (field){
            case "year" -> {return year.longValue();}
            case "price" -> {return price;}
            default -> {return null;}
        }
    }

    public String toString(){
        return String.format("%15s: %15s, %5d. %s",
                producer,
                model,
                year,
                getString("price"));
    }

    public void showCar(){
        System.out.println(this);
    }
}

