import java.util.Arrays;

import org.junit.jupiter.api.Test;

import tech.vladflore.Solve_2;

public class Solve_2Test {

    @Test
    void part_one() {
        String input = """
                Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
                Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
                Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
                Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
                Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
                """;
        long expected = 8;
        Solve_2 solve = new Solve_2();
        long actual = solve.solve_part_one(Arrays.asList(input.split("\n")));
        assert expected == actual : String.format("Expected %d, got %d", expected, actual);
    }

    @Test
    void part_two() {
        String input = """
                Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
                Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
                Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
                Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
                Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
                """;
        long expected = 2286;
        Solve_2 solve = new Solve_2();
        long actual = solve.solve_part_two(Arrays.asList(input.split("\n")));
        assert expected == actual : String.format("Expected %d, got %d", expected, actual);
    }
}
