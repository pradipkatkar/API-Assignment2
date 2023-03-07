package com.api.testcases;

import com.api.apis.API_Methods;
import com.api.commonVariables.GlobalVars;
import com.api.utilities.ConfigFileReader;
import com.api.utilities.DataFileReader;
import org.testng.annotations.Test;

public class TC_05_DeleteSpecificPost extends GlobalVars {
    API_Methods api_methods = new API_Methods();
    @Test
    public void deleteSpecificPost(){
        testDataReader = new DataFileReader("TC_05_TestData");
        ConfigFileReader configFileReader = new ConfigFileReader();
        extentTest.info("TC_05_DeleteSpecificPost started....");

        api_methods.deleteSpecificPostUsingID(configFileReader.getBaseURI(), endPoints.getPostEndPoint(),testDataReader.getId());
    }
}
