package com.api.testcases;

import com.api.commonVariables.GlobalVars;
import com.api.apis.API_Methods;
import com.api.utilities.ConfigFileReader;
import com.api.utilities.DataFileReader;
import com.aventstack.extentreports.Status;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;


public class TC01_RetrieveListOfPosts extends GlobalVars {

    API_Methods api_methods = new API_Methods();

    @Test
    public void retrieveListOfPost(){
        testDataReader = new DataFileReader("TC_01_TestData");
        ConfigFileReader configFileReader = new ConfigFileReader();
        extentTest.info("TC01_RetrieveListOfPosts started....");

        JsonPath jsonPath = api_methods.getAllPosts(configFileReader.getBaseURI(), endPoints.getPostEndPoint());
        extentTest.log(Status.PASS,"Successfully fetched all the posts");
        logger.info("Successfully fetched all the posts");

        api_methods.retrieveTitlesOfPosts(jsonPath);
        api_methods.retrieveIdsOfPosts(jsonPath);
        api_methods.retrieveBodyOfPosts(jsonPath);
        api_methods.storeTitleAndBodyInDictionary(jsonPath);

        String data = API_Methods.fetchDataUsingID(testDataReader.getId());
        extentTest.log(Status.PASS,"Fetching particular posts using id = " +testDataReader.getId());
        logger.info("Fetching particular posts using id = " +testDataReader.getId());

        extentTest.log(Status.PASS,"Successfully fetched data of posts =" + data );
        logger.info("Successfully fetched data of posts =" + data);
    }
}
