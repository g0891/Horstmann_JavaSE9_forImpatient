import java.io.File;
import java.io.FileFilter;

public class Ch03_11 {
    public static void main(String[] args) {
        File f = new File("./.test/testdir");

        if (!f.exists()) {
            System.out.println("Dir does not exist");
            return;
        }

        System.out.println("Using lambda:");
        File[] filesList_1 = f.listFiles(File::isDirectory);
        printNames(filesList_1);

        System.out.println("Using anonymous class:");
        File[] filesList_2 = f.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
        printNames(filesList_2);
    }

    static private void printNames(File[] files) {
        for (File file: files) {
            System.out.println(file.getName());
        }
    }
}
