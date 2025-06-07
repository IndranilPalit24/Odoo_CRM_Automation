package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    public Properties property;

    /**
     * Loads the properties file from the specified location.
     * @return it returns Properties object
     */
    public Properties init_prop()  {
        property = new Properties();
        try {
            FileInputStream file = new FileInputStream("src/test/resources/Config/config.properties");
            property.load(file);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
        return property;
    }


}
