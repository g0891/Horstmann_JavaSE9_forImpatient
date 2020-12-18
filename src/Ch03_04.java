public class Ch03_04 {
    public static void main(String[] args) {
        IntSequence sec = IntSequence.of(1, 2, 3, 4, 5);
        System.out.println("--- sec1 start ---");
        while (sec.hasNext()) System.out.println(sec.next());
        System.out.println("--- sec1 end ---");

        IntSequence sec2 = IntSequence.of();
        System.out.println("--- sec2 start ---");
        while (sec.hasNext()) System.out.println(sec2.next());
        System.out.println("--- sec2 end ---");


    }

    interface IntSequence {
        boolean hasNext();
        int next();

        static IntSequence of(int... numbers) {
            return new IntSequence() {
                int index = 0;

                @Override
                public boolean hasNext() {
                    return index < numbers.length;
                }

                @Override
                public int next() {
                    return numbers[index++];
                }
            };
        }
    }
}
