package com.barshop.app.properties;

import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class LoadProperties {

    private static final Logger LOGGER = Logger.getLogger(LoadProperties.class);

    private static LoadProperties instance = null;

    private Properties properties;

    private LoadProperties() {
        String propertiesFile = "application.properties";
        ;
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(propertiesFile)) {
            LOGGER.info("Load properties File -> src/main/resources/" + propertiesFile);
            properties.load(input);
        } catch (Exception ex) {
            LOGGER.error("Error Load properties File -> src/main/resources/" + propertiesFile, ex);
        }
    }
    
    public static LoadProperties getInstance() {
        if(instance == null) {
            instance = new LoadProperties();
        }
        return instance;
    }
    
    public Properties getProperties() {
        return properties;
    }
    
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
    
}
