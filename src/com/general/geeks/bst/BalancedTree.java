package com.general.geeks.bst;


/**
 * 
 * Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example 1:

Given the following tree [3,9,20,null,null,15,7]:

    3
   / \
  9  20
    /  \
   15   7
Return true.

Example 2:

Given the following tree [1,2,2,3,3,null,null,4,4]:

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
Return false.
 * 
 * @author skadavath
 *
 */
public class BalancedTree {
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(9);
		node.right = new TreeNode(20);
		node.right.left = new TreeNode(15);
		node.right.right = new TreeNode(7);
		node.right.right.right = new TreeNode(7);
		
		System.out.println(new BalancedTree().isBalanced(node));
		
	}
	
	public boolean isBalanced(TreeNode root) {
		
		return isBalancedTree(root)!=-1;
		
	}
	
	private int isBalancedTree(TreeNode root) {
		
		if(null==root)
			return 0;
		
		int left = isBalancedTree(root.left);
		int right = isBalancedTree(root.right);
		if(left==-1 || right==-1 || Math.abs(left-right)>1)
			return -1;
		
		return 1+Math.max(left, right);
		
		
	}

}
