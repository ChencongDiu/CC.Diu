package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
 */
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<> ();
        HashMap<String, Integer> dictionary = new HashMap<> ();
        
        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String sortedStr = new String(arr);
            if(dictionary.containsKey(sortedStr)) {
            	int index = dictionary.get(sortedStr);
            	res.get(index).add(strs[i]);
            } else {
            	dictionary.put(sortedStr, dictionary.size());
            	List<String> ele = new ArrayList<> ();
            	ele.add(strs[i]);
            	res.add(ele);
            }
        }
        return res;
    }
}
