import java.io.*;

public class Capitalize {
    public static void capitalize(String[] args) throws IOException {
        if (args == null || args.length != 2) {
            return;
        }
        FileReader in = new FileReader(args[0]);
        FileWriter out = new FileWriter(args[1]);
        String res = "";
        String result = "";
        char[] buffer = new char[1];
        int n;
        while((n = in.read(buffer, 0, 1)) > 0) {
            res += new String(buffer);
        }
        String[] arr = res.split(" ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i].strip().toLowerCase();
            if (arr[i].length() == 0) {
                continue;
            }
            result += arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1);
            if (i+1 < arr.length) {
                result += " ";
            }
        }
        out.write(result);
        in.close();
        out.close();
    }
}