package test.java.testcases;
import main.java.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.Map;

public class BaseTest {
    @BeforeMethod
    public void setUp(Object[] data) throws Exception {

        Map<String, String> map = (Map<String,String>)(data[0]);
        Driver.driverInitiation(map.get("browser"));

    }
    @AfterMethod
    public void tearDown()
    {
        Driver.tearDownDriver();
    }
}
