package String;

/*
 * Given two strings S and T, determine if they are both one edit distance apart.
 */
public class OneEditDistance {
	/*public boolean isOneEditDistance(String s, String t) {
	    int lenS = s.length();
	    int lenT = t.length();
	    if (Math.abs(lenS - lenT) > 1) return false;
	    if (lenS == lenT) return isReplace(s, t);
	    else if (lenS + 1 == lenT) return isInsert(s, t);
	    else return isInsert(t, s);
	}
	
	public boolean isReplace(String s, String t) {
	    boolean flag = false;
	    for (int i = 0; i < s.length(); i++) {
	        if (s.charAt(i) != t.charAt(i)) {
	            if (flag) {
	                return false;
	            }
	            flag = true;
	        }
	    }
	    return flag;
	}
	
	public boolean isInsert(String shortS, String longS) {
	    int index1 = 0;
	    int index2 = 0;
	    boolean oneDifference = false;
	    while (index1 < shortS.length() && index2 < longS.length()) {
	        if (shortS.charAt(index1) != longS.charAt(index2)) {
	            if (oneDifference) {
	                return false;
	            }
	            oneDifference = true;
	            index2++;
	        } else {
	            index1++;
	            index2++;
	        }
	    }
	    return true;
	}*/
	
	public boolean isOneEditDistance(String s, String t) {
	    int m = s.length();
	    int n = t.length();
	    if (Math.abs(m - n) > 1) return false;
	    for (int i = 0; i < Math.min(m, n); i++) {
	        if (s.charAt(i) == t.charAt(i)) continue;
	        if (m == n) return s.substring(i + 1).equals(t.substring(i + 1));
	        if (m < n) return s.substring(i).equals(t.substring(i + 1));
	        else return s.substring(i + 1).equals(t.substring(i));
	    }
	    return m != n;
	}
}
