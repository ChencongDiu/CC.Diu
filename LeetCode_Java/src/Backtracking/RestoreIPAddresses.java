package Backtracking;

import java.util.ArrayList;
import java.util.List;

/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)

 */
public class RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<> ();
        if (s.length() < 4 || s.length() > 12) return res;
        backtracking(res, new StringBuilder(), 0, 4, s);
        return res;
    }
    
    public void backtracking(List<String> res, StringBuilder curS, int startPos, int count, String s) {
        if (startPos > s.length() || startPos + 3 * count < s.length() || startPos + 1 * count > s.length()) return;
        if (startPos == s.length()) {
            curS.setLength(curS.length() - 1);
            res.add(curS.toString());
            return;
        }
        int len = curS.length();
        for (int i = 1; i <= 3; i++) {
            if (startPos + i <= s.length() && 
               (i != 3 || Integer.parseInt(s.substring(startPos, startPos + i)) < 256) &&
               (i == 1 || Integer.parseInt(s.substring(startPos, startPos + 1)) != 0)) {
                curS.append(s.substring(startPos, startPos + i) + ".");
                backtracking(res, curS, startPos + i, count - 1, s);
                curS.setLength(len);
            }
        }
    }
}
