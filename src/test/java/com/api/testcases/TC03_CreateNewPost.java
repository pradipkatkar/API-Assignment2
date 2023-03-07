package com.api.testcases;

import com.api.commonVariables.GlobalVars;
import com.api.apis.API_Methods;
import com.api.utilities.ConfigFileReader;
import com.api.utilities.DataFileReader;
import com.aventstack.extentreports.Status;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class TC03_CreateNewPost extends GlobalVars {

    API_Methods api_methods = new API_Methods();
    @Test
    public void createNewPost(){
        ConfigFileReader configFileReader = new ConfigFileReader();
        testDataReader = new DataFileReader("TC_03_TestData");
        extentTest.info("TC03_CreateNewPost started....");
        extentTest.log(Status.PASS,"Performing post request to create new post.");
        JsonPath jsonPath = api_methods.createNewPost(configFileReader.getBaseURI(),endPoints.getPostEndPoint(),testDataReader.getTitle(),testDataReader.getBody());


       int id = api_methods.retrieveIdOfCratedPost(jsonPath);

        String res = API_Methods.fetchDataUsingID(id);
        extentTest.log(Status.PASS,"Get request for retrieving created post using id = " + id + " , created post " + res );
        System.out.println(res);

        api_methods.retrieveTitleOfCratedPost(jsonPath);
        api_methods.retrieveBodyOfCratedPost(jsonPath);
        api_methods.storeTitleAndBodyOfNewCreatedPostInDictionary(jsonPath);
    }
}
