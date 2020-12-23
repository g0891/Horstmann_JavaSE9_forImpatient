package Ch03;

import java.io.File;
import java.io.FileFilter;

public class Ch03_11 {
    public static void main(String[] args) {
        File dir = new File("./.test/testdir");

        if (!dir.exists()) {
            System.out.println("Dir does not exist");
            return;
        }

        System.out.println("Using lambda:");
        printNames(getDirs_1(dir));

        System.out.println("Using anonymous class:");
        printNames(getDirs_2(dir));
    }



    public static File[] getDirs_1(File dir) {
        return dir.listFiles(File::isDirectory);
    }

    public static File[] getDirs_2(File dir) {
        return dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
    }

    static private void printNames(File[] files) {
        for (File file: files) {
            System.out.println(file.getName());
        }
    }

}
