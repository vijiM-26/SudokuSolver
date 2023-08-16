public class SudokuSolver {
    public static final int UNASSIGNED = 0;
    public static final int N = 9; // N is the size of a Sudoku puzzle i.e., NxN

    public static void main(String[] args) {
        // 0 means unassigned cells
        int[][] puzzle = {
                {1, 0, 6, 0, 0, 2, 3, 0, 0},
                {0, 5, 0, 0, 0, 6, 0, 9, 1},
                {0, 0, 9, 5, 0, 1, 4, 6, 2},
                {0, 3, 7, 9, 0, 5, 0, 0, 0},
                {5, 8, 1, 0, 2, 7, 9, 0, 0},
                {0, 0, 0, 4, 0, 8, 1, 5, 7},
                {0, 0, 0, 2, 6, 0, 5, 4, 0},
                {0, 0, 4, 1, 5, 0, 6, 0, 9},
                {9, 0, 0, 8, 7, 4, 2, 1, 0}
        };

        System.out.println("Before Solving:");
        printSudoku(puzzle);
        System.out.println();

        System.out.println("After Solving:");
        if (solveSudoku(puzzle)) {
            printSudoku(puzzle);
        } else {
            System.out.println("No solution exists");
        }
    }

    public static boolean solveSudoku(int[][] puzzle) {
        int[] rowCol = new int[2];
        if (!searchLocation(puzzle, rowCol)) {
            return true;
        }

        int row = rowCol[0];
        int col = rowCol[1];

        for (int number = 1; number <= 9; number++) {
            if (isValid(puzzle, row, col, number)) {
                puzzle[row][col] = number;
                if (solveSudoku(puzzle)) {
                    return true;
                }
                puzzle[row][col] = UNASSIGNED;
            }
        }
        return false;
    }

    public static boolean searchLocation(int[][] puzzle, int[] rowCol) {
        for (rowCol[0] = 0; rowCol[0] < N; rowCol[0]++) {
            for (rowCol[1] = 0; rowCol[1] < N; rowCol[1]++) {
                if (puzzle[rowCol[0]][rowCol[1]] == UNASSIGNED) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean uRow(int[][] puzzle, int row, int number) {
        for (int col = 0; col < N; col++) {
            if (puzzle[row][col] == number) {
                return true;
            }
        }
        return false;
    }

    public static boolean uCol(int[][] puzzle, int col, int number) {
        for (int row = 0; row < N; row++) {
            if (puzzle[row][col] == number) {
                return true;
            }
        }
        return false;
    }

    public static boolean uBox(int[][] puzzle, int bsRow, int bsCol, int number) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (puzzle[row + bsRow][col + bsCol] == number) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isValid(int[][] puzzle, int row, int col, int number) {
        return !uRow(puzzle, row, number)
                && !uCol(puzzle, col, number)
                && !uBox(puzzle, row - row % 3, col - col % 3, number)
                && puzzle[row][col] == UNASSIGNED;
    }

    public static void printSudoku(int[][] puzzle) {
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                System.out.print(puzzle[row][col] + " ");
            }
            System.out.println();
        }
    }
}
