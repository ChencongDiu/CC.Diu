package Array;

/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
 */
public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        if (n <= 0) return res;
        int type = 0, number = 1;
        int startR = 0, endR = n - 1;
        int startC = 0, endC = n - 1;
        while (number <= n * n) {
            if (type % 4 == 0) {
                for (int i = startC; i <= endC; i++) {
                    res[startR][i] = number++;
                }
                startR++;
                type++;
            } else if (type % 4 == 1) {
                for (int i = startR; i <= endR; i++) {
                    res[i][endC] = number++;
                }
                endC--;
                type++;
            } else if (type % 4 == 2) {
                for (int i = endC; i >= startC; i--) {
                    res[endR][i] = number++;
                }
                endR--;
                type++;
            } else if (type % 4 == 3) {
                for (int i = endR; i >= startR; i--) {
                    res[i][startC] = number++;
                }
                startC++;
                type++;
            }
        }
        return res;
    }
}
