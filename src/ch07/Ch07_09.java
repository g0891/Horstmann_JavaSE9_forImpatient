package ch07;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Ch07_09 {
    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap<>();
        String[] words = new String[] {"one","two","one","three"};

        //1
        Arrays.stream(words).forEach(word -> map.merge(word, 1, Integer::sum));
        System.out.println(map);
        map.clear();

        //2
        Arrays.stream(words).forEach(word -> map.put(word, map.containsKey(word) ? map.get(word) + 1 : 1));
        System.out.println(map);
        map.clear();

        //3
        Arrays.stream(words).forEach(word -> {Integer n = map.get(word); map.put(word, n == null ? 1 : n + 1);});
        System.out.println(map);
        map.clear();

        //4
        Arrays.stream(words).forEach(word -> map.put(word, map.getOrDefault(word, 0) + 1));
        System.out.println(map);
        map.clear();

        //5
        Arrays.stream(words).forEach(word -> {Integer n = map.putIfAbsent(word,1); if (n != null) map.put(word, n + 1);} );
        System.out.println(map);
        map.clear();
    }
}
