package HashTable;

import java.util.HashMap;

/*
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

For example, the numbers "69", "88", and "818" are all strobogrammatic.
 */
public class StrobogrammaticNumber {
	public boolean isStrobogrammatic(String num) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer> ();
        hm.put(0, 0);
        hm.put(1, 1);
        hm.put(6, 9);
        hm.put(8, 8);
        hm.put(9, 6);
        
        int left = 0, right = num.length() - 1;
        while (left <= right) {
            int leftInt = num.charAt(left++) - '0';
            int rightInt = num.charAt(right--) - '0';
            if (!hm.containsKey(leftInt) || hm.get(leftInt) != rightInt) return false;
        }
        return true;
    }
}
