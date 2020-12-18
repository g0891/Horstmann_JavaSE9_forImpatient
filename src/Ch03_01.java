public class Ch03_01 {

    public static void main(String[] args) {
        Employee[] employees = new Employee[] {
                new Employee(10),
                new Employee(25)
        };

        System.out.println("The average salary is: " + Measurable.average(employees));
    }

    interface Measurable {
        double getMeasure();

        static double average(Measurable[] objects) {
            if (objects == null || objects.length == 0) return 0;
            double sum = 0;
            for (Measurable item: objects) {
                sum += item.getMeasure();
            }
            return sum / objects.length;
        }
    }

    static class Employee implements Measurable {
        double salary;

        Employee(double salary) {
            this.salary = salary;
        }

        @Override
        public double getMeasure() {
            return salary;
        }
    }

}

