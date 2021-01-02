package ch06;

public class Ch06_17 {
    public static void main(String[] args) {
        Employee e1 = new Employee(10, "John");
        Employee e2 = new Employee(20, "Sam");
        System.out.println("Employee with the least salary is " + (e1.compareTo(e2) < 0 ? e1.name : e2.name));
    }

    public static class Employee implements Comparable<Employee> {
        int salary;
        String name;
        public Employee(int salary, String name) {
            this.salary = salary;
            this.name = name;
        }
        @Override
        public int compareTo(Employee obj) {
            return salary - obj.salary;
        }
    }
}
