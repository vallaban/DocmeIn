package main.java.utility;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public final class JavaScriptUtil {
    private JavaScriptUtil()
    {

    }
    public static void drawBorder (WebElement element, WebDriver driver)
    {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.border= '3px solid red'", element);
    }
    public static void undrawBorder(WebElement element, WebDriver driver)
    {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.border=''", element);
    }
}
