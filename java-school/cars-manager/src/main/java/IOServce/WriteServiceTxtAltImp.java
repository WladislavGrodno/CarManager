package IOServce;

import service.CarList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteServiceTxtAltImp implements WriteService{

    @Override
    public void fileWriter(CarList cars, String file) {
        try(BufferedWriter writer =
                    new BufferedWriter(new FileWriter(file, false))) {
            writer.write("CarList object\n");
            cars.forEach(car -> {
                try {
                    writer.write(car.getYear().toString());writer.append('\n');
                    writer.write(car.getBrand()); writer.append('\n');
                    writer.write(car.getModel()); writer.append('\n');
                    writer.write(car.getCost().toString());
                    writer.append('\n');
                } catch (IOException e) {
                    System.out.println("Error of writing");
                    System.out.println(e.getMessage());
                }
            });
        }
        catch (IOException e){
            System.out.println("Can't open file");
            System.out.println(e.getMessage());
        }
    }
}
