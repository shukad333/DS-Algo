package com.general.geeks.tree;

/*
 * 
 * Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.


 */
public class MinDepth {
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(10);
		node.left = new TreeNode(4);
		node.left.left = new TreeNode(5);
		node.right = new TreeNode(12);
		node.right.left = new TreeNode(15);
		node.right.left.right = new TreeNode(100);
		
		System.out.println(new MinDepth().minDepth(node));
	}
	public int minDepth(TreeNode root) {
		
		if(null == root) 
			return 0;
		
		if(null == root.left && null==root.right) {
			return 1;
		}
		
		if(root.left==null)
			return 1+minDepth(root.right);
		if(root.right==null)
			return 1+minDepth(root.left);
		
		return 1+Math.min(minDepth(root.left), minDepth(root.right));
		
		
	}
	
}
