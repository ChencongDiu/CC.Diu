package Array;

/*
Given a picture consisting of black and white pixels, find the number of black lonely pixels.

The picture is represented by a 2D char array consisting of 'B' and 'W', which means black and white pixels respectively.

A black lonely pixel is character 'B' that located at a specific position where the same row and same column don't have any other black pixels.

Example:
Input: 
[['W', 'W', 'B'],
 ['W', 'B', 'W'],
 ['B', 'W', 'W']]

Output: 3
Explanation: All the three 'B's are black lonely pixels.
Note:
The range of width and height of the input 2D array is [1,500].
 */
public class LonelyPixelI {
	public int findLonelyPixel(char[][] picture) {
        int numberOfRow = picture.length;
        int numberOfCol = picture[0].length;
        int result = 0;
        int[] BRow = new int[numberOfRow];
        int[] BCol = new int[numberOfCol];
        for (int r = 0; r < numberOfRow; r++) {
            for (int c = 0; c < numberOfCol; c++) {
                if (picture[r][c] == 'B') {
                    BRow[r]++;
                    BCol[c]++;
                }
            }
        }
        for (int r = 0; r < numberOfRow; r++) {
            for (int c = 0; c < numberOfCol; c++) {
                if (picture[r][c] == 'B' && BRow[r] == 1 && BCol[c] == 1) result++;
            }
        }
        
        return result;
    }
}
