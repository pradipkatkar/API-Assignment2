package com.api.testcases;

import com.api.CommonVariables.GlobalVars;
import com.api.apis.API_Methods;
import com.api.utilities.DataFileReader;
import com.aventstack.extentreports.Status;
import io.restassured.path.json.JsonPath;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class Task_A_Testcase extends GlobalVars {

    API_Methods api_methods = new API_Methods();
    @Test
    public void taskA(){
        Logger logger = LogManager.getLogger(Task_A_Testcase.class);
        setLogger(logger);
        testDataReader = new DataFileReader("TC_01_TestData");
        extentTest.info("Task_A_Testcase started....");
        logger.info("Task_A_Testcase started....");

        JsonPath jsonPath = api_methods.getAllPosts(testDataReader.getBaseURI(), testDataReader.getPostRes());
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
