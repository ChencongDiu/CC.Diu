package Backtracking;

/*
Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.
 */
public class SudokuSolver {
	public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) return;
        solve(board);
    }
    
    public boolean solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    //try from '1' to '9'
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            //go to next cell
                            if (solve(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isValid(char[][] board, int row, int col, char c) {
        int startR = row / 3 * 3, startC = col / 3 * 3;
        for (int i = 0; i < 9; i++) {
            int blockR = i / 3, blockC = i % 3;
            //check a row
            if (board[row][i] != '.' && board[row][i] == c) return false;
            //check a col
            if (board[i][col] != '.' && board[i][col] == c) return false;
            //check a block
            if (board[startR + blockR][startC + blockC] != '.' && 
                board[startR + blockR][startC + blockC] == c) return false;
        }
        return true;
    }
}
