import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ch03_08 {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>(List.of("12", "123", "132"));
        luckySort(al, (s1, s2) -> s1.length() - s2.length());
        for (int i = 0; i < al.size(); i++) {
            System.out.println(al.get(i));
        }
    }

    static void luckySort(ArrayList<String> strings, Comparator<String> comp) {
        outer: while (true) {
            for (int i = 1; i < strings.size(); i++) {
                if (comp.compare(strings.get(i - 1), strings.get(i)) > 0) {
                    break outer;
                }
            }
            Collections.shuffle(strings);
        }
    }
}
