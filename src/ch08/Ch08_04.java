package ch08;

import java.util.Optional;
import java.util.stream.Stream;

public class Ch08_04 {
    public static void main(String[] args) {
        Optional<Stream<Long>> streamOptional = createRandomStream(1, 25214903917L, 11L, 1L << 48);
        streamOptional.ifPresent(stream -> stream.limit(10).forEach(System.out::println));
    }

    public static Optional<Stream<Long>> createRandomStream(long seed, long a, long c, long m) {
        if (m == 0) return Optional.empty();
        return Optional.of(Stream.iterate(seed, x -> (a * x + c) % m ));
    }
}
