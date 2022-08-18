package main.java.listeners;

import lombok.SneakyThrows;
import main.java.utility.ExcelUtil;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MethodInterceptorClass implements IMethodInterceptor {
    @SneakyThrows
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        List<Map<String, String>> list = ExcelUtil.getTestdetails("runnermanager");
        List<IMethodInstance> result = new ArrayList<>();
        for (int i=0; i<methods.size(); i++){
            for(int j=0; j<list.size(); j++){
                if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("testname"))){
                    if(list.get(j).get("execute").equalsIgnoreCase("yes")) {
                        methods.get(i).getMethod().setDescription(list.get(j).get("testdescription"));
                        methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("count")));
                        methods.get(i).getMethod().setPriority(Integer.parseInt(list.get(j).get("priority")));
                        result.add(methods.get(i));
                    }
                }
            }
        }
        System.out.println(result.get(0));
        return result;
    }
}

