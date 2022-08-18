package main.java.utility;
import main.java.driver.Driver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class CaptureScreenShots {
    private CaptureScreenShots()
    {

    }
    public static String getBaseImage()
    {
        return ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
