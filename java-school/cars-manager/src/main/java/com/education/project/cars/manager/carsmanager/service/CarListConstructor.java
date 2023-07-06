package com.education.project.cars.manager.carsmanager.service;

import com.education.project.cars.manager.carsmanager.IOServce.*;
import com.education.project.cars.manager.carsmanager.utils.Get;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarListConstructor {
    //@Autowired
    private DBPoolService poolServiceIn;
    //@Autowired
    private DBPoolService poolServiceOut;
    @Autowired
    private Get get;// = new Get();

    public CarServiceProcessorImp construct(
            DBPoolService pServiceIn,
            DBPoolService pServiceOut){
        poolServiceIn = pServiceIn;
        poolServiceOut = pServiceOut;

        ReadService inService = null;
        WriteService outService = null;
        CarService carService = null;
        String fileSource = null;
        String fileDestination = null;


        boolean escape = false;
        do {
            System.out.printf("""
                            Select parameter to change:
                            1 - Input type. (%s)
                            2 - Input name. (%s)
                            3 - Output type. (%s)
                            4 - Output name. (%s)
                            5 - Accept services.
                            6 - Create null.
                            """,
                    getClassName(inService),
                    fileSource,
                    getClassName(outService),
                    fileDestination
            );
            switch (get.intNumber()){
                case 1 -> inService = selectReadService();
                case 2 -> fileSource = get.string();
                case 3 -> outService = selectWriteService();
                case 4 -> fileDestination = get.string();
                case 5 -> escape = true;
                case 6 -> {return null;}
            }
        }while (inService == null ||
                outService == null ||
                fileSource == null ||
                fileDestination == null ||
                !escape
        );

        switch (inService.getClass().getSimpleName()){
            case "ReadServiceDBImp" ->
                carService = new CarServiceDBAltImp(poolServiceIn, fileSource);
            default ->
                carService = new CarServiceAltImp();
        }

        return new CarServiceProcessorImp(inService, outService, carService,
                fileSource, fileDestination);
    }

    public ReadService selectReadService(){
        do {
            System.out.println("""
                    Select Read service:
                    1 - No reading.
                    2 - Read Test sample.
                    3 - TXT.
                    4 - Json.
                    5 - Postgres.
                    """);
            switch (get.intNumber()) {
                case 1 -> {return new ReadServiceEmptyImp();}
                case 2 -> {return new ReadServiceTestSampleImp();}
                case 3 -> {return new ReadServiceTxtAltImp();}
                case 4 -> {return new ReadServiceJsonAltImp();}
                case 5 -> {
                    if (poolServiceIn != null)
                        //return new ReadServiceDBImp();
                        return new ReadServiceDBImp(poolServiceIn);
                }
            }
        }while (true);
    }

    public WriteService selectWriteService(){
        do {
            System.out.println("""
                    Select Write service:
                    1 - No writing.
                    2 - TXT.
                    3 - Json.
                    4 - Postgres.
                    5 - To screen.
                    """);
            switch (get.intNumber()) {
                case 1 -> {return new WriteServiceEmptyImp();}
                case 2 -> {return new WriteServiceTxtAltImp();}
                case 3 -> {return new WriteServiceJsonAltImp();}
                case 4 -> {
                    if (poolServiceOut != null)
                        //return new WriteServiceDBImp();}
                        return new WriteServiceDBImp(poolServiceOut);}
                case 5 -> {return new WriteServiceScreenImp();}
            }
        }while (true);
    }

    private String getClassName(Object o){
        if (o == null) return "null";
        return o.getClass().getSimpleName();
    }
}
