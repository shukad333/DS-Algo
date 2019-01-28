package com.general.geeks.bst;

/**
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

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
 * @author skadavath
 *
 */
public class MaximumBinaryTree {
	
	public static void main(String[] args) {
		TreeNode node = new MaximumBinaryTree().constructMaximumBinaryTree(new int[] {3,2,1,6,0,5});
		System.out.println(node);
	}
	
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		
		return construct(nums, 0, nums.length-1);

	}
	
	
	private TreeNode construct(int nums[] , int start , int end) {
		
		if(start>end)
			return null;
		
		int max = start;
		for(int i=start+1;i<=end;i++)
			if(nums[i]>nums[max])
				max = i;
		
		TreeNode node = new TreeNode(nums[max]);
		node.left = construct(nums, start, max-1);
		node.right = construct(nums, max+1, end);
		return node;
	}

}
