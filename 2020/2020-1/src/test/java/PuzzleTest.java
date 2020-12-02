import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PuzzleTest {

    @ParameterizedTest
    @MethodSource("generateTestData")
    void shouldSolvePuzzle(List<Integer> expenseReport, int totalExpense, List<Integer> expected) {
        int[] actual = new Puzzle(expenseReport.stream().mapToInt(Integer::intValue).toArray(), totalExpense).solve();
        assertArrayEquals(expected.stream().mapToInt(Integer::intValue).toArray(), actual);
    }

    private static Stream<Arguments> generateTestData() {
        return Stream.of(
                arguments(List.of(1, 2, 3, 4, 5, 6), 6, List.of(5, 6)),
                arguments(List.of(1, 2, 3), 6, List.of(0, 6)),
                arguments(List.of(1, 2, 3), 7, List.of(0, 0)),
                arguments(List.of(), Integer.MAX_VALUE, List.of(0, 0))
        );
    }
}
