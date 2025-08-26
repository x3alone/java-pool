
public class RegexReplace {

    public static String removeUnits(String s) {
        return s.replaceAll("(\\d+)(cm|€)(?=\\s|$)", "$1");
    }

    public static String obfuscateEmail(String s) {
        String[] parts = s.split("@");
        if (parts.length != 2) {
            return s;
        }
        String username = parts[0];
        String domain = parts[1];

        if (username.matches(".*[._-].*")) {
            username = username.replaceAll("([._-]).+", "$1***");
        } else {
            if (username.length() == 4) {
                username = username.substring(0, 3) + "*";
            } else if (username.length() > 4) {
                username = username.substring(0, username.length() - 3) + "***";
            }
        }

        String[] domainParts = domain.split("\\.");
        StringBuilder maskedDomain = new StringBuilder();

        if (domainParts.length == 3) {
            maskedDomain.append("*******");
            maskedDomain.append(".").append(domainParts[1]);
            maskedDomain.append(".").append("***");
        } else if (domainParts.length == 2) {
            String top = domainParts[1];
            if (top.equals("com") || top.equals("org") || top.equals("net")) {
                maskedDomain.append("*******").append(".").append(top);
            } else {
                maskedDomain.append("*******").append(".**");
            }
        } else {
            maskedDomain.append("*******");
        }

        return username + "@" + maskedDomain.toString();
    }
}
