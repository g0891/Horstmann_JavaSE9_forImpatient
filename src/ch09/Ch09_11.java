package ch09;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Ch09_11 {
    public static void main(String[] args) {
        String s = "/home/cay/myfile.txt";
        String[] arr = Pattern.compile("(?<=/)[^/]+(?=/)").matcher(s).results().map(res -> res.group()).toArray(String[]::new);
        System.out.println(Arrays.toString(arr));

    }
}
