package pl.piotrowski;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesManager {

    public static String getProperty (String key){
        InputStream inputStream = PropertiesManager.class.getClassLoader().getResourceAsStream("config.properties");

        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.println("Couldn't find property with given key: " + key);
        }

        return properties.getProperty(key);
    }

}
