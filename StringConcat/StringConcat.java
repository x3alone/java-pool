public class StringConcat {
    public static String concat(String s1, String s2) {
        if (s1 == null){
            s1 = "";
        }
        if (s2 == null){
            s2 = "";
        }
        if (s2 == null && s1 == null){
            return null;
        }
        return s1 + s2;
        }
}