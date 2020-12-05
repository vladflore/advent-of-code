import java.util.List;

public class Puzzle {

    private final List<String> boardingPasses;

    public Puzzle(List<String> boardingPasses) {
        this.boardingPasses = boardingPasses;
    }

    public int[] solve() {
        return new int[]{solvePart1(), solvePart2()};
    }

    private int solvePart1() {
        return boardingPasses.stream().mapToInt(this::computeSeatId).peek(System.out::println).max().getAsInt();
    }

    private int computeSeatId(String pass) {
        int rowLo = 0;
        int rowHi = 127;
        int colLo = 0;
        int colHi = 7;
        for (int i = 0; i < pass.length(); i++) {
            char letter = pass.charAt(i);
            if (letter == 'F') {
                rowHi = rowLo + (rowHi - rowLo) / 2;
            }
            if (letter == 'B') {
                rowLo = rowLo + (rowHi - rowLo) / 2 + 1;
            }
            if (letter == 'L') {
                colHi = colLo + (colHi - colLo) / 2;
            }
            if (letter == 'R') {
                colLo = colLo + (colHi - colLo) / 2 + 1;
            }
        }
        return rowLo * 8 + colLo;
    }

    private int solvePart2() {
        int[] seats = boardingPasses.stream().mapToInt(this::computeSeatId).sorted().toArray();
        for (int i = 0; i < seats.length - 1; i++) {
            if (seats[i + 1] - seats[i] == 2) {
                return seats[i] + 1;
            }
        }
        return 0;
    }
}
