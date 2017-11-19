package Tree;

/*
Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1
Note:
The size of the given array will be in the range [1,1000].
 */
public class MaximumBinaryTree {
	public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null) return null;
        return generator(nums, 0, nums.length - 1);
    }
    public TreeNode generator(int[] nums, int start, int end) {
        if (start > end) return null;
        int indexMax = start;
        for (int i = start; i <= end; i++) {
            indexMax = (nums[i] > nums[indexMax])? i: indexMax;
        }
        TreeNode cur = new TreeNode(nums[indexMax]);
        cur.left = generator(nums, start, indexMax - 1);
        cur.right = generator(nums, indexMax + 1, end);
        return cur;
    }
}
