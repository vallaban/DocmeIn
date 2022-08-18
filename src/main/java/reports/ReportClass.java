package main.java.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import main.java.constants.FrameworkConstants;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ReportClass{
    private static ExtentReports reports;
    private static ExtentTest test;
    private static File reportLocation;
    public static void reportInitiation()
    {
        reports = new ExtentReports();
        reportLocation = new File(FrameworkConstants.getEXTENTRPEORTFILEPATH());
        ExtentSparkReporter reporter = new ExtentSparkReporter(reportLocation);
        reporter.config().setTheme(Theme.STANDARD);
        reporter.config().setDocumentTitle("DocumentTitle");
        reporter.config().setReportName("This is Automation Report Name");
        reports.attachReporter(reporter);

    }
    public static void createTest(String testname) {
         test =reports.createTest(testname);
    }
    public static ExtentTest getTest ()
    {
        return test;
    }
    public static void flushReport() throws IOException {
        reports.flush();
        Desktop.getDesktop().browse(reportLocation.toURI());
        
    }


}
