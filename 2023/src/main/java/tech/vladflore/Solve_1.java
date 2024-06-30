package tech.vladflore;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class Solve_1 {
    public long solve_part_one(List<String> input) {
        long totalCalibration = 0;
        for (String line : input) {
            int currentCalibration;
            int leftToRight = 0;
            int rightToLeft = line.length() - 1;
            boolean goToRight = true;
            boolean goToLeft = true;
            int first = 0, second = 0;
            do {
                if (goToRight && leftToRight < line.length()) {
                    char c1 = line.charAt(leftToRight);
                    if (!Character.isDigit(c1)) {
                        leftToRight++;
                    } else {
                        first = Character.getNumericValue(c1);
                        goToRight = false;
                    }
                }
                if (goToLeft && rightToLeft >= 0) {
                    char c2 = line.charAt(rightToLeft);
                    if (!Character.isDigit(c2)) {
                        rightToLeft--;
                    } else {
                        second = Character.getNumericValue(c2);
                        goToLeft = false;
                    }
                }
                if (leftToRight >= line.length()) {
                    goToRight = false;
                }
                if (rightToLeft < 0) {
                    goToLeft = false;
                }
            } while (goToRight || goToLeft);
            currentCalibration = first * 10 + second;
            totalCalibration += currentCalibration;
        }
        return totalCalibration;
    }

    public long solve_part_two(List<String> input) {
        var map = Map.of(
                "zero", 0,
                "one", 1,
                "two", 2,
                "three", 3,
                "four", 4,
                "five", 5,
                "six", 6,
                "seven", 7,
                "eight", 8,
                "nine", 9
        );
        long totalCalibration = 0;
        var firstWord = new StringBuilder();
        var secondWord = new StringBuilder();
        for (String line : input) {
            int currentCalibration;
            int leftToRight = 0;
            int rightToLeft = line.length() - 1;
            boolean goToRight = true;
            boolean goToLeft = true;
            int firstDigit = 0, secondDigit = 0;
            do {
                if (goToRight && leftToRight < line.length()) {
                    char c1 = line.charAt(leftToRight);
                    if (!Character.isDigit(c1)) {
                        firstWord.append(c1);
                        String digitAsWord = digitAsWord(firstWord, map);
                        if (digitAsWord != null) {
                            firstDigit = map.get(digitAsWord);
                            goToRight = false;
                            firstWord = new StringBuilder();
                        }
                        leftToRight++;
                    } else {
                        firstDigit = Character.getNumericValue(c1);
                        goToRight = false;
                    }
                }
                if (goToLeft && rightToLeft >= 0) {
                    char c2 = line.charAt(rightToLeft);
                    if (!Character.isDigit(c2)) {
                        secondWord.append(c2);
                        StringBuilder secondWordReversed = new StringBuilder(secondWord).reverse();
                        String digitAsWord = digitAsWord(secondWordReversed, map);
                        if (digitAsWord != null) {
                            secondDigit = map.get(digitAsWord);
                            goToLeft = false;
                            secondWord = new StringBuilder();
                        }
                        rightToLeft--;
                    } else {
                        secondDigit = Character.getNumericValue(c2);
                        goToLeft = false;
                    }
                }
                if (leftToRight >= line.length()) {
                    goToRight = false;
                }
                if (rightToLeft < 0) {
                    goToLeft = false;
                }
            } while (goToRight || goToLeft);
            currentCalibration = firstDigit * 10 + secondDigit;
            totalCalibration += currentCalibration;
        }
        return totalCalibration;
    }

    private String digitAsWord(StringBuilder letters, Map<String, Integer> map) {
        for (String numberAsWord : map.keySet()) {
            if (letters.toString().contains(numberAsWord)) {
                return numberAsWord;
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        Solve_1 solve = new Solve_1();
        Path inputFile = Paths.get(
                Objects.requireNonNull(
                        Solve_1.class.getClassLoader().getResource("input1.data")
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
