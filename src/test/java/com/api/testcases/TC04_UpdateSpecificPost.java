package com.api.testcases;

import com.api.commonVariables.GlobalVars;
import com.api.apis.API_Methods;
import com.api.utilities.ConfigFileReader;
import com.api.utilities.DataFileReader;
import com.aventstack.extentreports.Status;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;


public class TC04_UpdateSpecificPost extends GlobalVars {

    API_Methods api_methods = new API_Methods();
    ConfigFileReader configFileReader = new ConfigFileReader();
    @Test
    public void updateSpecificPost(){
        testDataReader = new DataFileReader("TC_04_TestData");
        extentTest.log(Status.PASS,"Performing put request for updating posts");
        JsonPath jsonPath =  API_Methods.updatePost(configFileReader.getBaseURI(),endPoints.getPostEndPoint(),testDataReader.getId(),testDataReader.getUserId(),testDataReader.getUpdatedTitle(),testDataReader.getBody());
        extentTest.log(Status.PASS,"Base URI = "+configFileReader.getBaseURI());
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
