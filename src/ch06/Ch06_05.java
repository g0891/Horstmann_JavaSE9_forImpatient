package ch06;

public class Ch06_05 {
    public static void main(String[] args) {
        // 1.5 converts to Double, 2 and 3 converts to Integer.
        // T... requires values to be the objects of the same type.
        // change int values 2 and 3 to 2.0 and 3.0 respectively
        Double[] result = Arrays.swap(0, 1, 1.5, 2.0, 3.0);
    }

    static class Arrays {
        public static <T> T[] swap(int i, int j, T... values) {
            T temp = values[i];
            values[i] = values[j];
            values[j] = temp;
            return values;
        }
    }
}
