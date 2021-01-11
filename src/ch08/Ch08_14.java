package ch08;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Ch08_14 {
    public static void main(String[] args) {

        System.out.println(reduce1(getNewStream()));
        System.out.println(reduce2(getNewStream() ));
        System.out.println(reduce3(getNewStream()));

    }

    public static Stream<ArrayList<Integer>> getNewStream() {
        ArrayList<Integer> arr1 = new ArrayList<>(List.of(1,2,3));
        ArrayList<Integer> arr2 = new ArrayList<>(List.of(7,8,9));
        return Stream.of(null,arr1,null,arr2);
    }

    public static <T> ArrayList<T> reduce1(Stream<ArrayList<T>> stream) {
        return stream.filter(Objects::nonNull).reduce((arr1, arr2) -> {arr1.addAll(arr2); return arr1;}).orElse(null);
    }

    public static <T> ArrayList<T> reduce2(Stream<ArrayList<T>> stream) {
        return stream.filter(Objects::nonNull).reduce(new ArrayList<>(), (arr1, arr2) -> {arr1.addAll(arr2); return arr1;});
    }

    public static <T> ArrayList<T> reduce3(Stream<ArrayList<T>> stream) {
        return stream.filter(Objects::nonNull).parallel().reduce(
                new ArrayList<>(),
                (arrSum, arrFromList) -> {
                    ArrayList<T> arr = new ArrayList<>(arrSum);
                    arr.addAll(arrFromList);
                    return arr;
                    },
                (arrSum1, arrSum2) -> {
                    ArrayList<T> arr = new ArrayList<>(arrSum1);
                    arr.addAll(arrSum2);
                    return arr;
                    }
        );
    }

}
