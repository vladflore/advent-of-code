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
    void shouldSolvePuzzle(List<Integer> expenseReport, int totalExpense, List<Long> expected) {
        long[] actual = new Puzzle(expenseReport.stream().mapToInt(Integer::intValue).toArray(), totalExpense).solve();
        Assertions.assertArrayEquals(expected.stream().mapToLong(Long::longValue).toArray(), actual);
    }

    private static Stream<Arguments> generateTestData() {
        return Stream.of(
                arguments(List.of(1, 2, 3, 4, 5, 6), 6, List.of(5L, 6L)),
                arguments(List.of(1, 2, 3), 6, List.of(0L, 6L)),
                arguments(List.of(1, 2, 3), 7, List.of(0L, 0L)),
                arguments(List.of(), Integer.MAX_VALUE, List.of(0L, 0L))
        );
    }
}
