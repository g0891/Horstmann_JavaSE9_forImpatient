package ch06;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Ch06_06 {

    public static void main(String[] args) {
        ArrayList<Object> dest = new ArrayList<>(List.of("A", 1, 5.9));
        ArrayList<String> source = new ArrayList<>(List.of("B", "C", "D"));

        append(source, dest);
        append2(source, dest);
        System.out.println(dest.size() == 9);

        //Errors in invocations listed below due to the class hierarchy is not fulfilled
        //append(dest,source);
        //append2(dest,source);

    }

    public static <E> void append(ArrayList<E> source, ArrayList<? super E> destination) {
        destination.addAll(source);
    }

    public static <E> void append2(ArrayList<? extends E> source, ArrayList<E> destination) {
        destination.addAll(source);
    }

}
