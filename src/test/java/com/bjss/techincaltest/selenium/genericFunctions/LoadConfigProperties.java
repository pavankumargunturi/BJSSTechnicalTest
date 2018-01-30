package com.bjss.techincaltest.selenium.genericFunctions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class LoadConfigProperties  {

    public String loadConfig(String key) throws IOException {
        Properties prop = new Properties();
        prop.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
        String property = prop.getProperty(key);
        return property;
    }

}