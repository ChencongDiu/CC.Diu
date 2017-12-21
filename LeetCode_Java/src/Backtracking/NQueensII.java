package Backtracking;

/*
Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.
 */
public class NQueensII {
	int res = 0;
    public int totalNQueens(int n) {
        int[][] board = new int[n][n];
        backtracking(0, n, board);
        return res;
    }
    
    public void backtracking(int curN, int maxN, int[][] board) {
        if (curN == maxN) {
            res++;
            return;
        }
        for (int i = 0; i < maxN; i++) {
            if (isValid(curN, i, board, maxN)) {
                board[curN][i] = 1;
                backtracking(curN + 1, maxN, board);
                board[curN][i] = 0;
            }
        }
    }
    
    public boolean isValid(int curR, int curC, int[][] board, int maxN) {
        for (int i = 0; i < curR; i++) {
            int d = curR - i;
            int L = curC - d;
            int R = curC + d;
            if (board[i][curC] == 1 || (L >= 0 && board[i][L] == 1) || (R < maxN && board[i][R] == 1)) return false;
        }
        return true;
    }
}
