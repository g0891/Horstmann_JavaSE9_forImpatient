package ch07;

import java.util.*;

public class Ch07_02 {
    public static void main(String[] args) {
        ArrayList<String> temp = new ArrayList<>();
        Collections.addAll(temp, "Hello java world!".split(" "));
        ArrayList<String> arr;

        //Iterator
        arr = new ArrayList<>(temp);
        System.out.print(arr + " -> ");
        ListIterator<String> it = arr.listIterator();
        while (it.hasNext()) {
            String s = it.next();
            it.set(s.toUpperCase());
        }
        System.out.println(arr);

        //Cycle
        arr = new ArrayList<>(temp);
        System.out.print(arr + " -> ");
        for (int i = 0; i < arr.size(); i++) {
            arr.set(i, arr.get(i).toUpperCase());
        }
        System.out.println(arr);

        //replaceAll
        arr = new ArrayList<>(temp);
        System.out.print(arr + " -> ");
        arr.replaceAll(str -> str.toUpperCase());
        System.out.println(arr);

    }
}
