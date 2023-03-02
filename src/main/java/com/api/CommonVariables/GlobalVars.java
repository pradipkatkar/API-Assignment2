package com.api.CommonVariables;

import com.api.utilities.DataFileReader;
import com.api.utilities.HtmlReporting;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

public class GlobalVars {
    public static ExtentReports extentReports;
    public static ExtentSparkReporter extentSparkReporter;

    public static ExtentTest extentTest;

    public static FileInputStream fileInputStream = null;
    public static  Properties properties;
    public static DataFileReader testDataReader ;

    public static String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(Calendar.getInstance().getTime());

    public static String payloadFile = System.getProperty("user.dir")+ File.separator+"src"+File.separator+"main"+File.separator+"java"+File.separator+"com"+File.separator+"api"+File.separator+"payload"+File.separator;

    public static Logger logger = null;

    public static ExtentTest getExtentTest() {
        return extentTest;
    }

    public static void setExtentTest(ExtentTest extentTest) {
        HtmlReporting.extentTest = extentTest;
    }

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger) {
        GlobalVars.logger = logger;
    }
}
