package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop;

    static {
         prop = new Properties();
        String propFileName = System.getProperty("user.dir") +"/src/test/resources/config.properties";
        try( InputStream input = new FileInputStream(propFileName);){
            prop.load(input);
        } catch (IOException e){
            throw new RuntimeException("Failed to load config.properties", e);
        }

    }

    public static String getProperty(String key){
        return prop.getProperty(key);
    }


}
