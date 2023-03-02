package com.api.utilities;

import com.api.CommonVariables.GlobalVars;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Environment extends GlobalVars {

    public Properties loadConfigProperties(){

        try {
            properties = new Properties();
            fileInputStream = new FileInputStream(System.getProperty("user.dir")+ File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator+"com"+File.separator+"api"+File.separator+"resource"+File.separator+"config.properties");
            properties.load(fileInputStream);
            return properties;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
