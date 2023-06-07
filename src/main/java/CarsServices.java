import java.util.LinkedList;

public class CarsServices extends LinkedList<Car> {

    public Car getMaxPricedCar(){
        return getExtremeCar("price", (o1, o2) -> (o1 < o2));
    }
    public Car getMinPricedCar(){
        return getExtremeCar("price", (o1, o2) -> (o1 > o2));
    }
    private Car getExtremeCar(String field, Comparator c){
        Car ethanolCar = get(0);
        Long ethanol = ethanolCar.getNumber(field);
        for (Car car : this){
            Long param = car.getNumber(field);
            if (c.compare(ethanol, param)){
                ethanol = param;
                ethanolCar = car;
            }
        }
        return ethanolCar;
    }
    public CarsServices sort(String field){
        if (get(0).getNumber(field) != null)
            sort(java.util.Comparator.comparing(car -> car.getNumber(field)));
        else if (get(0).getString(field) != null)
            sort(java.util.Comparator.comparing(car -> car.getString(field)));
        return (CarsServices) this;
    }

    public CarsServices filter(String field, String ethanol){
        CarsServices newList = new CarsServices();
        for (Car car : this) {
            if (car.getString(field).equals(ethanol)) newList.add(car);
        }
        return newList;
    }

    public CarsServices filter(String field, Long min, Long max){
        CarsServices newList = new CarsServices();
        for (Car car : this) {
            Long n = car.getNumber(field);
            if (n >= min && n <= max) newList.add(car);
        }
        return newList;
    }
}

