import java.util.Arrays;

import org.junit.jupiter.api.Test;

import tech.vladflore.Solve_1;

public class Solve_1Test {

    @Test
    void part_one() {
        String input = """
                1abc2
                pqr3stu8vwx
                a1b2c3d4e5f
                treb7uchet
                """;
        long expected = 142;
        Solve_1 solve = new Solve_1();
        long actual = solve.solve_part_one(Arrays.asList(input.split("\n")));
        assert expected == actual : String.format("Expected %d, got %d", expected, actual);
    }

    @Test
    void part_two() {
        String input = """
                two1nine
                eightwothree
                abcone2threexyz
                xtwone3four
                4nineeightseven2
                zoneight234
                7pqrstsixteen
                """;
        long expected = 281;
        Solve_1 solve = new Solve_1();
        long actual = solve.solve_part_two(Arrays.asList(input.split("\n")));
        assert expected == actual : String.format("Expected %d, got %d", expected, actual);
    }
}
