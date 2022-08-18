package test.java.rough;
import io.opentelemetry.sdk.trace.SpanLimits;

import java.io.File;
import java.io.IOException;
public class TestMain {
    public static void main(String[] args) throws IOException {
      String name = "aidia";
      String temp="";
      String reversedString="";
      String result="";
        System.out.println(name.toCharArray());

        for ( int i =(name.length()-1); i>=0; i--)
      {
        temp+=name.charAt(i);
          reversedString=temp;




      }

        System.out.println("name " + name);
        System.out.println("reversedString "+ reversedString);
        System.out.println(name==reversedString);
        result = (name.equalsIgnoreCase(reversedString)) ? "Palindrom" : "not palindrom";

        //String result =  (a==b)? "same": "notsame";

        System.out.println(result);

    }
}
