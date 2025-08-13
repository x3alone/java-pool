import java.io.File;

public class FileSearch {
    public static String searchFile(String fileName) {
        return search(new File("documents"), fileName);
    }

    public static String search(File folder, String fileName) {
        File[] files = folder.listFiles();
        if (files == null) return null;

        for (int i = 0; i < files.length; i++) {
            File f = files[i];
            if (f.isFile() && f.getName().equals(fileName)) {
                return f.getPath();
            }
            if (f.isDirectory()) {
                String found = search(f, fileName);
                if (found != null) return found;
            }
        }
        return null;
    }
}

