package com.general.geeks.bst;

/**
 * We are given the head node root of a binary tree, where additionally every
 * node's value is either a 0 or a 1.
 * 
 * Return the same tree where every subtree (of the given tree) not containing a
 * 1 has been removed.
 * 
 * (Recall that the subtree of a node X is X, plus every node that is a
 * descendant of X.)
 * 
 * Example 1: Input: [1,null,0,0,1] Output: [1,null,0,null,1]
 * 
 * Explanation: Only the red nodes satisfy the property "every subtree not
 * containing a 1". The diagram on the right represents the answer.
 * 
 * 
 * @author skadavath
 *
 */
public class BinaryTreePruning {
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(0);
		node.right = new TreeNode(1);
		node.right.left = new TreeNode(0);
		node.right.right = new TreeNode(0);
		
		TreeNode tree = new BinaryTreePruning().pruneTree(node);
		new BinaryTreePruning().pre(node);
		
	}

	public TreeNode pruneTree(TreeNode root) {
		
		if(null == root)
			return null;
		root.left = pruneTree(root.left);
		root.right = pruneTree(root.right);
		return (root.data==1 || root.left!=null || root.right!=null)?root:null;

	}
	
	private void pre(TreeNode node) {
		if(null==node)
			return;
		System.out.println(node.data);
		pre(node.left);
		pre(node.right);
	}

}
