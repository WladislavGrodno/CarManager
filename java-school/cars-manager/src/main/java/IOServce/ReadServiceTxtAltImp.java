package IOServce;

import model.Car;
import service.CarList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadServiceTxtAltImp implements ReadService{
    @Override
    public CarList fileReader(String file) {
        try(BufferedReader reader =
                    new BufferedReader(new FileReader(file))) {
            if (reader.readLine().equals("CarList object")){
                CarList carList = new CarList();
                String carYear;
                while ((carYear = reader.readLine()) != null){
                    carList.add(new Car(
                            Integer.parseInt(carYear),
                            reader.readLine(),
                            reader.readLine(),
                            Integer.parseInt(reader.readLine())
                    ));
                }
                return carList;
            }
            else {
                System.out.println("Alien file");
            }
        }
        catch (IOException e){
            System.out.println("Can't open file");
            System.out.println(e.getMessage());
        }
        return new CarList();
    }
}
