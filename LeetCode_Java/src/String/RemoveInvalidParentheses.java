package String;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Examples:
"()())()" -> ["()()()", "(())()"]
"(a)())()" -> ["(a)()()", "(a())()"]
")(" -> [""]
 */
public class RemoveInvalidParentheses {
	public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<String> ();
        
        if (s == null) return res;
        
        Queue<String> q = new LinkedList<String> ();
        HashSet<String> hs = new HashSet<String> ();
        
        q.offer(s);
        hs.add(s);
        
        boolean stop = false;
        
        while (!q.isEmpty()) {
            String str = q.poll();
            
            if (isValid(str)) {
                res.add(str);
                stop = true;
            }
            
            if (stop) continue;
            
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != '(' && str.charAt(i) != ')') continue;
                
                String newStr = str.substring(0, i) + str.substring(i + 1);
                
                if (!hs.contains(newStr)) {
                    hs.add(newStr);
                    q.offer(newStr);
                }
            }
        }
        
        return res;
    }
    
    public boolean isValid(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                count++;
            } else if (c == ')') {
                if (count == 0) {
                    return false;
                } else {
                    count--;
                }
            }
        }
        return (count == 0);
    }
}
