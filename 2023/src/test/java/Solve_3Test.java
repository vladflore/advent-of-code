import java.util.Arrays;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import tech.vladflore.Solve_3;

public class Solve_3Test {

    @Test
    void day_two_part_one_1() {
        String input = """
                467..114..
                ...*......
                ..35..633.
                ......#...
                617*......
                .....+.58.
                ..592.....
                ......755.
                ...$.*....
                .664.598..
                """;
        long expected = 4361;
        var solve = new Solve_3();
        long actual = solve.solve_part_one(Arrays.asList(input.split("\n")));
        assert expected == actual : String.format("Expected %d, got %d", expected, actual);
    }

    @Test
    void day_two_part_one_2() {
        String input = """
                ..172..............................454..46
                ............*.........712........=.......*
                .........823.835........%.........710.....
                519+.................13......341..........
                """;
        long expected = 46 + 712 + 823 + 835 + 710 + 519;
        var solve = new Solve_3();
        long actual = solve.solve_part_one(Arrays.asList(input.split("\n")));
        assert expected == actual : String.format("Expected %d, got %d", expected, actual);
    }

    @Test
    void day_two_part_two() {
        String input = """
                467..114..
                ...*......
                ..35..633.
                ......#...
                617*......
                .....+.58.
                ..592.....
                ......755.
                ...$.*....
                .664.598..
                """;
        long expected = 467835;
        var solve = new Solve_3();
        solve.solve_part_one(Arrays.asList(input.split("\n")));
        var actual = solve.solve_part_two(solve.getPartNumbers());
        assert expected == actual : String.format("Expected %d, got %d", expected, actual);
    }
}
