import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

/**
 * https://adventofcode.com/2019/day/1
 */
public class DayOne {
    public static void main(String[] args) throws IOException, URISyntaxException {
        Path path = Paths.get(Objects.requireNonNull(DayOne.class.getClassLoader().getResource("input.data")).toURI());
        long sum = Files.lines(path).mapToLong(Long::valueOf).map(DayOne::calculateFuel).sum();
        // answer: 4914785
        System.out.println(sum);
    }

    private static long calculateFuel(long mass) {
        long total = 0;
        while (mass > 0) {
            long fuel = Math.floorDiv(mass, 3) - 2;
            if (fuel > 0) {
                total += fuel;
            }
            mass = fuel;
        }
        return total;
    }
}
