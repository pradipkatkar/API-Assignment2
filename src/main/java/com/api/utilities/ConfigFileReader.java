package com.api.utilities;

import com.api.commonVariables.GlobalVars;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader{
    Properties properties;
    public ConfigFileReader() {
        try {
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "com" + File.separator + "api" + File.separator + "configuration" + File.separator + "config.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getBaseURI(){
        return properties.getProperty("BaseURI");
    }
}
