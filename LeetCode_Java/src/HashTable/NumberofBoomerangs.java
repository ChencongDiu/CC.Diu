package HashTable;

import java.util.HashMap;

/*
Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:
Input:
[[0,0],[1,0],[2,0]]

Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 */
public class NumberofBoomerangs {
	public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer> ();
        int length = points.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int distance = distance(points[i], points[j]);
                hm.put(distance, hm.getOrDefault(distance, 0) + 1);
            }
            
            for (int num: hm.values()) {
                res += num * (num - 1);
            }
            
            hm.clear();
        }
        return res;
    }
    
    public int distance(int[] p1, int[] p2) {
        int x1 = p1[0], y1 = p1[1];
        int x2 = p2[0], y2 = p2[1];
        return ((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }
}
