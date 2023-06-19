package org.cars.imp;

import org.cars.model.Car;
import org.cars.services.FileService;

import java.io.*;

public class FileTxt implements FileService<CarLinkedList> {

    //private void
    @Override
    public void save(File file, Car car) {
        try(BufferedWriter writer =
                    new BufferedWriter(new FileWriter(file, false))) {
            writer.write("Car object\n");
            writer.write(car.getYear().toString()); writer.append('\n');
            writer.write(car.getMaker()); writer.append('\n');
            writer.write(car.getModel()); writer.append('\n');
            writer.write(car.getPrice().toString()); writer.append('\n');
        }
        catch (IOException e){
            System.out.println("Can't open file");
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void save(File file, CarLinkedList cars) {
        try(BufferedWriter writer =
                    new BufferedWriter(new FileWriter(file, false))) {
            writer.write("CarList object\n");
            cars.forEach(car -> {
                try {
                    writer.write(car.getYear().toString());writer.append('\n');
                    writer.write(car.getMaker()); writer.append('\n');
                    writer.write(car.getModel()); writer.append('\n');
                    writer.write(car.getPrice().toString());
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

    @Override
    public Car load(File file) {
        try(BufferedReader reader =
                    new BufferedReader(new FileReader(file))) {
            if (reader.readLine().equals("Car object")){
                return new Car(
                        Integer.parseInt(reader.readLine()),
                        reader.readLine(),
                        reader.readLine(),
                        Long.parseLong(reader.readLine())
                );
            }
            else {
                System.out.println("Alien file");
                return new Car();
            }
        }
        catch (IOException e){
            System.out.println("Can't open file");
            System.out.println(e.getMessage());
            return new Car();
        }

    }

    @Override
    public CarLinkedList loadCarList(File file) {
        try(BufferedReader reader =
                    new BufferedReader(new FileReader(file))) {
            if (reader.readLine().equals("CarList object")){
                CarLinkedList carList = new CarLinkedList(this);
                String carYear;
                while ((carYear = reader.readLine()) != null){
                    carList.add(new Car(
                            Integer.parseInt(carYear),
                            reader.readLine(),
                            reader.readLine(),
                            Long.parseLong(reader.readLine())
                    ));
                }
                return carList;
            }
            else {
                System.out.println("Alien file");
                return new CarLinkedList(this);
            }
        }
        catch (IOException e){
            System.out.println("Can't open file");
            System.out.println(e.getMessage());
            return new CarLinkedList(this);
        }
    }
}
