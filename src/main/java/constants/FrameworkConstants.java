package main.java.constants;
import main.java.enums.BROWSERS;
import java.util.Objects;

public class FrameworkConstants {
    private static final String HOMEPATH =System.getProperty("user.dir");
    private static final String TESTCOMPATH = HOMEPATH+"\\src\\test\\";
    private static final String MAINCOMPATH=HOMEPATH+"\\src\\main\\";
    private static final String EXCELPATH=MAINCOMPATH+"\\resources\\ExcelFiles\\ExcelFiles.xlsx";
    private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir")+"\\extent-test-output\\";
    private static String EXTENTRPEORTFILEPATH ="";
    private static final String RUNNEREXCELLSHEET = "runnermanager";
    private static final String ITERATIONDATASHEET= "datas";
    public static String getEXTENTRPEORTFILEPATH()
    {
        EXTENTRPEORTFILEPATH = createReportPath();
        return EXTENTRPEORTFILEPATH;

    }
    public static String getValueofBrowser(BROWSERS browsers) throws Exception {
        if(Objects.isNull(browsers)){
            throw new Exception("Provided Browser value is "+browsers+" is not valid, Please checkagain");

    } else {
            return browsers.name().toLowerCase();
        }
    }
    public static String getRunnerexcellsheet()
    {
        return RUNNEREXCELLSHEET;
    }
    public static String getIterationdatasheet()
    {
        return ITERATIONDATASHEET;
    }
    public static String getTestcompath()
    {
        return TESTCOMPATH;
    }
    public static String getExcelpath()
    {
        return EXCELPATH;
    }
    private static String createReportPath()
    {
        return EXTENTREPORTFOLDERPATH+System.currentTimeMillis()+"\\index.html";
    }


}
