package main.java.utility;

import main.java.constants.FrameworkConstants;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ExcelUtil {
    static List<Map<String , String >> list;
    private ExcelUtil() {
    }
    public static List<Map<String, String >> getTestdetails(String sheetname) throws IOException, IOException {
        FileInputStream fis  = new FileInputStream(FrameworkConstants.getExcelpath());
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetname);
        int rowcount = sheet.getPhysicalNumberOfRows();
        int colmncount = sheet.getRow(0).getLastCellNum();
        list = new ArrayList<>();
        Map <String, String> maps;
        for ( int i=1; i<rowcount; i++) {
            maps = new HashMap<>();
            for ( int j =0; j<colmncount; j++ ){
                String key = sheet.getRow(0).getCell(j).getStringCellValue();
                String value = sheet.getRow(i).getCell(j).getStringCellValue();
                maps.put(key, value);
            }
            list.add(maps);

        }
        return list;
    }
}
