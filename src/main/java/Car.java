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

    public String getString(String field){
        if (field.equals("producer")) return producer;
        if (field.equals("model")) return model;
        if (field.equals("price"))
            return String.format("%17d.%02d",price / 100, price % 100);
        return null;
    }

    public Long getNumber(String field){
        if (field.equals("year")) return year.longValue();
        if (field.equals("price")) return price;
        return null;
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

