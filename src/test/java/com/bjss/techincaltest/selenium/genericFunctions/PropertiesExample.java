package com.bjss.techincaltest.selenium.genericFunctions;

import java.io.*;
import java.util.Properties;

public class PropertiesExample {
    static Properties prop = new Properties();
    public static void main( String[] args ){


        InputStream input = null;

        try {

            String filename = "config.properties";
            input = PropertiesExample.class.getClassLoader().getResourceAsStream(filename);
            if(input==null){
                System.out.println("Sorry, unable to find " + filename);
                return;
            }
            prop.load(input);

            //get the property value and print it out


        } catch (IOException ex) {
            ex.printStackTrace();
        } finally{
            if(input!=null){
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public static String getProperty (String key) {
        return prop.getProperty("url");
    }

}
