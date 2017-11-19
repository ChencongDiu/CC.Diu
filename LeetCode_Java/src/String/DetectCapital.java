package String;

/*
Given a word, you need to judge whether the usage of capitals in it is right or not.

We define the usage of capitals in a word to be right when one of the following cases holds:

All letters in this word are capitals, like "USA".
All letters in this word are not capitals, like "leetcode".
Only the first letter in this word is capital if it has more than one letter, like "Google".
Otherwise, we define that this word doesn't use capitals in a right way.
Example 1:
Input: "USA"
Output: True
Example 2:
Input: "FlaG"
Output: False
Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 */
public class DetectCapital {
	public boolean detectCapitalUse(String word) {
        if (word.equals(word.toLowerCase()) || word.equals(word.toUpperCase())) return true;
        String first  = word.substring(0, 1);
        String remain = word.substring(1);
        String newStr = first.toUpperCase() + remain.toLowerCase();
        return (word.equals(newStr));
    }
}
