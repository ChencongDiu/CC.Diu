package Design;

import java.util.LinkedList;
import java.util.Queue;

/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5
as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */
public class SerializeandDeserializeBinaryTree {
	private final String spliter = ",";
    private final String nu = "null";
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helperString(root, sb);
        return sb.toString();
    }
    
    public void helperString(TreeNode root, StringBuilder sb) {
        if (root == null) 
            sb.append(nu).append(spliter);
        else {
            sb.append(Integer.toString(root.val)).append(spliter);
            helperString(root.left, sb);
            helperString(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> q = new LinkedList<String> ();
        String[] strArr = data.split(spliter);
        for (String ele: strArr) q.offer(ele);
        return helperTree(q);
    }
    
    public TreeNode helperTree(Queue<String> q) {
        String strNode = q.poll();
        if (strNode.equals(nu)) return null;
        TreeNode node = new TreeNode(Integer.parseInt(strNode));
        node.left = (helperTree(q));
        node.right = (helperTree(q));
        return node;
    }
}
