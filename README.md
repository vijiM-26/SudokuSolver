# SudokuSolver
This is the implementation of the Sudoku-solving algorithm using the backtracking approach. This code aims to solve a 9x9 Sudoku puzzle by trying out different numbers in empty cells and backtracking when a contradiction is encountered. It follows the general structure of a backtracking algorithm.

Here's a brief overview of what the different parts of the code do:

- The searchLocation function searches for the next unassigned location in the puzzle.
- The isValid function checks whether it's legal to assign a number to a given row and column.
- The uRow, uCol, and uBox functions check whether a specific number already exists in the corresponding row, column, or 3x3 box, respectively.
- The SolveSudoku function is the main backtracking algorithm that tries to solve the puzzle by recursively filling in numbers and backtracking when needed.
- The printSudoku function simply prints the solved or unsolved Sudoku grid.
- In the main function, a sample unsolved Sudoku puzzle is provided, and the program attempts to solve it using the SolveSudoku function. The solved puzzle or a message indicating that no solution exists is then printed.

