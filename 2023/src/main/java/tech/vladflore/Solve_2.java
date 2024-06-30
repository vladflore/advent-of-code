package tech.vladflore;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Solve_2 {
    public long solve_part_one(List<String> input) {
        int maxRed = 12, maxGreen = 13, maxBlue = 14;
        String valueColorPattern = "(\\d+)\\s(\\w+)";
        String gameNumberPattern = "Game (\\d+):";
        Pattern gnp = Pattern.compile(gameNumberPattern);
        Pattern vcp = Pattern.compile(valueColorPattern);
        long answer = 0;
        for (String line : input) {
            boolean process = true;
            Matcher m = vcp.matcher(line);
            while (m.find() && process) {
                int value = Integer.parseInt(m.group(1));
                String color = m.group(2);
                switch (color) {
                    case "red":
                        if (value > maxRed) {
                            process = false;
                        }
                    case "green":
                        if (value > maxGreen) {
                            process = false;
                        }
                    case "blue":
                        if (value > maxBlue) {
                            process = false;
                        }
                }
            }
            if (process) {
                m = gnp.matcher(line);
                if (m.find()) {
                    answer += Integer.parseInt(m.group(1));
                }
            }
        }
        return answer;
    }

    public long solve_part_two(List<String> input) {
        String valueColorPattern = "(\\d+)\\s(\\w+)";
        Pattern vcp = Pattern.compile(valueColorPattern);
        long answer = 0;
        for (String line : input) {
            int maxRed = 0, maxGreen = 0, maxBlue = 0;
            Matcher m = vcp.matcher(line);
            while (m.find()) {
                int value = Integer.parseInt(m.group(1));
                String color = m.group(2);
                switch (color) {
                    case "red":
                        if (value > maxRed) {
                            maxRed = value;
                        }
                        break;
                    case "green":
                        if (value > maxGreen) {
                            maxGreen = value;
                        }
                        break;
                    case "blue":
                        if (value > maxBlue) {
                            maxBlue = value;
                        }
                }
            }
            answer += (long) maxRed * maxGreen * maxBlue;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        Solve_2 solve = new Solve_2();
        Path inputFile = Paths.get(
                Objects.requireNonNull(
                        Solve_2.class.getClassLoader().getResource("input2.data")
                ).toURI()
        );
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
