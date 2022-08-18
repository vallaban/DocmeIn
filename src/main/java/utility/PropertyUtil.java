package main.java.utility;

import main.java.enums.CONFIGENUM;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputFilter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class PropertyUtil {
    private static Properties prop = new Properties();
    private static Map<String, String> configMap = new HashMap<>();
    static{
        try{
            FileInputStream fis = new FileInputStream("C:\\Users\\valla\\IdeaProjects\\DocmeIn\\src\\test\\resources\\configurationfolder\\config.properties");
            prop.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        prop.entrySet().forEach(entry-> configMap.put((String.valueOf(entry.getKey())),(String.valueOf(entry.getValue()))));

    }
    public static String getValue (CONFIGENUM key) throws Exception {
        if((Objects.isNull(key))||(Objects.isNull(key.name().toLowerCase())))
        {
            throw new Exception("Key value entered is " +key+ " is not valid, Please check \" config.properties\"");
        } else{
            return configMap.get(key.name().toLowerCase());
        }
    }
}
