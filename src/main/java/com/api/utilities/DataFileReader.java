package com.api.utilities;

import com.api.CommonVariables.GlobalVars;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class DataFileReader extends GlobalVars {

    public DataFileReader(String fileName) {
        try {
            fileInputStream = new FileInputStream(System.getProperty("user.dir")+File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator+"com"+File.separator+"api"+File.separator+"datafiles"+File.separator+fileName+".properties");
            properties = new Properties();
            properties.load(fileInputStream);
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);}
        catch (IOException e) {
            throw new RuntimeException(e);}
    }

    public String getBaseURI(){
        return properties.getProperty("BaseURI");
    }

    public String getPostRes(){
        return properties.getProperty("postResource");
    }

    public String getUserRes(){
        return properties.getProperty("userResource");
    }
    public String getEmail(){
        return properties.getProperty("email");
    }
    public String getTitle(){
        return properties.getProperty("title");
    }
    public String getBody(){
        return properties.getProperty("body");
    }
    public int getId(){
        return Integer.parseInt(properties.getProperty("id"));
    }
    public int getUserId(){
        return Integer.parseInt(properties.getProperty("userid"));
    }
    public String getUpdatedTitle(){
        return properties.getProperty("updated_title");
    }
    public String getTCName(){
        return properties.getProperty("tcname");
    }

}
