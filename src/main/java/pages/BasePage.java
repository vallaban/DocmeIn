package main.java.pages;

import com.aventstack.extentreports.MediaEntityBuilder;
import main.java.driver.Driver;
import main.java.enums.WAITTECHNIQUES;
import main.java.reports.ReportClass;
import main.java.utility.CaptureScreenShots;
import main.java.utility.ExplicitWaitTech;
import main.java.utility.JavaScriptUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {
    public void enterValues(By by, WAITTECHNIQUES wait, String ElementValue, String ElementName)
    {
        WebElement element = ExplicitWaitTech.performWait(by, wait);
        JavaScriptUtil.drawBorder(element, Driver.getDriver());
        ReportClass.getTest().pass("Keyboard entry action performed on \""+ElementName+"\"", MediaEntityBuilder.createScreenCaptureFromBase64String(CaptureScreenShots.getBaseImage()).build());
        JavaScriptUtil.undrawBorder(element, Driver.getDriver());
        element.sendKeys(ElementValue);

    }
    public void clickOn(By by, WAITTECHNIQUES wait, String ElementName)
    {
        WebElement  element = ExplicitWaitTech.performWait(by, wait);
        JavaScriptUtil.drawBorder(element, Driver.getDriver());
        ReportClass.getTest().pass("Click action performed on \""+ElementName+"\"", MediaEntityBuilder.createScreenCaptureFromBase64String(CaptureScreenShots.getBaseImage()).build());
        JavaScriptUtil.undrawBorder(element,Driver.getDriver());
        element.click();

    }

}
