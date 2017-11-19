package Array;

import java.util.Arrays;
import java.util.HashMap;

/*
Given scores of N athletes, find their relative ranks and the people with the top three highest scores, who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".

Example 1:
Input: [5, 4, 3, 2, 1]
Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
Explanation: The first three athletes got the top three highest scores, so they got "Gold Medal", "Silver Medal" and "Bronze Medal". 
For the left two athletes, you just need to output their relative ranks according to their scores.
Note:
N is a positive integer and won't exceed 10,000.
All the scores of athletes are guaranteed to be unique.
 */
public class RelativeRanks {
	public String[] findRelativeRanks(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<> ();
        String[] res = new String[nums.length];
        
        for (int ele: nums) hm.put(ele, hm.size());
        Arrays.sort(nums);
        String[] ft = {"Gold Medal", "Silver Medal", "Bronze Medal"};
        
        for (int i = nums.length - 1; i >= 0; i--) {
        	int ele = nums[i];
        	int rank = nums.length - 1 - i;
        	int index = hm.get(ele);
        	res[index] = (rank < 3)? ft[rank]: Integer.toString(rank + 1);
        }
        
        return res;
    }
}
