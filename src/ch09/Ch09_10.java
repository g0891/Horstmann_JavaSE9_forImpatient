package ch09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Ch09_10 {
    public static void main(String[] args) {
        String s = "1+23asdas-12.as3+78as2.09d"; //1 23 -12 3 78 2 9
        ArrayList<Integer> list;

        list = Pattern.compile("[+-]?\\d+")
                .matcher(s)
                .results()
                .map(MatchResult::group)
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println(list.toString());

    }



}
