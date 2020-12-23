package Ch01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ch01_14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<ArrayList<Integer>> box = new ArrayList<>();
        String s;

        while (!"".equals(s = in.nextLine().trim())) {
            String[] nums = s.split("\\s+");
            ArrayList<Integer> row = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                row.add(Integer.valueOf(nums[i]));
            }
            box.add(row);
        }

        int dim = box.size();
        for (ArrayList<Integer> row : box) {
            if (row.size() != dim) {
                System.out.println("Incorrect dimensions!");
                return;
            }
        }

        int sum = box.get(0).stream().mapToInt(Integer::intValue).sum();
        int tsum;

        for (int i = 0; i < dim; i++) {
            tsum = 0;
            for (int j = 0; j < dim; j++) {
                tsum += box.get(i).get(j).intValue();
            }
            if (sum != tsum) {
                System.out.println("Not a magic box!");
                return;
            }
        }

        for (int i = 0; i < dim; i++) {
            tsum = 0;
            for (int j = 0; j < dim; j++) {
                tsum += box.get(j).get(i).intValue();
            }
            if (sum != tsum) {
                System.out.println("Not a magic box!");
                return;
            }
        }


        tsum = 0;
        for (int j = 0; j < dim; j++) {
            tsum += box.get(j).get(j).intValue();
        }
        if (sum != tsum) {
            System.out.println("Not a magic box!");
            return;
        }

        tsum = 0;
        for (int j = 0; j < dim; j++) {
            tsum += box.get(dim - 1 - j).get(j).intValue();
        }
        if (sum != tsum) {
            System.out.println("Not a magic box!");
            return;
        }

        System.out.println("Magic box!");

    }
}
