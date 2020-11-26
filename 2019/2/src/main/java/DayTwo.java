import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/**
 * https://adventofcode.com/2019/day/2
 */
public class DayTwo {
    public static void main(String[] args) throws IOException, URISyntaxException {
        Path path = Paths.get(Objects.requireNonNull(DayTwo.class.getClassLoader().getResource("input.data")).toURI());
        Scanner scanner = new Scanner(path);
        int[] ints = Arrays.stream(scanner.nextLine().split(","))
                .mapToInt(Integer::valueOf)
                .toArray();
        System.out.println(Arrays.toString(ints));
    }
}
