public class StringReplace {
    public static String replace(String s, String target, String replacement) {
        if (s == null) {
            return null;
        }
        return s.replace(target, replacement);
    }
    public static String replace(String s, char target, char replacement) {
        if (s == null) {
            return null;
        }
        return s.replace(target, replacement);
    }
}
