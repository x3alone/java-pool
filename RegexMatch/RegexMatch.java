import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatch {
    public static boolean containsOnlyAlpha(String s) {
        return s.matches("^[a-zA-Z]+$");
    }
    
    public static boolean startWithLetterAndEndWithNumber(String s) {
        return s.matches("^[a-zA-Z].*[0-9]$");
    }
    
    public static boolean containsAtLeast3SuccessiveA(String s) {
Pattern p = Pattern.compile("A{3,}");
        Matcher m = p.matcher(s);
        return m.find();    }
}