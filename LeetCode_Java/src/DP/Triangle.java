package DP;

import java.util.List;

/*
Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle
[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
        //top to bottom
        /*if (triangle.size() == 1) return triangle.get(0).get(0);
        int res = Integer.MAX_VALUE;
        for (int r = 1; r < triangle.size(); r++) {
            res = Integer.MAX_VALUE;
            List<Integer> preRow = triangle.get(r - 1);
            List<Integer> curRow = triangle.get(r);
            for (int i = 0; i < curRow.size(); i++) {
                int curN = curRow.get(i);
                if (i == 0) {
                    curN += preRow.get(i);
                } else if (i == preRow.size()) {
                    curN += preRow.get(i - 1);
                } else {
                    curN += Math.min(preRow.get(i), preRow.get(i - 1));
                }
                curRow.set(i, curN);
                res = Math.min(curN, res);
            }
        }
        return res;*/
        
        //bottom to top
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }
}
