package com.api.testcases;

import com.api.commonVariables.GlobalVars;
import com.api.apis.API_Methods;
import com.api.utilities.ConfigFileReader;
import com.api.utilities.DataFileReader;
import com.aventstack.extentreports.Status;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class TC02_RetrieveListOfUsers extends GlobalVars {
    API_Methods api_methods = new API_Methods();
    @Test
    public void retrieveListOfUsers(){
        extentTest.info("TC02_RetrieveListOfUsers started....");

        testDataReader = new DataFileReader("TC_02_TestData");
        ConfigFileReader configFileReader = new ConfigFileReader();

        JsonPath jsonPath = api_methods.getAllPosts(configFileReader.getBaseURI(), endPoints.getUserEndPoint());

        api_methods.retrieveNameOfUsers(jsonPath);
        api_methods.retrieveEmailOfUsers(jsonPath);
        api_methods.retrieveAddressOfUsers(jsonPath);
        api_methods.retrievePhoneOfUsers(jsonPath);

        String emailData = API_Methods.fetchDataUsingEmail(testDataReader.getEmail());
        System.out.println("Data fetched using email = "+emailData);
        extentTest.log(Status.PASS,"Data fetched using email = "+emailData);

    }
}
