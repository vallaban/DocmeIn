package main.java.testcasesteps;
public class TestcaseDescriptions {
    public static String[] getTestcase(String testcaseName) {
        if(testcaseName== "loginTestcase")
        {return loginTestcase;
        }
        else if(testcaseName== "createPatienttestcase"){
            return createPatienttestcase;
        }else
            return blank;
    }

    private static String[] loginTestcase = {"Username can be entered;", "password can be entered;","click on submit to login."};

    private static String[] createPatienttestcase = {"After login > Homepage> Patients> Create;",
            "Enter Patient Infor like \"Fullname\",\"email\",\"ssn\",\"phonno\",\"insuranceinfo\"","click on save to create a patient"};
    private static String[] blank= {"No testcase"};
}
