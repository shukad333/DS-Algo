package com.general.geeks.tree;

/**
 * Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
   / \
  9  20
    /  \
   15   7

Output: 42

 * @author skadavath
 *
 */
public class BinaryTreeMaxPAthSUm {

	public int maxPathSum(TreeNode root) {
		
		int[] sum = new int[] {0};
		
		maxPathSum(root,sum);
		return sum[0];

	}
	
	public int maxPathSum(TreeNode root , int[] sum) {
		if(null == root) {
			return 0;
		}
		int left = Math.max(0, maxPathSum(root.left,sum));
		int right = Math.max(0, maxPathSum(root.right, sum));
		sum[0] = Math.max(sum[0], left+right+root.data);
		return Math.max(left, right) + root.data;
	}

}
