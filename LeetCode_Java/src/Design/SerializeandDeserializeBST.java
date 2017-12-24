package Design;

/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.

The encoded string should be as compact as possible.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */
public class SerializeandDeserializeBST {
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }
    
    public void dfs(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val + ",");
        dfs(root.left, sb);
        dfs(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strVals = data.split(",");
        TreeNode root = null;
        for (String strVal: strVals) {
            if (strVal.length() == 0) continue;
            root = builder(root, Integer.parseInt(strVal));
        }
        return root;
    }
    
    public TreeNode builder(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) {
            root.left = builder(root.left, val);
        } else {
            root.right = builder(root.right, val);
        }
        return root;
    }
}
