import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Cat {
    public static void cat(String[] args) throws IOException {
        if (args.length == 0) return ;

        byte[] res = Files.readAllBytes(Paths.get(args[0]));
        System.out.write(res);
    }
}