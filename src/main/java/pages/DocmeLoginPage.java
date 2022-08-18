package main.java.pages;
import main.java.enums.WAITTECHNIQUES;
import org.openqa.selenium.By;
import java.util.Map;
public class DocmeLoginPage extends BasePage {
    private final By username = By.xpath("//input[@type='email']");
    private final By password = By.xpath("//input[@type='password']");
    private final By submit = By.xpath("//input[@type='submit']");

    public DocmeLoginPage enterUsername(Map<String, String> map)
    {
        enterValues(username, WAITTECHNIQUES.PRESENCE, map.get("username"),"UserName");
        return this;

    }
    public DocmeLoginPage enterPassword(Map<String, String> map)
    {
        enterValues(password, WAITTECHNIQUES.PRESENCE, map.get("password"),"Password");

        return this;
    }
    public  DocmeHomePage clickonSubmit()
    {
        clickOn(submit, WAITTECHNIQUES.CLICKABLE, "Submit");
        return new DocmeHomePage();
    }
}
