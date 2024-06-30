package tech.vladflore;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class Solve_4 {
    public static void main(String[] args) throws URISyntaxException, IOException {
        Solve_4 solve = new Solve_4();
        Path inputFile = Paths.get(
                Objects.requireNonNull(
                        Solve_4.class.getClassLoader().getResource("input4.data")).toURI());
        List<String> content = Files.lines(inputFile).toList();
        System.out.println(solve.solve_part_one(content));
    }

    public long solve_part_one(List<String> content) {
        return -1;
    }

    public long solve_part_two() {
        return -1;
    }
}