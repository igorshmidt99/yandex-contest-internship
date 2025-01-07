package org.example.вторая;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MainTest {

    @ParameterizedTest
    @MethodSource("args")
    void sol(Arg arg) {
        assertEquals(arg.out, Main.sol(arg.p, arg.b));
    }

    private Stream<Arguments> args() {
        Arguments arguments = Arguments.of(
                new Arg(List.of(5, 4, 3, 2, 1), 2, 2),
                new Arg(List.of(3, 6, 5, 4, 2, 1), 3, 1),
                new Arg(List.of(5, 7, 2, 4, 3, 1, 6), 4, 4)
        );
        return Stream.of(arguments);
    }

    private record Arg(List<Integer> p, long b, int out) {

    }
}