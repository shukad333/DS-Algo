package com.general.geeks.tree;

public class LevelOrderTraversal {
	
	public static void main(String[] args) {
		
		TreeNode tree = new TreeNode(100);
		tree.left = new TreeNode(50);
		tree.right = new TreeNode(200);
		tree.left.left = new TreeNode(25);
		tree.left.right = new TreeNode(75);
		tree.right.right = new TreeNode(400);
		tree.right.right.right = new TreeNode(600);
		
		levelOrder(tree);
		
		
	}
	
	private static void levelOrder(TreeNode node) {
		int height = height(node);
		//change below for the reverse level order traversal
		for(int i=height;i>=1;i--) {
			levelOrder(node, i);
			System.out.println();
		}
	}
	
	private static void levelOrder(TreeNode node , int level) {
		
		if(null==node) {
			return;
		}
		
		if(level==1) {
			System.out.print(node.data+" ");
		}
		
		levelOrder(node.left,level-1);
		levelOrder(node.right,level-1);
		
	}
	
	
	private static int height(TreeNode tree) {
		if(null==tree) {
			return 0;
		}
		
		return 1+Math.max(height(tree.left), height(tree.right));
	}
}
