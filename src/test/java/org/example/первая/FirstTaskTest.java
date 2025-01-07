package org.example.первая;

import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FirstTaskTest {

    @ParameterizedTest
    @MethodSource("args")
    void sol(Arg arg) {
        int c = arg.c();
        List<String> hor = arg.hor();
        String out = arg.out();

        assertEquals(out, Main.sol(c, hor));
    }

    private Stream<Arguments> args() {
        Arguments arguments = Arguments.of(
                new Arg(3, List.of("yan", "d#e", "##x"), "nex"),
                new Arg(2, List.of("c#", "on", "te", "st"), "cots"),
                new Arg(5, List.of("inter", "nship"), "ei")
        );
        return Stream.of(arguments);
    }

    private record Arg(int c, List<String> hor, String out) {

    }

}