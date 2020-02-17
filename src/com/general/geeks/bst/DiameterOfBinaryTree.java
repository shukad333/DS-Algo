package com.general.geeks.bst;

/**
 * 
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.
 * 
 * @author skadavath
 *
 */
public class DiameterOfBinaryTree {
	
	public static void main(String[] args) {
		
		
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.left = new TreeNode(4);
		
		System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(node));
		
	}
	
	public int diameterOfBinaryTree(TreeNode root) {
		
		int[] dia = new int[1];
		
		diameter(root, dia);
		
		return dia[0];
		
	}
	
	private int diameter(TreeNode root , int[] dia) {
		
		if(null==root)
			return 0;
		int left = diameter(root.left, dia);
		int right = diameter(root.right, dia);
		
		dia[0] = Math.max(left+right, dia[0]);
		
		return 1+Math.max(left, right);
		
	}

}
