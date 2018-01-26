package Stack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".

 */
public class SimplifyPath {
	public String simplifyPath(String path) {
        String[] pathArr = path.split("/");
        Stack<String> stack = new Stack<> ();
        HashSet<String> hs = new HashSet<> (Arrays.asList("", ".", ".."));
        StringBuilder sb = new StringBuilder();
        for (String s: pathArr) {
            if (s.equals("..") && !stack.isEmpty()) stack.pop();
            else if (!hs.contains(s)) stack.push(s);
        }
        for (String s: stack) {
            sb.append("/");
            sb.append(s);
        }
        return sb.length() == 0? "/": sb.toString();
    }
}
