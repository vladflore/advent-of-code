import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;

/**
 * https://adventofcode.com/2020/day/1
 */
public class DayOne {
    public static void main(String[] args) throws URISyntaxException, IOException {

        Path path = Paths.get(Objects.requireNonNull(DayOne.class.getClassLoader().getResource("input.data")).toURI());
        int[] expenseReport = Files.lines(path).mapToInt(Integer::parseInt).toArray();


        int[] solution = new Puzzle(expenseReport, 2020).solve();
        System.out.println(Arrays.toString(solution));
    }
}
