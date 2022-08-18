package main.java.utility;
import main.java.driver.Driver;
import main.java.enums.WAITTECHNIQUES;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class ExplicitWaitTech {
    private ExplicitWaitTech()
    {

    }
    public static WebElement performWait(By by, WAITTECHNIQUES wait){
            WebElement element=null;
            if(wait==WAITTECHNIQUES.CLICKABLE)
    {
        element= new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(by));
    }else if (wait==WAITTECHNIQUES.PRESENCE) {
            element = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(by));
    }else if (wait ==WAITTECHNIQUES.VISIBILITY){
                            element = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(by));
    } else if(wait==WAITTECHNIQUES.NONE){
                element = Driver.getDriver().findElement(by);
    }
            return element;

    }



}
