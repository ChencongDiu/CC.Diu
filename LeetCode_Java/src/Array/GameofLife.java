package Array;

/*
Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies, as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population..
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
Write a function to compute the next state (after one update) of the board given its current state.
 */

/*
 * next <- now  value
 *    0 <- 0      0
 *    0 <- 1      1
 *    1 <- 0      2
 *    1 <- 1      3
 *    now = value & 1
 *   next = value >> 1
 */
public class GameofLife {
	public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        int r = board.length, c = board[0].length;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                int count = countlives(board, i, j);
                //0 -> 1
                if (board[i][j] == 0 && count == 3) {
                    board[i][j] = 2;
                }
                //1 -> 1
                else if (board[i][j] == 1 && (count == 2 || count == 3)) {
                    board[i][j] = 3;
                }
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                board[i][j] >>= 1;
            }
        }
    }
    public int countlives(int[][] board, int i, int j) {
        int r = board.length;
        int c = board[0].length;
        int res = 0;
        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                if (k == i && l == j) {
                    continue; //itself
                } else if (k < 0 || k >= r || l < 0 || l >= c) {
                    continue; //invalid position
                } else {
                    res += (board[k][l] & 1); //get 1st bit
                }
            }
        }
        return res;
    }
}
