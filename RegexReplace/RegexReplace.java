import java.util.regex.*;

public class RegexReplace {

    public static String removeUnits(String s) {
        return s.replaceAll("(\\d+)(cm|€)(?=\\s|$)", "$1");
    }
    public static String obfuscateEmail(String s) {
        String[] splited = s.split("@");
        if (splited.length != 2)
            return s;

        String username = splited[0];
        String domain = splited[1];

        Pattern specialCharPattern = Pattern.compile("(?=[-._])(.+)");
        Matcher matcher = specialCharPattern.matcher(username);

        if (matcher.find()) {
            username = username.replaceAll("([-._])(.+)", "$1");
            username += "*".repeat(matcher.group().length() - 1);
        } else {
            if (username.length() > 3) {
                username = username.substring(0, 3) + "*".repeat(username.length() - 3);
            }
        }

        specialCharPattern = Pattern.compile("(\\w+)\\.(\\w+)\\.(\\w+)");
        matcher = specialCharPattern.matcher(domain);

        if (matcher.find()) {
            domain = "*".repeat(matcher.group(1).length()) + "." + matcher.group(2) + "."
                    + "*".repeat(matcher.group(3).length());
        }

        specialCharPattern = Pattern.compile("(\\w+)\\.(\\w+)");
        matcher = specialCharPattern.matcher(domain);

        if (matcher.find()) {
            if (matcher.group(2).equals("com") || matcher.group(2).equals("net") || matcher.group(2).equals("org")) {
                domain = "*".repeat(matcher.group(1).length()) + "." + matcher.group(2);
            } else {
                domain = "*".repeat(matcher.group(1).length()) + "." + "*".repeat(matcher.group(2).length());
            }
        }

        return username + "@" + domain;
    }
}
