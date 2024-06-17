package tech.vladflore;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Solve_3 {
    public long solve_part_one(List<String> input) {
        return 0L;
    }

    public long solve_part_two(List<String> input) {
        return 0L;
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        Solve_3 solve = new Solve_3();
        Path inputFile = Paths.get(
                Objects.requireNonNull(
                        Solve_2.class.getClassLoader().getResource("input3.data")).toURI());
        try (Stream<String> lines = Files.lines(inputFile)) {
            long result = solve.solve_part_one(lines.toList());
            System.out.println(result);
        }
        try (Stream<String> lines = Files.lines(inputFile)) {
            long result = solve.solve_part_two(lines.toList());
            System.out.println(result);
        }
    }
}
