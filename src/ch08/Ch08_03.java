package ch08;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ch08_03 {
    public static void main(String[] args) {
        int[] values = new int[] {1,4,9,16};
        // There will be one element - the array of int, cause Stream.of method requires either object or varargs of objects.
        // int[] is an object and int elements of it are not.
        // Thus the stream will contain only one item.
        System.out.println("Number of elements: " + Stream.of(values).count());

        //IntStream.of is another story. It deals with int items.
        System.out.println("Number of elements: " + IntStream.of(values).count());



    }
}
