public class CarList extends  CarsServices{
    public void showCars(){
        forEach(Car::showCar);
        System.out.println();
    }
}
