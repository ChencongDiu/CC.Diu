package String;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
 */
public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {return 0;}
        HashSet<String> hs = new HashSet<String> (wordList);
        Queue<String> q = new LinkedList<String> ();
        q.offer(beginWord); //initiated value
        int res = 0;
        while (!q.isEmpty()) {
            int qSize = q.size(); //loop time of current level
            for (int i = 0; i < qSize; i++) {
                String word = q.poll();
                if (word.equals(endWord)) {return res + 1;}
                finder(hs, q, word);
            }
            res++;
        }
        return 0;
    }
    public void finder(HashSet<String> hs, Queue<String> q, String word) {
        int length = word.length();
        for (int i = 0; i < length; i++) {
            char[] wordArr = word.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                if (wordArr[i] == c) {continue;}
                wordArr[i] = c;
                String s = String.valueOf(wordArr);
                if (hs.contains(s)) {
                    q.offer(s);
                    hs.remove(s);
                }
            }
        }
    }
}
