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

        ints[1] = 12;
        ints[2] = 2;

        int idx = 0;
        int opcode = ints[idx];
        while (opcode != 99) {
            if (opcode == 1) {
                ints[ints[idx + 3]] = ints[ints[idx + 1]] + ints[ints[idx + 2]];
            } else if (opcode == 2) {
                ints[ints[idx + 3]] = ints[ints[idx + 1]] * ints[ints[idx + 2]];
            }
            idx += 4;
            opcode=ints[idx];
        }

        scanner.close();
        System.out.println(ints[0]);
    }
}
