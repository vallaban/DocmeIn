package main.java.listeners;

import main.java.reports.ReportClass;
import main.java.testcasesteps.TestcaseDescriptions;
import main.java.utility.StringArraytoString;
import org.testng.*;

import java.io.IOException;

public class ListenerClass implements ISuiteListener, ITestListener {

    @Override
    public void onStart(ISuite suite) {
        ReportClass.reportInitiation();
    }

    @Override
    public void onFinish(ISuite suite) {
        try {
            ReportClass.flushReport();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        ReportClass.createTest(result.getMethod().getMethodName());
        String methodName= result.getMethod().getMethodName();
        String datatable = "<details>"+"<summary>Details</summary>"+"<html>"+"<head>"+"<title>HTML Tables</title>"+"</head>"+"<body>"
                + "<table border = \"1\">"+"<tr>"+"<td>Step1</td>"+"<td>Expected Result</td>"+"</tr>"+" <tr>"+"<td>Step2</td>"+"<td>Expected Result</td>"+"</tr>"
                +"</table>"+ "</body>"+ "</html>"+"</details>\n";
        String[] testcase= TestcaseDescriptions.getTestcase(methodName);
        String testcasedetail = StringArraytoString.convertStringarraytoString(testcase);
        ReportClass.getTest().info("<details>" + "<summary>"+ "<b>"+"<font color=" + "blue>" + "Testcase Description:Click to see"+ "</font>" +"</b>" + "</summary>" + testcasedetail.replaceAll(";", "<br>") +"</details>"+ "\n");
        //ReportClass.getTest().info(datatable);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ReportClass.getTest().pass("This test case "+ result.getMethod().getMethodName()+ "is passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ReportClass.getTest().fail("This test case " +result.getMethod().getMethodName()+ "is failed ");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ReportClass.getTest().skip("This test case "+ result.getMethod().getMethodName()+ " is skipped");
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
