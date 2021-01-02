package ch06;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Ch06_15 {
    public static void main(String[] args) {
        ArrayList<Integer> sourceArr = new ArrayList<>(List.of(1,2,3,4,5));
        ArrayList<Boolean> destArray = map(sourceArr, elem -> elem % 2 == 0);
        System.out.println(destArray);
    }

    public static <T,R> ArrayList<R> map(ArrayList<T> arr, Function<T,R> f) {
        ArrayList<R> newArr = new ArrayList<>();
        for (T elem: arr) {
            newArr.add(f.apply(elem));
        }
        return newArr;
    }
}
