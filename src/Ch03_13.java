import java.io.File;
import java.util.Arrays;

public class Ch03_13 {
    public static void main(String[] args) {
        File[] files = new File[] {
                new File("./.test/testdir/1.txt"),
                new File("./.test/testdir/subdir2"),
                new File("./.test/testdir/subdir1"),
                new File("./.test/testdir/2.txt"),
                new File("./.test/testdir")
        };

        sortFiles(files);

        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i].getPath());
        }
    }

    public static void sortFiles(File[] files) {
        Arrays.sort(files, (f1, f2) -> {
            if (f1.isDirectory() && !f2.isDirectory()) {
                return -1;
            } else if (!f1.isDirectory() && f2.isDirectory()) {
                return 1;
            } else {
                return f1.getPath().compareTo(f2.getPath());
            }
        });
    }
}
