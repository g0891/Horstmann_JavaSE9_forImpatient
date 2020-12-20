import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ch01_15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n  = Integer.parseInt(in.nextLine());

        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(List.of(1)));

        for (int i = 0; i < n; i++) {
            ArrayList<Integer> current = new ArrayList<>();
            triangle.add(current);
            current.add(1);
            ArrayList<Integer> previous = triangle.get(i);
            for (int j = 0; j < previous.size() - 1; j++) {
                current.add(previous.get(j) + previous.get(j + 1));
            }
            current.add(1);
        }

        for (int i = 0; i < triangle.size(); i++) {
            System.out.println(triangle.get(i).toString());
        }
    }
}
