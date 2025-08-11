public class CleanExtract {
    public static String extract(String s) {
        if (s == null || s.isEmpty()){
            return "";
        }
        String[] items = s.split("\\|");
        StringBuilder res= new StringBuilder(); 
        for ( String item : items){
            String single = item.trim();
            while (single.startsWith(".")){
                single = single.substring(1).trim();
            }

            while (single.endsWith(".")){
                single = single.substring(0, single.length()-1).trim();
            }
            if (single.isEmpty()) continue;
            if (single.substring(1, single.length() - 1).contains(".")) {
                String[] words = single.split("\\s+");
                String lastWord = words[words.length - 1];
                lastWord = lastWord.replaceAll("^\\.+", "");
                single = lastWord.trim();
            }
                if (res.length()>0){
                    res.append(" ");
                }
                res.append(single);
        }
        return res.toString();
    }
}