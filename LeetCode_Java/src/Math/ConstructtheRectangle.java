package Math;

/*
For a web developer, it is very important to know how to design a web page's size. So, given a specific rectangular web page��s area, your job by now is to design a rectangular web page, whose length L and width W satisfy the following requirements:

1. The area of the rectangular web page you designed must equal to the given target area.

2. The width W should not be larger than the length L, which means L >= W.

3. The difference between length L and width W should be as small as possible.
You need to output the length L and the width W of the web page you designed in sequence.
Example:
Input: 4
Output: [2, 2]
Explanation: The target area is 4, and all the possible ways to construct it are [1,4], [2,2], [4,1]. 
But according to requirement 2, [1,4] is illegal; according to requirement 3,  [4,1] is not optimal compared to [2,2]. 
 */
public class ConstructtheRectangle {
	public int[] constructRectangle(int area) {
        /*int[] res = new int[2];
        int w = (int) Math.sqrt(area);
        int l = (w * w == area)? w: w + 1;
        while (w * l != area) {
        	if (w * l < area) {
        		l++;
        	} else {
        		w--;
        	}
        }
        res[0] = l;
        res[1] = w;
		return res;*/
		int[] res = new int[2];
		int l = (int) Math.ceil(Math.sqrt(area));
		while (l < area) {
			if (area % l == 0) break;
			l++;
		}
		res[0] = l;
		res[1] = area / l;
		return res;
    }
}
