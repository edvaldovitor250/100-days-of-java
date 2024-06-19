import java.util.ArrayList;
import java.util.List;

public class Day038 {

    private static final int N = 8;

    public static void main(String[] args) {
        Day038 solver = new Day038();
        List<int[]> solutions = solver.solveNQueens();
        solver.printSolutions(solutions);
    }

    public List<int[]> solveNQueens() {
        List<int[]> results = new ArrayList<>();
        int[] queens = new int[N];
        placeQueens(0, queens, results);
        return results;
    }

    private void placeQueens(int row, int[] queens, List<int[]> results) {
        if (row == N) {
            results.add(queens.clone());
        } else {
            for (int col = 0; col < N; col++) {
                if (isSafe(row, col, queens)) {
                    queens[row] = col;
                    placeQueens(row + 1, queens, results);
                }
            }
        }
    }

    private boolean isSafe(int row, int col, int[] queens) {
        for (int i = 0; i < row; i++) {
            int qCol = queens[i];
            if (qCol == col || qCol - i == col - row || qCol + i == col + row) {
                return false;
            }
        }
        return true;
    }

    private void printSolutions(List<int[]> solutions) {
        for (int[] solution : solutions) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (solution[i] == j) {
                        System.out.print("Q ");
                    } else {
                        System.out.print(". ");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("Total solutions: " + solutions.size());
    }
}
