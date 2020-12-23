package ch03;

public class Ch03_02 {
    public static void main(String[] args) {
        Employee[] employees = new Employee[] {
                new Employee("Sam", 10),
                new Employee("John", 25)
        };

        Measurable employee = Measurable.largest(employees);
        System.out.println("The largest salary belongs to: " +
                (employee == null ? "No one" : ((Employee) employee).name)
        );
    }

    interface Measurable {
        double getMeasure();

        static Measurable largest(Measurable[] objects) {
            if (objects == null || objects.length == 0) return null;
            Measurable maxObject = objects[0];
            for (int i = 1; i < objects.length; i++) {
                if (objects[i].getMeasure() > maxObject.getMeasure()) {
                    maxObject = objects[i];
                }
            }
            return maxObject;
        }
    }

    static class Employee implements Measurable {
        String name;
        double salary;

        Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        @Override
        public double getMeasure() {
            return salary;
        }
    }
}

