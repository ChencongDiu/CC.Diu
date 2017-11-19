package Design;

/*
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

For example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.
 */
public class AddandSearchWord_Datastructuredesign {
private static final char ditto = '.';
    
    public class dictNode {
        dictNode[] children;
        boolean isWord;
        
        public dictNode() {
            children = new dictNode[26];
            isWord = false;
        }
    }
    
    private dictNode root;
    
    /** Initialize your data structure here. 
     * @return */
    public void WordDictionary() {
        root = new dictNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        dictNode curNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curNode.children[c - 'a'] == null) {
                curNode.children[c - 'a'] = new dictNode();
            }
            curNode = curNode.children[c - 'a'];
        }
        curNode.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return fuzzySearch(word, 0, root);
    }
    
    //'.' is a magic ditto
    public boolean fuzzySearch(String word, int index, dictNode curNode) {
        if (index == word.length()) return curNode.isWord;
        char c = word.charAt(index);
        if (c != ditto) {
            return (curNode.children[c - 'a'] != null && fuzzySearch(word, index + 1, curNode.children[c - 'a']));
        } else {
            //ditto found
            //return true once we found one match
            for (int i = 0; i < 26; i++ ) {
                if (curNode.children[i] != null && fuzzySearch(word, index + 1, curNode.children[i])) return true;
            }
        }
        return false;
    }
}
