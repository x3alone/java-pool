import java.io.*;

public class CatInFile {
    public static void cat(String[] args) throws IOException {
                if (args.length != 1) return;
        String filename = args[0];

        try (
            InputStream in = System.in;
            OutputStream out = new FileOutputStream(filename)
        ) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }
}