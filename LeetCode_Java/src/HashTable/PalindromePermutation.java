package HashTable;

import java.util.Arrays;

/*
Given a string, determine if a permutation of the string could form a palindrome.

For example,
"code" -> False, "aab" -> True, "carerac" -> True.
 */
public class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
        char[] sArr = s.toCharArray();
        Arrays.sort(sArr);
        int numberOfOdd = 0;
        for (int i = 0; i < sArr.length; ) {
            char c = sArr[i];
            int start = i;
            while (i < sArr.length && c == sArr[i]) {i++;}
            numberOfOdd += (i - start) % 2;
            if (i == sArr.length) {break;}
        }
        return (numberOfOdd < 2);
    }
}
