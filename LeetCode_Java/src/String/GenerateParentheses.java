package String;

import java.util.ArrayList;
import java.util.List;

/*
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * [
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
  ]
 */
public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String> ();
        builder(res, "", 0, 0, n);
        return res;
    }
    
    public void builder(List<String> res, String str, int open, int close, int n) {
        if (str.length() == 2 * n) {
            res.add(str);
            return;
        }
        //append "("
        if (open < n) {
            builder(res, str + "(", open + 1, close, n);
        }
        //or append ")" if open > close
        if (open > close) {
            builder(res, str + ")", open, close + 1, n);
        }
    }
}
