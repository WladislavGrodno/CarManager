package service;

import IOServce.*;
import utils.Get;


public class DialogMenuService {
    private Get get = new Get();
    //common actions for database, json, txt
    public void commonActions(CarServiceProcessorImp carService){
        CarList carList;
        if (carService.getInService()
                .getClass().getSimpleName().equals("ReadServiceDBImp"))
            carList = new CarList();
        else carList = carService.in();

        CarServiceProcessorImp show;
        show = new CarServiceProcessorImp(
                new ReadServiceTestSampleImp(),
                new WriteServiceScreenImp(),
                new CarServiceAltImp(),
                "","");


        //CarList outCars = new CarList();

        System.out.println(carService);
        do {
            System.out.printf("""
                    Select the number of action:
                    1. Find max cost car.
                    2. Find min cost car.
                    3. Get cars of the same brand.
                    4. Get cars of the same model.
                    5. Get cars by price range.
                    6. Sort cars by price.
                    7. Sort cars by brand.
                    8. Show all cars list.
                    9. Write cars. (destination show is under construction)
                    10. Change destination (is under construction).
                    11. Exit.
                    """);
                switch (get.intNumber()) {
                    case 1 -> show.out(carService.getMaxCostCar(carList));
                    case 2 -> show.out(carService.getMinCostCar(carList));
                    case 3 -> {
                        System.out.println("Write the brand of car to search:");
                        show.out(carService.findBrandList(
                                get.string(), carList));
                    }
                    case 4 -> {
                        System.out.println("Write the model of car to search:");
                        show.out(carService.findModelList(
                                get.string(), carList));
                    }
                    case 5 -> {
                        System.out.println("Write min price:");
                        int minPrice = get.intNumber();
                        System.out.println("Write max price:");
                        int maxPrice = get.intNumber();
                        show.out(carService.getListByPriceRange(
                                minPrice, maxPrice, carList));
                    }
                    case 6 -> show.out(carService.sortListByPrice(carList));
                    case 7 -> show.out(carService.sortListByBrand(carList));
                    case 8 -> show.out(carService.in());
                    case 9 -> carService.out(carList);
                    case 10 ->
                    {
                        System.out.println("Change destination for save:");
                        System.out.println("Under construction");
                    }
                    /*case 10 -> {
                        if(carList == null) carService.sortListByPrice(null);
                        else {
                            System.out.println("Write file name to read:");
                            //rwService.fileReader(Get.string());
                        }
                    }
                     */
                    case 11 -> {
                        System.out.println("Exit from menu\n");
                        return;
                    }
                    default -> System.out.println(
                            "You choose number without action\n");
                }
        }while (true);
    }
}
