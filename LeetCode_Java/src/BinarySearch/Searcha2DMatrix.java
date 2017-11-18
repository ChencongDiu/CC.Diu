package BinarySearch;

/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
 */
public class Searcha2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) return false;
        int col = matrix[0].length;
        if (col == 0) return false;
        
        int startR = 0;
        int endR = row - 1;
        while (startR <= endR) {
            int midR = startR - (startR - endR) / 2;
            if (matrix[midR][0] > target) {
                endR = midR - 1;
            } else if (matrix[midR][col - 1] < target) {
                startR = midR + 1;
            } else {
                int startC = 0;
                int endC = col - 1;
                while (startC <= endC) {
                    int midC = startC - (startC - endC) / 2;
                    if (matrix[midR][midC] == target) {
                        return true;
                    } else if (matrix[midR][midC] < target) {
                        startC = midC + 1;
                    } else if (matrix[midR][midC] > target) {
                        endC = midC - 1;
                    }
                }
                return false;
            }
        }
        
        
        return false;
    }
}
