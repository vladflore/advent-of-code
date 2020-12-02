import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Puzzle {

    private final List<String> db;

    public Puzzle(List<String> db) {
        this.db = db;
    }

    public long[] solve() {
        return new long[]{solvePart1(db), solvePart2(db)};
    }

    private long solvePart1(List<String> db) {
        Pattern pattern = Pattern.compile("(?<lo>\\d*)-(?<hi>\\d*)\\s(?<letter>[a-z]):\\s(?<pwd>[a-z]+)");
        return db.stream().filter(
                line -> {
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.find()) {
                        int lo = Integer.parseInt(matcher.group("lo"));
                        int hi = Integer.parseInt(matcher.group("hi"));
                        char letter = matcher.group("letter").charAt(0);
                        String password = matcher.group("pwd");
                        long count = password.chars().filter(ch -> ch == letter).count();
                        return lo <= count && count <= hi;
                    }
                    return false;
                }
        ).count();
    }

    private long solvePart2(List<String> db) {
        //TODO solve me
        return db.size();
    }
}
