package Stack;

import java.util.Stack;

/*
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<> ();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else {
                //must be a close
                if (!stack.isEmpty()) {
                    if (s.charAt(stack.peek()) == '(') {
                        //match
                        stack.pop();
                    } else {
                        stack.push(i);
                    }
                } else {
                    stack.push(i);
                }
            }
        }
        if (stack.isEmpty()) return s.length();
        else {
            int pre = s.length(), cur = 0;
            while (!stack.isEmpty()) {
                cur = stack.pop();
                res = Math.max(res, pre - 1 - cur);
                pre = cur;
            }
            res = Math.max(res, pre);
        }
        return res;
    }
}
