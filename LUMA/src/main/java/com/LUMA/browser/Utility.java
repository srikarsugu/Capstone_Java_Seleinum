package com.LUMA.browser;

import java.io.FileReader;
import java.util.Properties;

public class Utility {

    // Method to fetch property value from the configuration file
    public static String properties(String key) {
        String propertiesData = null;
        try {
            // Define the path of the properties file
            String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\Configure.properties";
            
            // Load properties from the file
            FileReader reader = new FileReader(filePath);
            Properties p = new Properties();
            p.load(reader);

            // Retrieve the value for the given key
            propertiesData = p.getProperty(key);
            
        } catch (Exception e) {
            System.out.println("Utility - properties: " + e.getMessage());
        }
        return propertiesData;
    }
}
