package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
 */
public class SortCharactersByFrequency {
	public String frequencySort(String s) {
        char[] sArr = s.toCharArray();
        HashMap<Character, Integer> hm = new HashMap<Character, Integer> ();
        List<Character>[] bucket = new List[s.length() + 1];
        StringBuilder sb = new StringBuilder();
        for (char c: sArr) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        bucketBuilder(bucket, hm);
        stringBuilder(sb, bucket);
        return sb.toString();
    }
    
    public void bucketBuilder(List<Character>[] bucket, HashMap<Character, Integer> hm) {
        for (char c: hm.keySet()) {
            int num = hm.get(c);
            if (bucket[num] == null) {
                bucket[num] = new ArrayList<Character> ();
            }
            bucket[num].add(c);
        }
    }
    
    public void stringBuilder(StringBuilder sb, List<Character>[] bucket) {
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] == null) continue;
            for (char ele: bucket[i]) {
                for (int k = 0; k < i; k++) {
                    sb.append(ele);
                }
            }
        }
    }
}
