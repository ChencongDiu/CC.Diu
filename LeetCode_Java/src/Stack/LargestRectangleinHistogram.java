package Stack;

import java.util.Stack;

/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given heights = [2,1,5,6,2,3],
return 10.
 */

// https://www.youtube.com/watch?v=ZmnqCZp9bBs
public class LargestRectangleinHistogram {
	public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<> (); // index of arr
        int area = 0, res = 0, i = 0;
        for (; i < heights.length; ) {
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i++);
            } else {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    area = heights[top] * i;
                } else {
                    area = heights[top] * (i - stack.peek() - 1);
                }
                res = Math.max(res, area);
            }
        }
        while (!stack.isEmpty()) {
            int top = stack.pop();
                if (stack.isEmpty()) {
                    area = heights[top] * i;
                } else {
                    area = heights[top] * (i - stack.peek() - 1);
                }
                res = Math.max(res, area);
        }
        return res;
    }
}
