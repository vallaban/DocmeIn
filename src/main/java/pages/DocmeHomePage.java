package main.java.pages;

import main.java.enums.WAITTECHNIQUES;
import org.openqa.selenium.By;

import java.util.Scanner;

public class DocmeHomePage extends BasePage{
    private Patients patients = new Patients();;
    private final By patientslink = By.xpath("//a[normalize-space()='PATIENTS']");
    public Patients clickonPatient()
    {

        clickOn(patientslink, WAITTECHNIQUES.CLICKABLE,"patienthyperlink in Homepage");
        return patients;
        
    }
}
