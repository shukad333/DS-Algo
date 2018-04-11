package com.general.geeks.tree;

public class MaxDepth {

	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(10);
		node.left = new TreeNode(5);
		node.right = new TreeNode(15);
		node.right.left = new TreeNode(20);
		node.right.left.right = new TreeNode(30);
		
		System.out.println(new MaxDepth().maxDepth(node));
	}

	public int maxDepth(TreeNode root) {
		
		if(null == root) {
			return 0;
		}
		
		if(null == root.left && null == root.right) {
			return 1;
		}
		
		int left = 1+maxDepth(root.left);
		int right = 1+maxDepth(root.right);
		
		return left>right?left:right;
	}
}
