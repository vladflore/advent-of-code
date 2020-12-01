import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * https://adventofcode.com/2020/day/1
 */
public class DayOne {
    public static void main(String[] args) throws URISyntaxException, IOException {
        long ans = solve();
        System.out.println(ans);
    }

    private static long solve() throws URISyntaxException, IOException {
        Path path = Paths.get(Objects.requireNonNull(DayOne.class.getClassLoader().getResource("input.data")).toURI());
        List<Integer> expenseReport = Files.lines(path).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        for (int i = 0; i < expenseReport.size() - 1; i++) {
            for (int j = i + 1; j < expenseReport.size(); j++) {
                if (expenseReport.get(i) + expenseReport.get(j) == 2020) {
                    return expenseReport.get(i) * expenseReport.get(j);
                }
            }
        }
        return -1;
    }
}
