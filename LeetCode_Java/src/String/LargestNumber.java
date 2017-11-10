package String;

import java.util.Arrays;
import java.util.Comparator;

/*
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
 */
public class LargestNumber {
	public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        
        //implement new comparator
        Comparator<String> comparator = new Comparator<String> () {
            public int compare(String str1, String str2) {
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s1.compareTo(s2); //numerical (s1 - s2)
            }
        };
        Arrays.sort(strs, comparator);
        if (strs[strs.length - 1].charAt(0) == '0') return "0";
        
        String res = "";
        for (String s: strs) {
            res = s + res;
        }
        return res;
    }
}
