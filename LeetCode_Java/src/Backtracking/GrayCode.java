package Backtracking;

import java.util.ArrayList;
import java.util.List;

/*
The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2
Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 */
public class GrayCode {
	public List<Integer> grayCode(int n) {
        /* List<Integer> res = new ArrayList<Integer> ();
        if (n == 0) {
            res.add(0);
            return res;
        }
        double num = Math.pow(2, n);
        for (int index = 0; index < num; index++) {
        	int i = index;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                int lastBit = i & 1;
                i = i >> 1;
                int bit = (i & 1) ^ lastBit;
                sb.append(bit & 1);
            }
            res.add(Integer.parseInt(sb.reverse().toString(), 2));
        }
        return res; */
        ArrayList<Integer> arr = new ArrayList<Integer>();
	    arr.add(0);
	    for(int i=0;i<n;i++){
	        int inc = 1<<i;
	        for(int j=arr.size()-1;j>=0;j--){
	            arr.add(arr.get(j)+inc);
	        }
	    }
	    return arr;
    }
}
