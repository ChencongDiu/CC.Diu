package Array;

/*
Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother to make the gray scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself. If a cell has less than 8 surrounding cells, then use as many as you can.

Example 1:
Input:
[[1,1,1],
 [1,0,1],
 [1,1,1]]
Output:
[[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]
Explanation:
For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
For the point (1,1): floor(8/9) = floor(0.88888889) = 0
Note:
The value in the given matrix is in the range of [0, 255].
The length and width of the given matrix are in the range of [1, 150].
 */
public class ImageSmoother {
	public int[][] imageSmoother(int[][] M) {
        int row = M.length;
        int col = M[0].length;
        int[][] res = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int n = 1;
                int sum = M[i][j];
                if (i - 1 >= 0) {
                    sum += M[i - 1][j];
                    n++;
                    if (j - 1 >= 0) {
                        sum += M[i - 1][j - 1];
                        n++;
                    }
                    if (j + 1 < col) {
                        sum += M[i - 1][j + 1];
                        n++;
                    }
                }
                if (j - 1 >= 0) {
                    sum += M[i][j - 1];
                    n++;
                }
                if (j + 1 < col) {
                    sum += M[i][j + 1];
                    n++;
                }
                if (i + 1 < row) {
                    sum += M[i + 1][j];
                    n++;
                    if (j - 1 >= 0) {
                        sum += M[i + 1][j - 1];
                        n++;
                    }
                    if (j + 1 < col) {
                        sum += M[i + 1][j + 1];
                        n++;
                    }
                }
                res[i][j] = (int) Math.floor(sum / n);
            }
        }
        
        return res;
    }
}
