public class CarList extends  CarListServices{

    /**
     * Отображает этот список автомобилей
     */
    public void showCars(){
        forEach(Car::showCar);
        System.out.println();
    }
}
