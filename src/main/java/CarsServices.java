public class CarsServices extends CarsShow{

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
    public CarList sort(String field){
        if (get(0).getNumber(field) != null)
            sort(java.util.Comparator.comparing(car -> car.getNumber(field)));
            /*
            sort((car1, car2) ->
                    Long.signum(car1.getNumber(field) - car2.getNumber(field))
            );
             */
        else if (get(0).getString(field) != null)
            sort(java.util.Comparator.comparing(car -> car.getString(field)));
        return (CarList) this;
    }

    public CarList filter(String field, String ethanol){
        CarList newList = new CarList();
        for (Car car : this) {
            if (car.getString(field).equals(ethanol)) newList.add(car);
        }
        return newList;
    }

    public CarList filter(String field, Long min, Long max){
        CarList newList = new CarList();
        for (Car car : this) {
            Long n = car.getNumber(field);
            if (n >= min && n <= max) newList.add(car);
        }
        return newList;
    }
}

