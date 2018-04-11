package com.general.geeks.tree;

/*\
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


 */
public class HeightBalancedSubTree {

	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(12);
		node.left = new TreeNode(14);
		node.right = new TreeNode(15);
		node.left.right = new TreeNode(17);
		node.left.right.left = new TreeNode(19);
		
		System.out.println(new HeightBalancedSubTree().isBalanced(node));

	}

	public boolean isBalanced(TreeNode root) {
		
		if(null == root) {
			return true;
		}
		
		int lh = height(root.left);
		int rh = height(root.right);
		
		if(Math.abs((lh-rh))<=1 && isBalanced(root.left) && isBalanced(root.right))
			return true;
		
		return false;
	}
	
	private int height(TreeNode root) {
		if(null == root) {
			return 0;
		}
		
		return 1+ Math.max(height(root.left), height(root.right));
	}
}
