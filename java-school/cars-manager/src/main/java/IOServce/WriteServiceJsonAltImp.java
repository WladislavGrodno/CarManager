package IOServce;

import com.fasterxml.jackson.databind.ObjectMapper;
import service.CarList;

import java.io.File;
import java.io.IOException;

public class WriteServiceJsonAltImp
        extends ObjectMapper implements WriteService{

    @Override
    public void fileWriter(CarList cars, String file) {
        try {
            writeValue(new File(file), cars);
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
