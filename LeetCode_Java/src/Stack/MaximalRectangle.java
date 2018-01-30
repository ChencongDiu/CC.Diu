package Stack;

import java.util.Stack;

/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 6.
 */
public class MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
        /*if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int res = 0;
        int row = matrix.length, col = matrix[0].length;
        int[] height = new int[col + 1];
        
        for (int i = 0; i < row; i++) {
            Stack<Integer> stack = new Stack<> ();
            for (int j = 0; j < col + 1; j++) {
                // update height arr
                height[j] = (j < col && matrix[i][j] == '1')? height[j] + 1: 0;
                
                // push or calculate
                if (stack.isEmpty() || height[stack.peek()] <= height[j]) stack.push(j);
                else {
                    // calculate
                    while (!stack.isEmpty() && height[stack.peek()] > height[j]) {
                        int top = stack.pop();
                        int area = height[top] * (stack.isEmpty()? j: (j - 1 - stack.peek()));
                        res = Math.max(res, area);
                    }
                    stack.push(j);
                }
            }
        }
        return res;*/
		
		// same as #84
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int res = 0;
        int row = matrix.length, col = matrix[0].length;
        int[] height = new int[col + 1];
        
        for (int i = 0; i < row; i++) {
            Stack<Integer> stack = new Stack<> ();
            for (int j = 0; j < col; j++) {
                // update height arr
                height[j] = (j < col && matrix[i][j] == '1')? height[j] + 1: 0;
            }
            
            int j = 0;
            for (; j < col; ) {
                if (stack.isEmpty() || height[j] >= height[stack.peek()]) stack.push(j++);
                else {
                    int top = stack.pop();
                    int area = height[top] * (stack.isEmpty()? j: (j - stack.peek() - 1));
                    res = Math.max(res, area);
                }
            }
            
            while (!stack.isEmpty()) {
                int top = stack.pop();
                int area = height[top] * (stack.isEmpty()? j: (j - stack.peek() - 1));
                res = Math.max(res, area);
            }
        }
        return res;
    }
}
