package ch07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ch07_17 {
    public static void main(String[] args) {
        List<String> listString = new ArrayList<>(List.of("s1", "s2"));
        List<Integer> listInteger = (List<Integer>)(Object)listString;
        listInteger.add(123);
        System.out.println("Wow! It is possible to add Integer to String list!");
        try {
            Integer i = listInteger.get(0);
            /* String s = listInteger.get(3); // will not compile cause the compiler sees we are trying to get Integer into String variable */
        } catch (ClassCastException ex) {
            System.out.println("But it leads to errors when we try to get stored string as an Integer.");
        }

        List<String> listString2 = Collections.checkedList(new ArrayList<>(List.of("s1", "s2")), String.class);
        List<Integer> listInteger2 = (List<Integer>)(Object)listString2;
        try {
            listInteger2.add(123);
        } catch (ClassCastException ex) {
            System.out.println("Meanwhile in the checked collection it is not possible to add value of a wrong type.");
        }

    }

}
