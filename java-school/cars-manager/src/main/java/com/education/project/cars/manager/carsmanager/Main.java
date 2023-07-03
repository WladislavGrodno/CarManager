package com.education.project.cars.manager.carsmanager;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import service.*;

@Service
public class Main {
    private CarListConstructor carListConstructor = new CarListConstructor();
    public DBPoolService source = new DBPoolService();
    private DialogMenuService dialogMenuService = new DialogMenuService();

    @PostConstruct
    public void run() {
        //public void run(String[] args) {


        if (source.checkStatus()) {

            /*
            //закинуть тестовую выборку в SQL
            processorShowTest = new CarServiceProcessorImp(
                    new ReadServiceTestSampleImp(),
                    new WriteServiceDBImp(source),
                    new CarServiceAltImp(),
                    "","Garage");
            processorShowTest.out(processorShowTest.in());
             */

            CarServiceProcessorImp processor;
            //System.out.println("Stage 1");
            processor = carListConstructor.construct(source, source);
            /*processor = new CarServiceProcessorImp(
                    new ReadServiceDBImp(),
                    new WriteServiceScreenImp(),
                    new CarServiceDBAltImp(source, "Garage"),
                    "Garage","");
             */

            if (processor != null) {
                dialogMenuService.commonActions(processor);
            }


        }
        else System.out.println("Postgres isn't run");

        source.closeConnection();
    }
}