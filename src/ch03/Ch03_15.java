package ch03;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Ch03_15 {
    public static void main(String[] args) {
        Employee[] emps = new Employee[] {
                new Employee("Liz", 130),
                new Employee("Ann", 120),
                new Employee("John", 130)
        };

        sort(emps);

        for (int i = 0; i < emps.length; i++) {
            System.out.println(emps[i].getName() + " " + emps[i].getSalary());
        }

        System.out.println("-------");
        sortReverse(emps);

        for (int i = 0; i < emps.length; i++) {
            System.out.println(emps[i].getName() + " " + emps[i].getSalary());
        }

    }

    static class Employee {
        String name;
        double salary;

        Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }
    }

    public static void sort(Employee[] employees) {
        Arrays.sort(employees, Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName));
    }

    public static void sortReverse(Employee[] employees) {
        sort(employees);
        Collections.reverse(Arrays.asList(employees));
    }
}
