package ch08;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Ch08_15 {
    public static void main(String[] args) {
        average(List.of(1.0, 2.5, 3.1).stream());
        average(Stream.empty());
    }

    public static void average(Stream<Double> stream) {
        stream.reduce(
                new forDoubleAverage(),
                (fd, item) -> new forDoubleAverage(fd, item, 1),
                (fd1,fd2) -> new forDoubleAverage(fd1, fd2.sum, fd2.count)
        ).average().ifPresentOrElse(
                av -> System.out.println("Average: " + av),
                () -> System.out.println("Empty stream, no average.")
        );
    }

    static class forDoubleAverage{
        double sum;
        long count;
        public forDoubleAverage(){}
        public forDoubleAverage(forDoubleAverage f, double sum, long count) {
            this.sum = f.sum + sum;
            this.count = f.count + count;
        }
        public Optional<Double> average(){ return count == 0 ? Optional.empty() : Optional.of(sum / count);}
    }



}
