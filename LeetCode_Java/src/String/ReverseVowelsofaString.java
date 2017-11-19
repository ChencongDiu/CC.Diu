package String;

import java.util.HashSet;
import java.util.Set;

/*
Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y".
 */
public class ReverseVowelsofaString {
	public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        char[] vowel = new char[] {'a', 'e', 'i', 'o', 'u', 
        		'A', 'E', 'I', 'O', 'U'};
        Set<Character> set = new HashSet<> ();
        for (char a: vowel)
        	set.add(a);
        
        for (int i = 0, j = arr.length - 1; i < j; ) {
        	if (!set.contains(arr[i])) {
        		i++;
        		continue;
        	}
        	if (!set.contains(arr[j])) {
        		j--;
        		continue;
        	}
        	char temp = arr[j];
        	arr[j] = arr[i];
        	arr[i] = temp;
        	i++;
        	j--;
        }
        return new String(arr);
    }
}
