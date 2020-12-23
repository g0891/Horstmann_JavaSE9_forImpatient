package Ch03;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class Ch03_12 {
    public static void main(String[] args) {
        File dir = new File("./.test/testdir");
        File[] files = getAllFilesWithExtension(dir, "txt");
        for (File file: files) System.out.println(file.getName());
    }

    public static File[] getAllFilesWithExtension(File dir, String extension) {
        String[] ext = new String[] {"." + extension};
        return dir.listFiles((f,s) -> s.endsWith(ext[0]));
    }
}
