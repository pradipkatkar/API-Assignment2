package com.api.utilities;

import com.api.CommonVariables.GlobalVars;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class HtmlReporting extends GlobalVars {

    public static void Reports(){
        extentSparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\Reports" + "\\HtmlReport_"+timeStamp+"" + ".html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        setExtentReports(extentReports);
    }

    public static ExtentReports getExtentReports() {
        return extentReports;
    }

    public static void setExtentReports(ExtentReports extentReports) {
        HtmlReporting.extentReports = extentReports;
    }

}
