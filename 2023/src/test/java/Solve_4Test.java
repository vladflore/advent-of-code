import java.util.Arrays;

import org.junit.jupiter.api.Test;

import tech.vladflore.Solve_4;

public class Solve_4Test {

    @Test
    void part_one() {
        String input = """
                """;
        long expected = 0;
        var solve = new Solve_4();
        long actual = solve.solve_part_one(Arrays.asList(input.split("\n")));
        assert expected == actual : String.format("Expected %d, got %d", expected, actual);
    }

    @Test
    void part_two() {
        String input = """
                """;
        long expected = 0;
        var solve = new Solve_4();
        var actual = solve.solve_part_two();
        assert expected == actual : String.format("Expected %d, got %d", expected, actual);
    }
}
