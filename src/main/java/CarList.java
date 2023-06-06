import java.util.LinkedList;

public class CarList extends CarsServices{
}

class CarsShow extends  LinkedList<Car>{
    public void showCars(){
        forEach(Car::showCar);
        System.out.println();
    }
}
