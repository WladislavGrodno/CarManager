package com.education.project.cars.manager.carsmanager.IOServce;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import com.education.project.cars.manager.carsmanager.service.CarList;
import com.education.project.cars.manager.carsmanager.service.DBPoolService;
import com.education.project.cars.manager.carsmanager.utils.PostgresGet;

@Setter
@Getter
@Service
//@AllArgsConstructor
public class ReadServiceDBImp implements ReadService{
    private DBPoolService source;// = new DBPoolService();
    private PostgresGet postgresGet = new PostgresGet();

    public ReadServiceDBImp() {
        source = new DBPoolService();
    }

    public ReadServiceDBImp(DBPoolService source) {
        this.source = source;
    }

    public void setSource(DBPoolService source) {
        this.source = source;
    }

    @Override
    public CarList fileReader(String fileName) {
        String query = "SELECT Year, Brand, Model, Cost FROM " + fileName + ";";
        source.readDB(query);
        return postgresGet.carList(source.getRs());
    }
}
