import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class PuzzleTest {

    @ParameterizedTest
    @MethodSource("generateTestData")
    void shouldParseLineCorrectly(List<String> list, List<Integer> expected) {
        int[] actual = new Puzzle(list).solve();
        Assertions.assertArrayEquals(expected.stream().mapToInt(Integer::intValue).toArray(), actual);
    }

    private static Stream<Arguments> generateTestData() {
        return Stream.of(
                arguments(List.of("1-9 x: xwjgxtmrzxzmkx", "4-6 r: rrrkrgr", "15-16 s: bsshsszslssssslqdsss"), List.of(2, 1))
        );
    }
}
