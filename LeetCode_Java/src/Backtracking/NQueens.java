package Backtracking;

import java.util.ArrayList;
import java.util.List;

/*
The n-queens puzzle is the problem of placing n queens on an n¡Án chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
 */
public class NQueens {
	List<List<String>> res = new ArrayList<> ();
    public List<List<String>> solveNQueens(int n) {
        if(n < 1) return res;
        backtracking(n, new ArrayList<String> ());
        return res;
    }
    public void backtracking(int maxN, ArrayList<String> curL) {
        if (curL.size() == maxN) {
            res.add(new ArrayList<String> (curL));
            return;
        }
        for (int i = 0; i < maxN; i++) {
            if (isValid(curL, i, maxN)) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < maxN; j++) {
                    sb.append((i == j)? "Q": ".");
                }
                curL.add(sb.toString());
                backtracking(maxN, curL);
                curL.remove(curL.size() - 1);
            }
        }
    }
    public boolean isValid(ArrayList<String> curL, int pos, int maxN) {
        for (int i = 0; i < curL.size(); i++) {
            String str = curL.get(i);
            int d = curL.size() - i;
            int L = pos - d;
            int R = pos + d;
            if ((L >= 0 && str.charAt(L) == 'Q') || (R < maxN && str.charAt(R) == 'Q') || str.charAt(pos) == 'Q') return false;
        }
        return true;
    }
}
