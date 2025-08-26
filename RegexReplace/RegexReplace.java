import java.util.regex.*;

public class RegexReplace {

    public static String removeUnits(String s) {
        return s.replaceAll("(\\d+)(cm|€)(?=\\s|$)", "$1");
    }
    public static String obfuscateEmail(String s) {
        String[] parts = s.split("@");
        if (parts.length != 2) return s;

        String username = parts[0];
        String domain = parts[1];

        if (username.matches(".*[._-].*")) {
            username = username.replaceAll("([._-]).", "$1*");
        } else {
            if (username.length() > 3) {
                username = username.substring(0, 3) + "*".repeat(username.length() - 3);
            }
        }
        if (domain.matches("\\w+\\.\\w+\\.\\w+")) {
            Matcher m = Pattern.compile("(\\w+)\\.(\\w+)\\.(\\w+)").matcher(domain);
            if (m.matches()) {
                domain = "*".repeat(m.group(1).length()) + "." + m.group(2) + "." + "*".repeat(m.group(3).length());
            }
        } else if (domain.matches("\\w+\\.\\w+")) {
            Matcher m = Pattern.compile("(\\w+)\\.(\\w+)").matcher(domain);
            if (m.matches()) {
                String second = m.group(1);
                String top = m.group(2);
                if (top.equals("com") || top.equals("org") || top.equals("net")) {
                    domain = "*".repeat(second.length()) + "." + top;
                } else {
                    domain = "*".repeat(second.length()) + "." + "*".repeat(top.length());
                }
            }
        } else {
            domain = "*".repeat(domain.length());
        }

        return username + "@" + domain;
    }
}
