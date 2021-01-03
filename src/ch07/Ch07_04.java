package ch07;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

public class Ch07_04 {
    public static void main(String[] args) {
        /*
        Do not use to simultaneous iterators over single collection
        if at least one of them modifies the collection.
        */
        List<Integer> list = new ArrayList<>(List.of(1,2,3));
        Iterator<Integer> it1 = list.iterator();
        Iterator<Integer> it2 = list.iterator();
        while (it1.hasNext()) it1.next();
        while (it2.hasNext()) it2.next();
        try {
            it1.remove();
            it2.remove();// error - it2 tries to remove already removed item
        } catch (ConcurrentModificationException ex) {
            System.out.println("Caught ConcurrentModificationException in 1st example");
        }


        /*
        The same exception can be thrown even with one iterator defined if
        the collection is changed externally without iterator.
        Consider the example below.
        */
        List<Integer> listNew = new ArrayList<>(List.of(1,2,3));
        Iterator<Integer> itNew = listNew.iterator();
        while (itNew.hasNext()) itNew.next();
        listNew.remove(list.size() - 1);
        try {
            itNew.remove();
        } catch (ConcurrentModificationException ex) {
            System.out.println("Caught ConcurrentModificationException in 2nd example");
        }

        /*
        Or even exception can be thrown if a single iterator doesn't modify the collection.
        Consider the example below.
         */
        List<Integer> listVeryNew = new ArrayList<>(List.of(1,2,3));
        Iterator<Integer> itVeryNew = listVeryNew.iterator();
        itVeryNew.next();
        itVeryNew.next();
        boolean anythingElseLeft = itVeryNew.hasNext();
        listVeryNew.remove(list.size() - 1);
        try {
            if (anythingElseLeft)
                itVeryNew.next(); //Iterator doesn't try to modify the collection but exception is still thrown
        } catch (ConcurrentModificationException ex) {
            System.out.println("Caught ConcurrentModificationException in 3nd example");
        }

    }
}
