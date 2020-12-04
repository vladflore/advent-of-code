import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Puzzle {

    private final List<String> passports;
    private final Set<String> mandatoryPassportKeys = Set.of("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid");

    public Puzzle(String data) {
        passports = Arrays.stream(data.split("\n\n")).collect(Collectors.toList());
    }

    public int[] solve() {
        return new int[]{solvePart1(), solvePart2()};
    }

    private int solvePart1() {
        var validPassports = 0;
        for (var passport : passports) {
            Set<String> keys = Arrays.stream(passport.split("\\s")).map(s -> s.substring(0, s.indexOf(":"))).collect(Collectors.toSet());
            if (keys.containsAll(mandatoryPassportKeys)) {
                validPassports++;
            }
        }
        return validPassports;
    }

    private int solvePart2() {
        var validPassports = 0;
        for (var passport : passports) {
            Set<String> keys = Arrays.stream(passport.split("\\s")).map(s -> s.substring(0, s.indexOf(":"))).collect(Collectors.toSet());
            if (keys.containsAll(mandatoryPassportKeys)) {
                boolean valid = mandatoryPassportKeys.stream().allMatch(key -> {
                    String pattern = ".*" + key + ":" + "(?<keyValue>.*?)(?:$|\\s.*)";
                    Matcher matcher = Pattern.compile(pattern).matcher(passport);
                    if (matcher.find()) {
                        String keyValue = matcher.group("keyValue");
                        return isKeyValueValid(key, keyValue);
                    }
                    return false;
                });
                if (valid) {
                    validPassports++;
                }
            }
        }
        return validPassports;
    }

    private boolean isKeyValueValid(String key, String keyValue) {
        switch (key) {
            case "byr":
                if (keyValue.matches("\\d{4}")) {
                    int year = Integer.parseInt(keyValue);
                    return 1920 <= year && year <= 2002;
                }
                break;
            case "iyr":
                if (keyValue.matches("\\d{4}")) {
                    int year = Integer.parseInt(keyValue);
                    return 2010 <= year && year <= 2020;
                }
                break;
            case "eyr":
                if (keyValue.matches("\\d{4}")) {
                    int year = Integer.parseInt(keyValue);
                    return 2020 <= year && year <= 2030;
                }
                break;
            case "hgt": {
                Pattern p = Pattern.compile("(?<hgtV>\\d+)(?<measurement>(cm|in))");
                Matcher matcher = p.matcher(keyValue);
                if (matcher.find()) {
                    int hgtV = Integer.parseInt(matcher.group("hgtV"));
                    String measurement = matcher.group("measurement");
                    if (measurement.equals("cm")) {
                        return 150 <= hgtV && hgtV <= 193;
                    } else {
                        return 59 <= hgtV && hgtV <= 76;
                    }
                }
                break;
            }
            case "hcl": {
                Pattern p = Pattern.compile("#[0-9a-f]{6}");
                Matcher matcher = p.matcher(keyValue);
                return matcher.find();
            }
            case "ecl": {
                Pattern p = Pattern.compile("(amb|blu|brn|gry|grn|hzl|oth)");
                Matcher matcher = p.matcher(keyValue);
                return matcher.find();
            }
            case "pid": {
                System.out.println(keyValue);
                Pattern p = Pattern.compile("^[0-9]{9}$");
                Matcher matcher = p.matcher(keyValue);
                return matcher.find();
            }
        }
        return false;
    }
}
