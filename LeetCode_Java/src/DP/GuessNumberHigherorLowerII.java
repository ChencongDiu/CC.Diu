package DP;

/*
We are playing the Guess Game. The game is as follows:

I pick a number from 1 to n. You have to guess which number I picked.

Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.

However, when you guess a particular number x, and you guess wrong, you pay $x. You win the game when you guess the number I picked.

Example:

n = 10, I pick 8.

First round:  You guess 5, I tell you that it's higher. You pay $5.
Second round: You guess 7, I tell you that it's higher. You pay $7.
Third round:  You guess 9, I tell you that it's lower. You pay $9.

Game over. 8 is the number I picked.

You end up paying $5 + $7 + $9 = $21.
Given a particular n ¡Ý 1, find out how much money you need to have to guarantee a win.
 */
public class GuessNumberHigherorLowerII {
	public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int dis = 1; dis < n; dis++) {
            for (int start = 0; start + dis <= n; start++) {
                int end = start + dis;
                dp[start][end] = Integer.MAX_VALUE;
                for (int mid = start; mid <= end; mid++) {
                    dp[start][end] = Math.min(dp[start][end], mid + Math.max(mid - 1 >= start? dp[start][mid - 1]: 0, mid + 1 <= end? dp[mid + 1][end]: 0));
                }
            }
        }
        return dp[1][n];
    }
}
