import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;

public class DayFour {
    public static void main(String[] args) throws URISyntaxException, IOException {
        Path path = Paths.get(Objects.requireNonNull(DayFour.class.getClassLoader().getResource("input.data")).toURI());

        int[] solution = new Puzzle(Files.readString(path)).solve();
        System.out.println(Arrays.toString(solution));

        //answer: [228, 175]
    }
}
