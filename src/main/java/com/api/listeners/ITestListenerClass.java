package com.api.listeners;

import com.api.CommonVariables.GlobalVars;
import com.api.utilities.HtmlReporting;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerClass implements ITestListener {

    ExtentTest extentTest;
    @Override
    public void onTestStart(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.log(Status.PASS,"Testcase "+ result.getTestClass()+ " passed." );
    }

    @Override
    public void onTestFailure(ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE)
        HtmlReporting.getExtentTest().log(Status.FAIL,"Testcase "+ result.getTestClass() + " failed." );
    }

    @Override
    public void onTestSkipped(ITestResult result) {
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
    }

    @Override
    public void onStart(ITestContext context) {
        HtmlReporting.Reports();
        extentTest = HtmlReporting.getExtentReports().createTest(context.getClass().getSimpleName());
        GlobalVars.setExtentTest(extentTest);
    }

    @Override
    public void onFinish(ITestContext context) {
        HtmlReporting.getExtentReports().flush();
    }
}
