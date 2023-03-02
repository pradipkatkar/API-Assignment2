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

public class Task_C_Testcase extends GlobalVars {

    API_Methods api_methods = new API_Methods();
    @Test
    public void taskC(){
        Logger logger = LogManager.getLogger(Task_C_Testcase.class);
        GlobalVars.setLogger(logger);
        testDataReader = new DataFileReader("TC_03_TestData");
        extentTest.info("Task_C_Testcase started....");
        extentTest.log(Status.PASS,"Performing post request to create new post.");
        JsonPath jsonPath = api_methods.createNewPost(testDataReader.getBaseURI(),testDataReader.getPostRes(),testDataReader.getTitle(),testDataReader.getBody());


       int id = api_methods.retrieveIdOfCratedPost(jsonPath);

        String res = API_Methods.fetchDataUsingID(id);
        extentTest.log(Status.PASS,"Get request for retrieving created post using id = " + id + " , created post " + res );
        System.out.println(res);

        api_methods.retrieveTitleOfCratedPost(jsonPath);
        api_methods.retrieveBodyOfCratedPost(jsonPath);
        api_methods.storeTitleAndBodyOfNewCreatedPostInDictionary(jsonPath);
    }
}
