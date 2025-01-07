package org.example.третья;

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
        assertEquals(arg.out, Main.sol(arg.a, arg.b, arg.c));
    }

    private Stream<Arguments> args() {
        Arguments arguments = Arguments.of(
                new Arg(List.of(7, 6, 1, 2, 3, 4, 5),
                        List.of(7, 4, 3, 1, 1, 5, 5),
                        List.of(2, 6, 5, 4, 1, 7, 3), 4),

                new Arg(List.of(7, 4, 2, 6, 8, 9, 5, 3, 1),
                        List.of(7, 4, 3, 9, 4, 6, 5, 1, 2),
                        List.of(7, 8, 2, 6, 8, 9, 1, 5, 3), 2)
        );
        return Stream.of(arguments);
    }

    private record Arg(List<Integer> a, List<Integer> b, List<Integer> c, int out) {

    }
}