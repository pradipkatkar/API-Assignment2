package com.api.payload;


import com.api.CommonVariables.GlobalVars;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class PayloadReader extends GlobalVars {
    public static String createNewPost(String title, String body){
        String filename = payloadFile + "createPost.json";
        Gson gson =  new GsonBuilder().setPrettyPrinting().create();
        try {
            //JSon file to java object
            Posts data = gson.fromJson(new FileReader(filename), Posts.class);
            data.setTitle(title);
            data.setBody(body);
            //Java object to json string
            String jsonString = gson.toJson(data);
            System.out.println(jsonString);
            return jsonString;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static String updatePost(int userID, int id, String title, String body){
        String filename = payloadFile + "createPost.json";
        Gson gson =  new GsonBuilder().setPrettyPrinting().create();
        try {
            //JSon file to java object
            Posts data = gson.fromJson(new FileReader(filename), Posts.class);
            data.setUserid(userID);
            data.setId(id);
            data.setTitle(title);
            data.setBody(body);
            //Java object to json string
            String jsonString = gson.toJson(data);
            System.out.println(jsonString);
            return jsonString;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public static JSONObject createNewUser(){
        JSONObject json = new JSONObject();
        json.put("id","11");
        json.put("name","abcd");
        json.put("username","abc1");
        json.put("email","abc1@gmail.com");
       /* Map add = new HashMap<>();
        add.put("street","street1");
        add.put("suite","suite1");
        add.put("city","city1");
        add.put("zipcode","zipcode1");
        json.put("address",add);
        Map comp = new HashMap<>();
        comp.put("name","compname1");
        comp.put("phrase","phrase1");
        comp.put("bs","bs1");
        json.put("Company",comp);
        */return json;
    }


}
