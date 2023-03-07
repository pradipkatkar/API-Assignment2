package com.api.utilities;

import com.api.commonVariables.GlobalVars;
import com.api.payload.Posts;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class WrapperFunctions extends GlobalVars {

        public static Posts postPayloadFileReader(String fileName){
            String filename = payloadFile + ""+fileName+".json";
            Gson gson =  new GsonBuilder().setPrettyPrinting().create();
            try {
                Posts data = gson.fromJson(new FileReader(filename), Posts.class);
                return data;
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
}
