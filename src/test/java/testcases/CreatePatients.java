package test.java.testcases;
import main.java.pages.DocmeHomePage;
import main.java.pages.DocmeLoginPage;
import main.java.pages.Patients;
import org.testng.annotations.Test;

import java.util.Map;

public class CreatePatients extends BaseTest {
    @Test
    public void createPatienttestcase(Map<String, String> map)
    {

       DocmeHomePage homePage =  new DocmeLoginPage().enterUsername(map).enterPassword(map).clickonSubmit();
           Patients patients= homePage.clickonPatient();
           patients.createPatient(map);
    }
}
