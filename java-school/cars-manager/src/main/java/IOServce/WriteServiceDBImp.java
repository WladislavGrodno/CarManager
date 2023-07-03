package IOServce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.CarList;
import service.DBPoolService;
import utils.PostgresGet;

@Getter
@Setter
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
        source.setStatement(postgresGet.sqlQuery(list, fileName));
    }
}
