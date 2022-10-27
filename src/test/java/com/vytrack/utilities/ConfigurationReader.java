package com.vytrack.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties = new Properties();

    static {

        try {
            // Creates a file object, allows us to connect to a file
            FileInputStream file = new FileInputStream("config.properties");

            // loads the files into the properties object
            properties.load(file);

            file.close();

        }catch(IOException e){
            System.out.println("File not found");
            e.printStackTrace();
        }

    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}