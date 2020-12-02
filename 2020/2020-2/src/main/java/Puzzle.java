import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Puzzle {

    public static final String POS_1 = "pos1";
    public static final String POS_2 = "pos2";
    public static final String LETTER = "letter";
    public static final String PWD = "pwd";

    private final List<String> db;
    private final Pattern pattern;

    public Puzzle(List<String> db) {
        this.db = db;
        pattern = Pattern.compile("(?<pos1>\\d*)-(?<pos2>\\d*)\\s(?<letter>[a-z]):\\s(?<pwd>[a-z]+)");
    }

    public int[] solve() {
        return new int[]{solvePart1(db), solvePart2(db)};
    }

    private int solvePart1(List<String> db) {
        return Math.toIntExact(db.stream().filter(
                line -> {
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find()) {
                        int pos1 = Integer.parseInt(matcher.group(POS_1));
                        int pos2 = Integer.parseInt(matcher.group(POS_2));
                        char letter = matcher.group(LETTER).charAt(0);
                        String password = matcher.group(PWD);
                        long count = password.chars().filter(ch -> ch == letter).count();
                        return pos1 <= count && count <= pos2;
                    }
                    return false;
                }
        ).count());
    }

    private int solvePart2(List<String> db) {
        return Math.toIntExact(db.stream().filter(
                line -> {
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find()) {
                        int pos1 = Integer.parseInt(matcher.group(POS_1));
                        int pos2 = Integer.parseInt(matcher.group(POS_2));
                        char letter = matcher.group(LETTER).charAt(0);
                        String password = matcher.group(PWD);
                        // TODO we should also check if pos1 and pos2 are valid indices inside the password
                        return password.charAt(pos1 - 1) == letter && password.charAt(pos2 - 1) != letter ||
                                password.charAt(pos1 - 1) != letter && password.charAt(pos2 - 1) == letter;
                    }
                    return false;
                }
        ).count());
    }
}
