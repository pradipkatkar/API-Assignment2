package com.api.testcases;

import com.api.CommonVariables.GlobalVars;
import com.api.apis.API_Methods;
import com.api.utilities.DataFileReader;
import com.aventstack.extentreports.Status;
import io.restassured.path.json.JsonPath;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.util.List;

public class Task_B_Testcase extends GlobalVars {
    API_Methods api_methods = new API_Methods();
    @Test
    public void taskB(){
        extentTest.info("Task_B_Testcase started....");
        Logger logger = LogManager.getLogger(Task_B_Testcase.class);
        setLogger(logger);
        testDataReader = new DataFileReader("TC_02_TestData");

        JsonPath jsonPath = api_methods.getAllPosts(testDataReader.getBaseURI(), testDataReader.getUserRes());

        api_methods.retrieveNameOfUsers(jsonPath);
        api_methods.retrieveEmailOfUsers(jsonPath);
        api_methods.retrieveAddressOfUsers(jsonPath);
        api_methods.retrievePhoneOfUsers(jsonPath);

        String emailData = API_Methods.fetchDataUsingEmail(testDataReader.getEmail());
        System.out.println("Data fetched using email = "+emailData);
        extentTest.log(Status.PASS,"Data fetched using email = "+emailData);

    }
}
