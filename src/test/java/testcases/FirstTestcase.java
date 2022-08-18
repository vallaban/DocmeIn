package test.java.testcases;

import main.java.pages.DocmeLoginPage;
import main.java.utility.DataProviderUtil;
import org.testng.annotations.Test;

import java.util.Map;

public class FirstTestcase extends BaseTest{
    @Test
    public void loginTestcase(Map<String, String> map)
    {
        new DocmeLoginPage().enterUsername(map).enterPassword(map).clickonSubmit();
    }
}
