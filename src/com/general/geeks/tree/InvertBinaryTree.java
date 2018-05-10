package com.general.geeks.tree;

/**
 * Invert a binary tree.
 * 
 * Example:
 * 
 * Input:
 * 
 * 4 / \ 2 7 / \ / \ 1 3 6 9 Output:
 * 
 * 4 / \ 7 2 / \ / \ 9 6 3 1
 * 
 * @author skadavath
 *
 */
public class InvertBinaryTree {
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		
		new InvertBinaryTree().invertTree(node);
		System.out.println(node.left.data+" "+node.right.data);
	}

	public TreeNode invertTree(TreeNode root) {
		
		if(null == root) {
			return null;
		}
		
		TreeNode temp = root.left;
		root.left = invertTree(root.right);
		root.right = invertTree(temp);
		return root;

	}

}
