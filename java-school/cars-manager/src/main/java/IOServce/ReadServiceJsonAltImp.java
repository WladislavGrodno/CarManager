package IOServce;

import com.fasterxml.jackson.databind.ObjectMapper;
import service.CarList;

import java.io.IOException;

public class ReadServiceJsonAltImp
        extends ObjectMapper implements ReadService{
    @Override
    public CarList fileReader(String file) {
        try {
            return readValue(file, CarList.class);
        }
        catch (IOException e){
            System.out.print("bad " + file);
            System.out.println(e.getMessage());
            return new CarList();
        }
    }

}
