package DP;

/*
There is a fence with n posts, each post can be painted with one of the k colors.

You have to paint all the posts such that no more than two adjacent fence posts have the same color.

Return the total number of ways you can paint the fence.
 */
public class PaintFence {
	public int numWays(int n, int k) {
        if (n == 0) {return 0;}
        if (n == 1) {return k;}
        int same = k, dif = k * (k - 1);
        for (int i = 2; i < n; i++) {
            int temp = same;
            same = dif * 1;
            dif = (dif + temp) * (k - 1);
        }
        return dif + same;
    }
}
