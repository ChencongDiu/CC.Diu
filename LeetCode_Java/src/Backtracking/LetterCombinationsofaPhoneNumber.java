package Backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class LetterCombinationsofaPhoneNumber {
	public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<> ();
        if (digits.contains("1") || digits.contains("0") || digits.isEmpty()) return res;
        
        char[] charDigits = digits.toCharArray();
        int size = charDigits.length;
        String[] strTable = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Stack<Integer> intStack = new Stack<> ();
        boolean flag = true;
        
        while (flag) {
        	while (intStack.size() < size) {intStack.push(0);}
        
    		res.add(builder(intStack, charDigits, strTable));
    		flag = checkDigit(intStack, charDigits, strTable, flag);
        }
		return res;
    }
    private static boolean checkDigit(Stack<Integer> intStack, char[] charDigits, String[] strTable, boolean flag) {
		if (intStack.empty()) {return false;}
		int tail = intStack.pop();
		tail++;
		if (tail == strTable[charDigits[intStack.size()] - '0' - 2].length()) {
			flag = checkDigit(intStack, charDigits, strTable, flag);
		} else {
			intStack.push(tail);
		}
		return flag;
	}

	private static String builder(Stack<Integer> intStack, char[] charDigits, String[] strTable) {
		StringBuilder ele = new StringBuilder();
		for (int i = 0; i < charDigits.length; i++) {
			String str = strTable[charDigits[i] - '0' - 2];
			int index = intStack.elementAt(i);
			ele.append(str.charAt(index));
		}
		System.out.println(ele);
		return ele.toString();
	}
}
