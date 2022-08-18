package main.java.pages;

import main.java.driver.Driver;
import main.java.enums.WAITTECHNIQUES;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Patients extends BasePage{
    private final By createxpath = By.xpath("//div[@class='gwt-Label'][normalize-space()='Create']");
    private final By newPatient = By.xpath("//div[@class='Caption']");
    private final By fullname = By.xpath("//input[@name='name']");
    private final By email = By.xpath("//input[@name='email']");
    private final By ssn1 =By.xpath("//div[@class='pr-editableLabel']//input[1]");
    private final By ssn2=By.xpath("//tbody//tr//input[2]");
    private final By ssn3 = By.xpath("//tbody//tr//input[3]");
    private final By ph1 = By.xpath("(//input[@type='text'])[306]");
    private final By ph2= By.xpath("(//input[@type='text'])[307]");
    private final By ph3 =By.xpath("(//input[@type='text'])[308]");
    private final By insuranceprovider = By.xpath("//input[@class='gwt-SuggestBox']");
    private final By currentPatient = By.xpath("//input[@class='gwt-SuggestBox']");
    private final By save= By.xpath("(//div[contains(text(),'Save')])[2]");
    private final By patientHeader= By.xpath("(//table)[65]");
    private String fullnameInsta;
    private String emailInsta;
    private String phonenumberInsta;

    public Patients() {
    }

    public Patients(String fullnameInsta, String emailInsta, String phonenumberInsta) {
        this.fullnameInsta=fullnameInsta;
        this.emailInsta=emailInsta;
        this.phonenumberInsta=phonenumberInsta;



    }

    public void createPatient(Map<String, String> map)
    {
           //Patients createNewPatient = new Patients().clickonCreatePatient();
        new Patients().clickonCreatePatient().enterFullName(map).enterEmail(map).enterSsn1(map).enterSsn2(map).enterSsn3(map).enterPhone1(map).enterPhone2(map)
                   .enterPhone3(map).enterInsurance(map).clickonSave();

    }
    private Patients clickonCreatePatient()
    {
        clickOn(createxpath, WAITTECHNIQUES.CLICKABLE, "Create on Patients" );
        return this;
    }
    private Patients enterFullName(Map<String, String> map)
    {
        enterValues(fullname, WAITTECHNIQUES.PRESENCE,map.get("fullname"), "Patient fullName" );
        return this;
    }
    private Patients enterEmail (Map<String, String> map)
    {
        enterValues(email, WAITTECHNIQUES.PRESENCE, map.get("email"), "Patient email");
        return this;
    }
    private Patients enterSsn1( Map<String, String> map)
    {
        enterValues(ssn1, WAITTECHNIQUES.PRESENCE, map.get("ssn1"), "Patient ssn part1");
        return this;
    }
    private Patients enterSsn2(Map<String, String> map)
    {
        enterValues(ssn2, WAITTECHNIQUES.PRESENCE, map.get("ssn2"), "Patient ssn part2");
        return this;
    }
    private Patients enterSsn3 ( Map<String, String> map)
    {
        enterValues(ssn3,WAITTECHNIQUES.PRESENCE, map.get("ssn3"), "Patient ssn part3");
        return this;
    }
    private Patients enterPhone1(Map<String, String> map)
    {
        enterValues(ph1,WAITTECHNIQUES.PRESENCE, map.get("ph1"), "Patient phone part1");
        return this;
    }
    private Patients enterPhone2(Map<String, String> map)
    {
        enterValues(ph2,WAITTECHNIQUES.PRESENCE, map.get("ph2"), "Patient phone part2");
        return this;
    }
    private Patients enterPhone3(Map<String,String> map)
    {
        enterValues(ph3, WAITTECHNIQUES.PRESENCE, map.get("ph3"), "Patient phone part 3");
        return this;

    }
    private Patients enterInsurance(Map<String, String> map)
    {
        enterValues(insuranceprovider, WAITTECHNIQUES.PRESENCE,map.get("insuranceprovider"), "Patients Insurance Provider");
        return this;
    }
    private Patients clickonSave()
    {
        clickOn(save,WAITTECHNIQUES.CLICKABLE, "Click on Saving Patient Information");
        return this;
    }

    public List<String> listofExistingPatients() throws IOException {
        String headerrow = "//table[@class='pr-patientsTable']/tbody/tr";
        String fileURL = Driver.getDriver().getCurrentUrl();
        List<WebElement> allHeadersEle = Driver.getDriver().findElements(By.xpath(headerrow));
        WebElement patientTable = Driver.getDriver().findElement(By.className("pr-patientsTable"));
        System.out.println(patientTable);
        List<WebElement> allHeadersEle2 = patientTable.findElements(By.tagName("tr[2]"));
        System.out.println("Size of allHeadersEl2" + allHeadersEle2.size());
        int rowNum =Driver.getDriver().findElements(By.xpath("//table[@class='pr-patientsTable']//tbody//tr[1]")).size();
        int colNum =Driver.getDriver().findElements(By.xpath("//table[@class='pr-patientsTable']//tbody//tr[1]/td")).size();
        System.out.println("Row= " + rowNum);
        System.out.println("column= " + colNum);

        List<String> allHeaderNames = new ArrayList<String>();
        for (WebElement header : allHeadersEle2) {
            String headerName = header.getText();

            allHeaderNames.add(headerName);
        }


        String source = "<table>" + Driver.getDriver().findElement(patientHeader).getAttribute("innerHTML") + "<table>";
        Document doc = Jsoup.parse(source, "UTF-8");


//        System.out.println(allHeadersEle.size());
//        List<String> allHeaderNames = new ArrayList<String>();
//        for (WebElement header : allHeadersEle) {
//                      String headerName = header.getText();
//
//            allHeaderNames.add(headerName);
//        }
        return allHeaderNames;
    }

    public void findElementsinHeaderTable()
    {
        List<WebElement> listelement= Driver.getDriver().findElements(patientHeader);
        System.out.println(listelement.size() + "= This is the size");
        System.out.println("listofelementsin Header");
        for (WebElement element: listelement)
        {
            String s = element.getText();
            System.out.println(s);
        }
    }


}
