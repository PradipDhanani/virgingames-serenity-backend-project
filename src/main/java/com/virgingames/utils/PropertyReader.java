package com.virgingames.utils;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by Pradip
 */
public class PropertyReader {

    /**
     * Rules fo implementing singleton design pattern
     * Make the constructor private
     * Create a static method to get the instance
     * Create a static member variable
     */


    /**
     * Declare the PropertyReade var9able
     */

    private static volatile PropertyReader propInstance;

    /**
     * Create private constructor because of prevent the instantiation of class
     */

    private PropertyReader(){

    }
    /**
     * This method will return instance of PropertyReader class
     *
     * @return
     */
    public static synchronized PropertyReader getInstance() {
        if (propInstance == null) {
            propInstance = new PropertyReader();
        }
        return propInstance;
    }

    /**
     * This method will read property from property file
     *
     * @param propertyName
     * @return
     */
    public String getProperty(String propertyName) {

        Properties prop = new Properties();
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/com/virgingames/resources/application.properties");
            prop.load(inputStream);
            if (prop.getProperty(propertyName) != null) {
                return prop.getProperty(propertyName);
            }
        } catch (Exception e) {
            System.out.println("Property not found");
        }
        return null;
    }






}
