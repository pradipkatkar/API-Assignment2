package com.api.testcases;

import com.api.CommonVariables.GlobalVars;
import com.api.apis.API_Methods;
import com.api.utilities.DataFileReader;
import com.aventstack.extentreports.Status;
import io.restassured.path.json.JsonPath;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;


public class Task_D_Testcase extends GlobalVars {

    API_Methods api_methods = new API_Methods();

    @Test
    public void taskD(){
        Logger logger = LogManager.getLogger(Task_D_Testcase.class);
        setLogger(logger);
        testDataReader = new DataFileReader("TC_04_TestData");
        extentTest.log(Status.PASS,"Performing put request for updating posts");
        JsonPath jsonPath =  API_Methods.updatePost(testDataReader.getBaseURI(),testDataReader.getPostRes(),testDataReader.getId(),testDataReader.getUserId(),testDataReader.getUpdatedTitle(),testDataReader.getBody());
        extentTest.log(Status.PASS,"Base URI = "+testDataReader.getBaseURI());
        extentTest.log(Status.PASS,"Sending data for updating posts || " +" id = "+testDataReader.getId() + " || userid = "+testDataReader.getUserId() + "|| updated tile = "+testDataReader.getUpdatedTitle()+" || body = "+testDataReader.getBody());

        int id = api_methods.retrieveIdOfCratedPost(jsonPath);

        String data = API_Methods.fetchDataUsingID(id);
        extentTest.log(Status.PASS,"Get request for retrieving created post using id = " + id + " , created post " + data );
        System.out.println("Put Response using id = "+data);

        api_methods.retrieveTitleOfUpdatedPost(jsonPath);

        api_methods.retrieveBodyOfUpdatedPost(jsonPath);

        api_methods.storeTitleAndBodyOfNewCreatedPostInDictionary(jsonPath);

    }
}
