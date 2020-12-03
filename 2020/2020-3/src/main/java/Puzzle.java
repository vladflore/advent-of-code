import java.util.Arrays;
import java.util.List;

public class Puzzle {

    private final List<String> data;
    private int[][] map = null;
    private int cols;
    private int initialCols = 0;

    public Puzzle(List<String> data) {
        this.data = data;
    }

    public int[] solve() {
        return new int[]{solvePart1(), solvePart2()};
    }

    private void createMap() {
        map = new int[data.size()][];
        for (int i = 0; i < data.size(); i++) {
            int[] line = Arrays.stream(data.get(i).split("")).map(el -> el.equals(".") ? 0 : 1).mapToInt(Integer::intValue).toArray();
            map[i] = line;
        }
        cols = map[0].length;
        initialCols = cols;
    }

    private void extendMapHorizontally() {
        for (int i = 0; i < map.length; i++) {
            int[] lineTmp = new int[map[i].length + initialCols];
            System.arraycopy(map[i], 0, lineTmp, 0, map[i].length);
            System.arraycopy(map[i], 0, lineTmp, map[i].length, initialCols);
            map[i] = lineTmp;
        }
        cols = map[0].length;
    }

    private int solvePart1() {
        createMap();

        int currLn = 0;
        int currCol = 0;
        int totalTrees = 0;
        while (currLn <= map.length - 1) {
            int currVal = map[currLn][currCol];
            if (currVal == 1) {
                totalTrees++;
            }
            currLn += 1;
            currCol += 3;
            if (currCol >= (cols - 1)) {
                extendMapHorizontally();
            }
        }
        return totalTrees;
    }

    private int solvePart2() {
        int[][] slopes = {
                new int[]{1, 1},
                new int[]{3, 1},
                new int[]{5, 1},
                new int[]{7, 1},
                new int[]{1, 2}
        };
        int ans = 1;
        for (int[] slope : slopes) {
            createMap();

            int currLn = 0;
            int currCol = 0;
            int totalTrees = 0;

            while (currLn <= map.length - 1) {
                int currVal = map[currLn][currCol];
                if (currVal == 1) {
                    totalTrees++;
                }
                currLn += slope[1];
                currCol += slope[0];
                if (currCol >= (cols - 1)) {
                    extendMapHorizontally();
                }
            }
            ans *= totalTrees;
        }
        return ans;
    }
}
