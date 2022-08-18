package main.java.utility;

import main.java.constants.FrameworkConstants;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class DataProviderUtil {
    private DataProviderUtil()
    {

    }
//    @DataProvider
//    public Object[] getData()
//    {
//        Map<String, String> map1 = new HashMap<>();
//        map1.put("username", "seleniumautomation85@gmail.com");
//        map1.put("password", "v2ll2b2n");
//        map1.put("browser", "chrome");
//        Map<String, String> map2 = new HashMap<>();
//        map2.put("username", "sseleniumautojava@gmail.com");
//        map2.put("password", "v2ll2b2n");
//        map2.put("browser", "edge");
//        Object[] obj = new Object [2];
//        obj[0]= map1;
//        obj[1] =map2;
//        return obj;
//    }

    public static List<Map<String, String>> list = new ArrayList<>();

    @DataProvider
    public static Object[] getData(Method m) throws IOException {
        String testname = m.getName();
        System.out.println(testname);
        System.out.println(list.size());
        if (list.isEmpty()) {
            list = ExcelUtil.getTestdetails(FrameworkConstants.getIterationdatasheet());
            System.out.println(list );
        }
        List<Map<String, String>> smalllist = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get("testname").equalsIgnoreCase(testname) &&
                    list.get(i).get("execute").equalsIgnoreCase("yes")) {
                smalllist.add(list.get(i));
            }

        }
        System.out.println(smalllist);
        return smalllist.toArray();
    }
}

