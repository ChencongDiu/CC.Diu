package BinarySearch;

/*
Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.

Example:

matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,

return 13.
Note: 
You may assume k is always valid, 1 ¡Ü k ¡Ü n2.
 */

public class KthSmallestElementinaSortedMatrix {
	/*//brute force
	public int kthSmallest(int[][] matrix, int k) {
        int r = matrix.length;
        if (r == 1) return matrix[0][k - 1];
        int c = matrix[0].length;
        int[] flatten = new int[r * c];
        int index = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                flatten[index++] = matrix[i][j];
            }
        }
        Arrays.sort(flatten);
        return flatten[k - 1];
    }*/
	
	//binary search
	public int kthSmallest(int[][] matrix, int k) {
        int r = matrix.length;
        int l = matrix[0][0], h = matrix[r - 1][r - 1];
        while (l <= h) {
            int mid = l + (h - l) / 2;
            int count = counter(matrix, mid);
            if (count < k) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return l;
    }
    
    //count number of ele <= target
    public int counter(int[][] matrix, int target) {
        int res = 0, n = matrix.length;
        int r = 0, c = n - 1;
        while (r < n && c >= 0) {
            if (matrix[r][c] > target) {
                c--;
            } else {
                res += c + 1;
                r++;
            }
        }
        return res;
    }
}
