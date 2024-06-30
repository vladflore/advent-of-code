package tech.vladflore;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Solve_4 {
    public static void main(String[] args) throws URISyntaxException, IOException {
        Solve_4 solve = new Solve_4();
        Path inputFile = Paths.get(
                Objects.requireNonNull(
                        Solve_4.class.getClassLoader().getResource("input4.data")).toURI());
        List<String> content = Files.lines(inputFile).toList();
        System.out.println(solve.solve_part_one(content));
    }

    public long solve_part_one(List<String> pile) {
        long ans = 0;
        Pattern pattern = Pattern.compile("Card\\s+\\d+:(?<winning>.+)\\|(?<mine>.+)");
        for (String card : pile) {
            Matcher matcher = pattern.matcher(card);
            if (matcher.matches()) {
                String winningNumbers = matcher.group("winning").trim();
                String myNumbers = matcher.group("mine").trim();
                Set<Integer> wNumbers = Arrays.stream(winningNumbers.split("\s+")).mapToInt(Integer::valueOf).boxed()
                        .collect(Collectors.toSet());
                Set<Integer> mine = Arrays.stream(myNumbers.split("\s+")).mapToInt(Integer::valueOf).boxed()
                        .collect(Collectors.toSet());
                mine.retainAll(wNumbers);
                ans += Math.pow(2, mine.size()-1);
            }
        }
        return ans;
    }

    public long solve_part_two() {
        return -1;
    }
}