package com.general.geeks.tree;

/**
 * 
 * Given the root of a binary tree with N nodes, each node in the tree has node.val coins, and there are N coins total.

In one move, we may choose two adjacent nodes and move one coin from one node to another.  (The move may be from parent to child, or from child to parent.)

Return the number of moves required to make every node have exactly one coin.

Input: [3,0,0]
Output: 2
Explanation: From the root of the tree, we move one coin to its left child, and one coin to its right child.
 * 
 * @author skadavath
 *
 */
public class DistributeCoinsInABinaryTree {

	public int distributeCoins(TreeNode root) {
		
		int[] resp = new int[1];
		dfs(root, resp);
		return resp[0];

	}
	
	private int dfs(TreeNode root,int[] resp) {
		if(null == root)
			return 0;
		
		int left = dfs(root.left, resp);
		int right = dfs(root.right,resp);
		
		resp[0] += Math.abs(left) + Math.abs(right);
		
		return root.data + left+right-1;
	}

}
