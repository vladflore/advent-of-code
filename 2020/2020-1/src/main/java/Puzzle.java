public class Puzzle {

    private final int[] expenseReport;
    private final int totalExpense;

    public Puzzle(int[] expenseReport, int totalExpense) {
        this.expenseReport = expenseReport;
        this.totalExpense = totalExpense;
    }

    public long[] solve() {
        return new long[]{solvePart1(expenseReport, totalExpense), solvePart2(expenseReport, totalExpense)};
    }

    private long solvePart1(int[] expenseReport, int totalExpense) {
        for (int i = 0; i < expenseReport.length - 1; i++) {
            for (int j = i + 1; j < expenseReport.length; j++) {
                if (expenseReport[i] + expenseReport[j] == totalExpense) {
                    return expenseReport[i] * expenseReport[j];
                }
            }
        }
        return 0;
    }

    private long solvePart2(int[] expenseReport, int totalExpense) {
        for (int i = 0; i < expenseReport.length - 2; i++) {
            for (int j = i + 1; j < expenseReport.length - 1; j++) {
                for (int k = j + 1; k < expenseReport.length; k++) {
                    if (expenseReport[i] + expenseReport[j] + expenseReport[k] == totalExpense) {
                        return expenseReport[i] * expenseReport[j] * expenseReport[k];
                    }
                }
            }
        }
        return 0;
    }
}
