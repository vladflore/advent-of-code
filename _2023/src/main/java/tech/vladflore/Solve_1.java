package tech.vladflore;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class Solve_1 {
    public long solve_part_one(List<String> input) {
        // TODO: implement
        return 0;
    }

    public long solve_part_two(String input) {
        return 0;
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        List<String> content = Files.lines(
                Paths.get(
                        Objects.requireNonNull(
                                Solve_1.class.getClassLoader().getResource("input.data")
                        ).toURI()
                )).toList();
        Solve_1 solve = new Solve_1();
        long result = solve.solve_part_one(content);
        System.out.println(result);
    }
}
