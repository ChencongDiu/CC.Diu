package Array;

import java.util.ArrayList;
import java.util.List;

/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
 */
public class PascalsTriangleII {
	public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<> ();
        pre.add(1);
        if (rowIndex == 0) return pre;
        for (int i = 1; i <= rowIndex; i++) {
        	int eleNum = i + 1;
        	List<Integer> cur = new ArrayList<> ();
        	for (int j = 0; j < eleNum; j++) {
        		if (j != 0 && j != eleNum - 1) {
        			cur.add(pre.get(j - 1) + pre.get(j));
        		} else {
        			cur.add(1);
        		}
        	}
        	pre = cur;
        }
        return pre;
    }
}
