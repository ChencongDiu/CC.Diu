package Design;

/*
Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z.
 */
class TrieNode {
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];
    public TrieNode() {
    }
}
public class ImplementTriePrefixTree {
private TrieNode root;
    
    /** Initialize your data structure here. */
    public ImplementTriePrefixTree() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curNode.children[c - 'a'] == null) {
                curNode.children[c - 'a'] = new TrieNode();
            }
            curNode = curNode.children[c - 'a'];
        }
        curNode.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curNode = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (curNode.children[c - 'a'] == null) return false;
            curNode = curNode.children[c - 'a'];
        }
        return curNode.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (curNode.children[c - 'a'] == null) return false;
            curNode = curNode.children[c - 'a'];
        }
        return true;
    }
}
