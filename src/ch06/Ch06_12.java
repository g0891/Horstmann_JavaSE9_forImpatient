package ch06;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ch06_12 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(1,5,6,7,-10));
        ArrayList<Number> numbers = new ArrayList<>();
        maxmin(list, (a,b) -> a - b, numbers);
        System.out.println(numbers.get(0).intValue());
        System.out.println(numbers.get(1).intValue());
    }

    public static <T> void maxmin(List<T> elements, Comparator<? super T> comp, List<? super T> result) {
        if (elements == null || elements.size() == 0) return;
        T min = elements.get(0);
        T max = elements.get(0);
        for (T elem: elements) {
            if (comp.compare(elem, min) < 0) {
                min = elem;
            } else if (comp.compare(elem, max) > 0) {
                max = elem;
            }
        }
        result.add(min);
        result.add(max);
    }
}
