package com.education.project.cars.manager.carsmanager.IOServce;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import com.education.project.cars.manager.carsmanager.service.CarList;
import com.education.project.cars.manager.carsmanager.service.DBPoolService;
import com.education.project.cars.manager.carsmanager.utils.PostgresGet;

@Getter
@Setter
@Service
//@NoArgsConstructor
//@AllArgsConstructor
//@Service
public class WriteServiceDBImp implements WriteService{
//    @Autowired
    private DBPoolService source;
//    @Autowired

    private PostgresGet postgresGet = new PostgresGet();

    public WriteServiceDBImp(DBPoolService source) {
        this.source = source;
    }

    @Override
    public void fileWriter(CarList list, String fileName) {
        source.setStatement(postgresGet.insertCarListQuery(list, fileName));
    }
}
