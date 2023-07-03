package IOServce;

import service.CarList;

public class WriteServiceScreenImp implements WriteService{
    @Override
    public void fileWriter(CarList list, String fileName) {
        System.out.printf(
                "%15s: %15s, %5s. %20s%n","Марка", "Модель", "Год", "Цена");
        list.forEach(System.out::println);
    }
}
