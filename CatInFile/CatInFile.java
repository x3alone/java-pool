import java.io.*;

public class CatInFile {
    public static void cat(String[] args) throws IOException {
                if (args.length !=1) return;
                String filename = args[0];

        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
        }
    }
}