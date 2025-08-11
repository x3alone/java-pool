public class CleanExtract {

    public static String extract(String s) {
        String[] res = s.split("\\|");
        StringBuilder name = new StringBuilder();
        for (String single : res) {
            String Item;
            int start = single.indexOf(".");
            int end = single.lastIndexOf(".");
            if (start > -1) {
                if (start == end) {
                    Item = single.substring(start + 1);
                } else {
                    Item = single.substring(start + 1, end);
                }
            } else {
                Item = single;
            }

            Item = Item.trim();
            if (!Item.isEmpty()) {
                if (name.length() > 0) {
                    name.append(" ");
                }
                name.append(Item);
            }
        }

        return name.toString();
    }
}