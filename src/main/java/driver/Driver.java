package main.java.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import main.java.constants.FrameworkConstants;
import main.java.enums.BROWSERS;
import main.java.enums.CONFIGENUM;
import main.java.utility.PropertyUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Driver {
    private static WebDriver driver;

    public static void driverInitiation(String browsername) throws Exception {
        if(browsername.equalsIgnoreCase(FrameworkConstants.getValueofBrowser(BROWSERS.CHROME)))
        {           WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(PropertyUtil.getValue(CONFIGENUM.URL));
            driver.manage().window().maximize();
        }else if (browsername.equalsIgnoreCase(FrameworkConstants.getValueofBrowser(BROWSERS.EDGE)))
        {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.get(PropertyUtil.getValue(CONFIGENUM.URL));
            driver.manage().window().maximize();
        }else if (browsername.equalsIgnoreCase(FrameworkConstants.getValueofBrowser(BROWSERS.FIREFOX)))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get(PropertyUtil.getValue(CONFIGENUM.URL));
            driver.manage().window().maximize();
        }else   {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(PropertyUtil.getValue(CONFIGENUM.URL));
            driver.manage().window().maximize();
        }

    }

    public static WebDriver getDriver()
    {
        return driver;
    }
    public static void tearDownDriver()
    {
        driver.quit();
    }

}
