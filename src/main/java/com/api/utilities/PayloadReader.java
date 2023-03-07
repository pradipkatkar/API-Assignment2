package com.api.utilities;


import com.api.commonVariables.GlobalVars;
import com.api.payload.Posts;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.FileNotFoundException;
import java.io.FileReader;

public class PayloadReader extends GlobalVars {
   static Gson gson =  new GsonBuilder().setPrettyPrinting().create();

    public static String readCreatePostPayload(String title, String body){
            Posts data = WrapperFunctions.postPayloadFileReader(testDataReader.getPostPayloadFileName());
            data.setTitle(title);
            data.setBody(body);
            //Java object to json string
            String jsonString = gson.toJson(data);
            return jsonString;
    }

    public static String readUpdatePostPayload(int userID, int id, String title, String body){
        Posts data = WrapperFunctions.postPayloadFileReader(testDataReader.getPostPayloadFileName());
            data.setUserid(userID);
            data.setId(id);
            data.setTitle(title);
            data.setBody(body);
            //Java object to json string
            String jsonString = gson.toJson(data);
            System.out.println(jsonString);
            return  jsonString;
    }

}
