package Array;

/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 */
public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        if (row == 0) return;
        int col = matrix[0].length;
        boolean fr = false;
        boolean fc = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                    if (i == 0) fr = true;
                    if (j == 0) fc = true;
                }
            }
        }
        //flip without caring first row and first col
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) matrix[i][j] = 0;
            }
        }
        //flip first row and first col
        if (fr) {
            for (int j = 0; j < col; j++) {
                matrix[0][j] = 0;
            }
        }
        if (fc) {
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
