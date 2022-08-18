package test.java.testcases;

import main.java.pages.DocmeHomePage;
import main.java.pages.DocmeLoginPage;
import main.java.pages.Patients;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ExistingPatients extends BaseTest{

    @Test
    public void existingPatients(Map<String, String> map) throws IOException {
        DocmeHomePage homePage =  new DocmeLoginPage().enterUsername(map).enterPassword(map).clickonSubmit();
        Patients patients= homePage.clickonPatient();
       List<String> existPatientHeader= patients.listofExistingPatients();
        System.out.println(existPatientHeader);
        System.out.println(existPatientHeader.size());
        patients.findElementsinHeaderTable();
    }
}
