package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
 */
public class SubstringwithConcatenationofAllWords {
	public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> counts = new HashMap<> ();
        List<Integer> res = new ArrayList<> ();
        int wordLen = words[0].length(), wordNum = words.length;
        for (String str: words) {
            counts.put(str, counts.getOrDefault(str, 0) + 1);
        }
        for (int i = 0; i < s.length() - wordLen * wordNum + 1; i++) {
            HashMap<String, Integer> seen = new HashMap<> ();
            int j = 0; // number of matching strings
            //scan and finding
            while (j < wordNum) {
                String word = s.substring(i + j * wordLen, i + (j + 1) * wordLen);
                if (counts.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    if (seen.get(word) > counts.get(word)) {
                        break;
                    } else {
                        j++;
                    }
                } else {
                    break;
                }
            }
            if (j == wordNum) {
                res.add(i);
            }
        }
        return res;
    }
}
