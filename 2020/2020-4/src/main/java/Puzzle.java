import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Puzzle {

    private final List<String> allPassports;
    private final List<String> mandatoryKeys = List.of("byr:", "iyr:", "eyr:", "hgt:", "hcl:", "ecl:", "pid:");

    public Puzzle(String content) {
        allPassports = Arrays.stream(content.split("\n\n")).collect(Collectors.toList());
    }

    public int[] solve() {
        return new int[]{solvePart1(), solvePart2()};
    }

    private int solvePart1() {
        var validPassports = 0;
        for (var passport : allPassports) {
            var presentKeys = 0;
            for (String key : mandatoryKeys) {
                if (passport.contains(key)) {
                    presentKeys++;
                }
            }
            if (presentKeys == 7) {
                validPassports++;
            }
        }
        return validPassports;
    }

    private int solvePart2() {
        var validPassports = 0;
        for (var passport : allPassports) {
            var presentKeys = 0;
            for (String key : mandatoryKeys) {
                if (passport.contains(key)) {
                    presentKeys++;
                }
            }
            if (presentKeys == 7) {
                if (hasValidValues(passport)) {
                    validPassports++;
                } else {
                    System.out.println("Passport invalid");
                }
            }
        }
        return validPassports;
    }

    private boolean hasValidValues(String passport) {
        System.out.println("===========================================================================");
        List<String> passportLines = passport.lines().collect(Collectors.toList());

        for (var passportLine : passportLines) {
            System.out.println(">>> " + passportLine);
            for (var key : mandatoryKeys) {
                String pattern = ".*" + key + "(?<keyValue>.+?)\\s.*";
                Matcher matcher = Pattern.compile(pattern).matcher(passportLine.concat(" "));
                if (matcher.find()) {
                    String value = matcher.group("keyValue");
                    boolean valid = isKeyValueValid(key, value);
                    System.out.println(key + " " + value + " " + valid);
                    if (!valid) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    private boolean isKeyValueValid(String key, String keyValue) {
        switch (key) {
            case "byr:":
                if (keyValue.matches("\\d{4}")) {
                    int year = Integer.parseInt(keyValue);
                    return 1920 <= year && year <= 2002;
                }
                break;
            case "iyr:":
                if (keyValue.matches("\\d{4}")) {
                    int year = Integer.parseInt(keyValue);
                    return 2010 <= year && year <= 2020;
                }
                break;
            case "eyr:":
                if (keyValue.matches("\\d{4}")) {
                    int year = Integer.parseInt(keyValue);
                    return 2020 <= year && year <= 2030;
                }
                break;
            case "hgt:": {
                Pattern p = Pattern.compile("(?<hgtV>\\d{2,3})(?<measurement>(cm|in))");
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
            case "hcl:": {
                Pattern p = Pattern.compile("#[0-9a-f]{6}");
                Matcher matcher = p.matcher(keyValue);
                return matcher.find();
            }
            case "ecl:": {
                Pattern p = Pattern.compile("(amb|blu|brn|gry|grn|hzl|oth)");
                Matcher matcher = p.matcher(keyValue);
                return matcher.find();
            }
            case "pid:": {
                Pattern p = Pattern.compile("[0-9]{9}");
                Matcher matcher = p.matcher(keyValue);
                return matcher.find();
            }
        }
        return false;
    }
}
