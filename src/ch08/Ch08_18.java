package ch08;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Ch08_18 {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,4,4,5,6,7,7,8,9,10,10,11,4);
        noNeighbourDuplicatesStream(list.stream()).forEach(System.out::println);

    }

    public static <T> Stream<T> noNeighbourDuplicatesStream(Stream<T> stream) {
        boolean[] first = new boolean[]{true};
        ArrayList<T> prev = new ArrayList<>();
        return stream.filter(item -> {
            if (first[0]) {
                first[0] = false;
                prev.add(item);
                return true;
            }
            boolean res = prev.get(0) != item;
            prev.set(0, item);
            return res;
        });
    }
}
