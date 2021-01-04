package ch07;

import java.util.*;

public class Ch07_05 {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>(List.of(0,1,2,3,4,5,6,7));
        swap(list, 2, 7);
        System.out.println(list);
    }

    public static void swap(List<?> list, int i, int j) {
        if (i == j) return;
        if (list instanceof RandomAccess) swapHelperRandom(list, i, j);
        else swapHelperNonRandom(list, i, j);
    }

    /*
    * The main idea is to iterate from the beginning of list till the element with the lowest index.
    * Then remember the element (tmpMin) and iterate further to the element with the highest index.
    * Then remember that element (tmpMax) and place instead of it previously remembered (tmpMin) into the list.
    * Then it's time to decide if it is faster to go backwards with the current iterator or just to create a new one
    * to go from the very beginning of the list.
    * Then go to the element with the lowest position and replace it (with tmpMax).
    *
    * Going back and forward is possible while using ListIterator for List collection.
    *
    * Algorithm could be further improved for LinkedList cause it stores reference to the last element.
    * So it is possible to start iterating form the end (if the element is closer to the end then to the beginning).
    * But List and ListIterator interfaces doesn't obligate implementations to store reference to the last element.
    * So jumping to the end might not be possible but only iterating from the very beginning in some implementations
    * of mentioned interfaces.
    * */
    private static <T> void swapHelperRandom(List<T> list, int i, int j) {
        T tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

    private static <T> void swapHelperNonRandom(List<T> list, int i, int j) {
        int min = Math.min(i,j);
        int max = Math.max(i,j);
        ListIterator<T> it = list.listIterator(min);
        T tmpMin = it.next();

        for (int k = 0; k < max - min - 1; k++) {
            it.next();
        }
        T tmpMax = it.next();
        it.set(tmpMin);
        if (max - min < min) {
            //System.out.println("Moving back");
            for (int k = 0; k < max - min + 1; k++) {
                it.previous();
            }
        } else {
            //System.out.println("New iterator");
            it = list.listIterator(min);
            it.next();
        }
        it.set(tmpMax);

    }
}
