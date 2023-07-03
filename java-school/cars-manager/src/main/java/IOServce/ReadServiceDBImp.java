package IOServce;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import service.CarList;
import service.DBPoolService;
import service.CarServiceDBAltImp;
import utils.PostgresGet;

@Setter
@Getter
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
