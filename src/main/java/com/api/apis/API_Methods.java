package com.api.apis;

import com.api.commonVariables.GlobalVars;
import com.api.utilities.PayloadReader;
import com.aventstack.extentreports.Status;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;


import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class API_Methods extends GlobalVars {

    public static JsonPath rawToJson(String response){
        JsonPath jsonPath = new JsonPath(response);
        return jsonPath;
    }

    public JsonPath getAllPosts(String URI, String resource){
        RestAssured.baseURI = URI;
        extentTest.log(Status.PASS,"Base URI : " +URI);
        extentTest.log(Status.PASS,"Performing GET request for fetching all "+resource+".");
        logger.info("Base URI : " +URI);
        logger.info("Performing GET request for fetching all "+resource+".");

        String response =  given()
                .when().get(resource)
                .then().assertThat().statusCode(200).extract().response().asString();
        extentTest.log(Status.PASS,"Successfully performed GET request for fetching all "+resource+".");
        logger.info("Successfully Performing GET request for fetching all "+resource+".");
        return rawToJson(response);
    }

    public JsonPath createNewPost(String URI, String resource,String title,String body){
        RestAssured.baseURI = URI;
        extentTest.log(Status.PASS,"Base URI : " +URI);
        extentTest.log(Status.PASS,"Performing POST request for creating new posts.");
        extentTest.log(Status.PASS,"Data for creating new post : Title | "+title+" ,Body | "+body);
        logger.info("Base URI : " +URI);
        logger.info("Performing POST request for creating new posts.");
        logger.info("Data for creating new post : Title | "+title+"Body | "+body);

        String response =  given().header("Content-Type","application/json")
                .body(PayloadReader.readCreatePostPayload(title,body))
                .when().post(resource)
                .then().assertThat().statusCode(201).extract().response().asString();
        extentTest.log(Status.PASS,"Successfully performed POST request to create new post.");
        logger.info("Successfully performed POST request to create new post.");
        return rawToJson(response);
    }

    public static JsonPath updatePost(String URI, String resource, int id,int userId,String title,String body){
        RestAssured.baseURI = URI;
        extentTest.log(Status.PASS,"Base URI : " +URI);
        extentTest.log(Status.PASS,"Performing PUT request for updating posts.");
        logger.info("Base URI : " +URI);
        logger.info("Performing PUT request for updating posts.");

        String response = given().header("Content-Type","application/json")
                .body(PayloadReader.readUpdatePostPayload(userId,id,title,body))
                .when().put(resource+"/"+id)
                .then().assertThat().statusCode(200).extract().response().asString();
        return rawToJson(response);
    }

    public static String fetchDataUsingID(int id){
        extentTest.log(Status.PASS,"Performing GET request for fetching particular post using id.");
        extentTest.log(Status.PASS,"Post id = "+id);
        logger.info("Performing GET request for fetching particular post using id.");
        logger.info("Post id = "+id);

        String response =  given().queryParam("id",""+id+"").log().all()
                .when().get("posts")
                .then().assertThat().statusCode(200).extract().response().asString();
        extentTest.log(Status.PASS,"Successfully fetched post using id.");
        return response;
    }
    public static String fetchDataUsingEmail(String email){
        extentTest.log(Status.PASS,"Performing GET request for fetching particular user using email.");
        extentTest.log(Status.PASS,"User email = "+email);
        logger.info("Performing GET request for fetching particular user using email.");
        logger.info("User email = "+email);

        String response =  given().queryParam("email",""+email+"")
                .when().get("users")
                .then().assertThat().statusCode(200).extract().response().asString();
        extentTest.log(Status.PASS,"Successfully fetched user using email.");
        logger.info("Successfully fetched user using email.");
        return response;
    }

    public void retrieveTitlesOfPosts(JsonPath jsonPath){
        List title =  jsonPath.getList("title");
        extentTest.log(Status.PASS,"Storing titles of posts into list");
        logger.info("Storing titles of posts into list");

        for(int i=0;i<title.size();i++) {// System.out.println("titles["+i+"] = "+title.get(i));
        }
        extentTest.log(Status.PASS,"Parsing titles of all the posts");
        logger.info("Parsing titles of all the posts");
    }

    public void retrieveIdsOfPosts(JsonPath jsonPath){
        List id =  jsonPath.getList("id");
        extentTest.log(Status.PASS,"Storing ids of posts into list");
        logger.info("Storing ids of posts into list");

        for(int j=0;j<id.size();j++) {
            //System.out.println("id["+i+"] = "+id.get(i));
        }
        extentTest.log(Status.PASS,"Parsing ids of all the posts");
        logger.info("Parsing ids of all the posts");
    }

    public void retrieveBodyOfPosts(JsonPath jsonPath){
        List body =  jsonPath.getList("body");
        extentTest.log(Status.PASS,"Storing body of posts into list");
        logger.info("Storing ids of posts into list");

        for(int k=0;k<body.size();k++)
        { // System.out.println("body["+i+"] = "+body.get(i));
        }
        extentTest.log(Status.PASS,"Parsing body of all the posts");
        logger.info("Parsing body of all the posts");
    }

    public void storeTitleAndBodyInDictionary(JsonPath jsonPath){
        Dictionary dictionary = new Hashtable();
        extentTest.log(Status.PASS,"Created dictionary object to store title and body of posts");
        logger.info("Created dictionary object to store title and body of posts");
        List title =  jsonPath.getList("title");
        List body =  jsonPath.getList("body");
        for(int i=0;i<title.size();i++) {
            //System.out.println("Title["+i+"] = "+title.get(i));
            //System.out.println("Body["+i+"] = "+body.get(i));
            dictionary.put(title.get(i),body.get(i));}

        extentTest.log(Status.PASS,"Successfully stored title and body of posts into dictionary");
        logger.info("Successfully stored title and body of posts into dictionary");
    }

    public void retrieveNameOfUsers(JsonPath jsonPath){
        List name =  jsonPath.getList("name");
        extentTest.log(Status.PASS,"extracting name from json and storing into list");
        logger.info("Extracting name from json and storing into list");

        for(int i=0;i<name.size();i++){
            System.out.println("name["+i+"] = "+name.get(i));
        }

        extentTest.log(Status.PASS,"Parsing names of all the users");
        logger.info("Parsing names of all the users");
    }
    public void retrieveEmailOfUsers(JsonPath jsonPath){
        List email =  jsonPath.getList("email");
        extentTest.log(Status.PASS,"extracting email from json and storing into list");
        logger.info("Extracting email from json and storing into list");

        for(int i=0;i<email.size();i++){
            System.out.println("email["+i+"] = "+email.get(i));
        }

        extentTest.log(Status.PASS,"Parsing email of all the users");
        logger.info("Parsing email of all the users");
    }
    public void retrieveAddressOfUsers(JsonPath jsonPath){
        List address =  jsonPath.getList("address");
        extentTest.log(Status.PASS,"extracting address from json and storing into list");
        logger.info("Extracting address from json and storing into list");

        for(int i=0;i<address.size();i++){
            System.out.println("address["+i+"] = "+address.get(i));
        }

        extentTest.log(Status.PASS,"Parsing address of all the users");
        logger.info("Parsing address of all the users");
    }
    public void retrievePhoneOfUsers(JsonPath jsonPath){
        List phone =  jsonPath.getList("phone");
        extentTest.log(Status.PASS,"extracting phone from json and storing into list");
        logger.info("Extracting phone from json and storing into list" );

        for(int i=0;i<phone.size();i++){
            System.out.println("phone["+i+"] = "+phone.get(i));
        }
        extentTest.log(Status.PASS,"Parsing phone of all the users");
        logger.info("Extracting phone from json and storing into list");
    }

    public int retrieveIdOfCratedPost(JsonPath jsonPath){
        int id = jsonPath.getInt("id");
        extentTest.log(Status.PASS,"retrieving id of new created post , id = " + id );
        logger.info("retrieving id of new created post , id = " + id );
        return id;
    }

    public void retrieveTitleOfCratedPost(JsonPath jsonPath){
        String title = jsonPath.getString("title");
        extentTest.log(Status.PASS,"Extracting title of new created post | title = " + title );
        logger.info("Extracting title of new created post title = " + title );
    }

    public void retrieveBodyOfCratedPost(JsonPath jsonPath){
        String body = jsonPath.getString("body");
        extentTest.log(Status.PASS,"Extracting body of new created post | body = " + body );
        logger.info("Extracting body of new created post | body = " + body  );
    }

    public void storeTitleAndBodyOfNewCreatedPostInDictionary(JsonPath jsonPath){
        Dictionary dictionary = new Hashtable();
        extentTest.log(Status.PASS,"Created dictionary object to store title and body of posts");
        logger.info("Created dictionary object to store title and body of posts");
        String title = jsonPath.getString("title");
        String body = jsonPath.getString("body");
        dictionary.put(title,body);
        extentTest.log(Status.PASS,"Successfully stored title and body of posts into dictionary");
        logger.info("Successfully stored title and body of posts into dictionary");
    }

    public void retrieveTitleOfUpdatedPost(JsonPath jsonPath){
        String title = jsonPath.getString("title");
        extentTest.log(Status.PASS,"Extracting title of updated post title = " + title );
        logger.info("Extracting title of new created post title = " + title );
    }

    public void retrieveBodyOfUpdatedPost(JsonPath jsonPath){
        String body = jsonPath.getString("body");
        extentTest.log(Status.PASS,"Extracting body of updated post body = " + body );
        logger.info("Extracting body of new created post body = " + body  );
    }

    public JsonPath deleteSpecificPostUsingID(String URI, String resource, int id) {
        RestAssured.baseURI = URI;
        extentTest.log(Status.PASS,"Base URI : " +URI);
        extentTest.log(Status.PASS,"Performing delete request for deleting posts.");
        logger.info("Base URI : " +URI);
        logger.info("Performing delete request for deleting posts.");

        String response = given().header("Content-Type","application/json")
                .when().delete(resource+"/"+id)
                .then().assertThat().statusCode(200).extract().response().asString();
        extentTest.log(Status.PASS,"Endpoint for delete post : " +URI+"/"+resource+"/"+id);
        logger.info("Endpoint for delete post : " +URI+"/"+resource+"/"+id);
        extentTest.log(Status.PASS,"Deleted post id : " + id);
        logger.info("Deleted post id : " + id);

        extentTest.log(Status.PASS,"Successfully deleted post.");
        logger.info("Successfully deleted post.");
        return rawToJson(response);
    }
}
