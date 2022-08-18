package main.java.utility;

public class StringArraytoString {
    public static String convertStringarraytoString(String[] string)
    {
        String returnstring = new String();
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < string.length; i++) {
            returnstring =sb.append(string[i]).toString();
        }
        return  returnstring;
    }
}
