import java.sql.SQLOutput;

public class Ch02_04 {
    public static void main(String[] args) {
        IntHolder a = new IntHolder(1);
        IntHolder b = new IntHolder(2);

        System.out.printf("a value: %d, b value: %d\n", a.getValue(), b.getValue());
        swap(a, b);
        System.out.printf("a value: %d, b value: %d\n", a.getValue(), b.getValue());


    }

    private static void swap(IntHolder a, IntHolder b) {
        int tmp = a.getValue();
        a.setValue(b.getValue());
        b.setValue(tmp);
    }

    private static class IntHolder {
        private int value;
        public IntHolder(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public String toString() {
            return Integer.toString(value);
        }
    }
}
