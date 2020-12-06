import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Puzzle {

    private final List<String> groups;

    public Puzzle(String allGroups) {
        groups = Arrays.stream(allGroups.split("\n\n")).collect(Collectors.toList());
    }

    public int[] solve() {
        return new int[]{solvePart1(), solvePart2()};
    }

    private int solvePart1() {
        return groups.stream()
                .map(group -> group.lines().flatMapToInt(String::chars).mapToObj(i -> (char) i).collect(Collectors.toSet()))
                .map(Set::size)
                .reduce(0, Integer::sum);
    }

    private int solvePart2() {
        return groups.stream()
                .map(group -> {
                    List<Set<Character>> sets = group.lines().collect(Collectors.toList())
                            .stream()
                            .map(line -> line.chars().mapToObj(i -> (char) i).collect(Collectors.toSet()))
                            .collect(Collectors.toList());
                    return sets.stream().skip(1).collect(() -> new HashSet<>(sets.get(0)), Set::retainAll, Set::retainAll).size();
                }).reduce(0, Integer::sum);
    }
}
