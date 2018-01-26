package String;

import java.util.ArrayList;
import java.util.List;

/*
Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.
 */
public class TextJustification {
	public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<> ();
        if (words == null || words.length == 0) return res;
        int count = 0, total = 0, start = 0;
        for (int i = 0; i < words.length; i++) {
            int curLen = words[i].length();
            if (count == 0) {
                // start a new line
                total += curLen;
                start = i;
                count++;
            } else {
                // can put in current line
                if (total + count + curLen <= maxWidth) {
                    total += curLen;
                    count++;
                } else {
                    // build a line
                    i--;
                    res.add(builder(words, start, i, count, total, maxWidth));
                    count = 0;
                    total = 0;
                }
            }
        }
        res.add(lastBuilder(words, start, words.length - 1, count, total, maxWidth));
        
        return res;
    }
    
    public String builder(String[] words, int start, int end, int count, int total, int maxWidth) {
        int interval = 0;
        StringBuilder sb = new StringBuilder();
        if (count == 1) {
            interval = maxWidth - words[start].length();
            sb.append(words[start]);
            while (interval != 0) {
                sb.append(" ");
                interval--;
            }
        } else {
            int remain = maxWidth - total;
            interval = remain / (count - 1);
            int extra = remain % (count - 1);
            for (int i = start; i <= end - 1; i++) {
                int loop = interval;
                sb.append(words[i]);
                if (extra != 0) {
                    sb.append(" ");
                    extra--;
                }
                while (loop != 0) {
                    sb.append(" ");
                    loop--;
                }
            }
            sb.append(words[end]);
        }
        return sb.toString();
    }
    
    public String lastBuilder(String[] words, int start, int end, int count, int total, int maxWidth) {
        int remain = maxWidth - total - count;
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append(words[i]);
            sb.append(" ");
        }
        while (remain >= 0) {
            sb.append(" ");
            remain--;
        }
        sb.setLength(maxWidth);
        return sb.toString();
    }
}
