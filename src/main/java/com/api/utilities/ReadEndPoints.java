package com.api.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadEndPoints {
    Properties properties;
    public ReadEndPoints() {
        try {
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "com" + File.separator + "api" + File.separator + "datafiles" + File.separator + "endPoints.properties");
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String getPostEndPoint(){return properties.getProperty("postEndPoint");}

    public String getUserEndPoint(){return properties.getProperty("userEndPoint");}
}
