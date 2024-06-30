package tech.vladflore;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

record EngineNumber(int number, int row, int colStart, int colEnd) {
}

record PartNumber(int number, Coord symbolCoord, Character symbol) {
}

record Coord(int row, int col) {
}

public class Solve_3 {

    private final List<PartNumber> pNumbers = new ArrayList<>();

    public long solve_part_one(List<String> input) {
        int numRows = input.size();
        int numCols = input.get(0).length();
        Character[][] engine = new Character[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                engine[i][j] = input.get(i).charAt(j);
            }
        }

        String engineNumber = "";
        long answer = 0;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                Character ch = engine[i][j];

                if (Character.isDigit(ch)) {
                    engineNumber += ch;
                    if (j == numCols - 1) {
                        var eNumber = new EngineNumber(Integer.valueOf(engineNumber), i, j - engineNumber.length() + 1,
                                j);
                        var pn = convertToPartNumber(eNumber, engine);
                        if (pn != null) {
                            answer += pn.number();
                            pNumbers.add(pn);
                        }
                        engineNumber = "";
                    }
                } else {
                    if (!engineNumber.isEmpty()) {
                        var eNumber = new EngineNumber(Integer.valueOf(engineNumber), i, j - engineNumber.length(),
                                j - 1);
                        var pn = convertToPartNumber(eNumber, engine);
                        if (pn != null) {
                            answer += eNumber.number();
                            pNumbers.add(pn);
                        }
                    }
                    engineNumber = "";
                }
            }
        }
        return answer;
    }

    private PartNumber convertToPartNumber(EngineNumber engineNumber, Character[][] engine) {
        // row above
        int row = engineNumber.row() - 1;
        if (row >= 0) {
            for (int j = engineNumber.colStart() - 1; j <= engineNumber.colEnd() + 1; j++) {
                if (j < 0 || j > engine[0].length - 1) {
                    continue;
                }
                if (isSymbol(engine[row][j])) {
                    return new PartNumber(engineNumber.number(), new Coord(row, j), engine[row][j]);
                }
            }
        }
        // row
        row = engineNumber.row();
        if (engineNumber.colStart() - 1 >= 0 && isSymbol(engine[row][engineNumber.colStart() - 1])) {
            return new PartNumber(engineNumber.number(), new Coord(row, engineNumber.colStart() - 1),
                    engine[row][engineNumber.colStart() - 1]);
        }
        if (engineNumber.colEnd() + 1 <= engine[0].length - 1 && isSymbol(engine[row][engineNumber.colEnd() + 1])) {
            return new PartNumber(engineNumber.number(), new Coord(row, engineNumber.colEnd() + 1),
                    engine[row][engineNumber.colEnd() + 1]);
        }
        // row below
        row = engineNumber.row() + 1;
        if (row <= engine.length - 1) {
            for (int j = engineNumber.colStart() - 1; j <= engineNumber.colEnd() + 1; j++) {
                if (j < 0 || j > engine[0].length - 1) {
                    continue;
                }
                if (isSymbol(engine[row][j])) {
                    return new PartNumber(engineNumber.number(), new Coord(row, j), engine[row][j]);
                }
            }
        }
        return null;
    }

    private boolean isSymbol(Character c) {
        if (!c.equals('.') && !Character.isDigit(c)) {
            return true;
        }
        return false;
    }

    private boolean isStarSymbol(Character c) {
        return c.equals('*');
    }

    public List<PartNumber> getPartNumbers() {
        return Collections.unmodifiableList(pNumbers);
    }

    public long solve_part_two(List<PartNumber> partNumbers) {
        return partNumbers.stream()
                .filter(pn -> pn.symbol().equals('*'))
                .collect(Collectors.groupingBy(PartNumber::symbolCoord))
                .entrySet().stream()
                .filter(e -> e.getValue().size() == 2)
                .collect(Collectors.toList())
                .stream()
                .map(e -> e.getValue().stream().map(PartNumber::number).reduce(1, (a, b) -> a * b))
                .collect(Collectors.summingInt(Integer::intValue));
    }

    public static void main(String[] args) throws IOException, URISyntaxException {
        Solve_3 solve = new Solve_3();
        Path inputFile = Paths.get(
                Objects.requireNonNull(
                        Solve_3.class.getClassLoader().getResource("input3.data")).toURI());
        List<String> content = Files.lines(inputFile).toList();
        System.out.println(solve.solve_part_one(content));
        var partNumbers = solve.getPartNumbers();
        System.out.println(solve.solve_part_two(partNumbers));
    }
}
