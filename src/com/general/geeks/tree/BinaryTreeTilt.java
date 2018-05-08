package com.general.geeks.tree;

/**
 * Tilt is the absilute difference of the left & right subtree
 * @author skadavath
 *
 */
public class BinaryTreeTilt {
	
	private static int res = 0;
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
//		node.left.left = new TreeNode(3);
//		node.right.left = new TreeNode(1);
//		node.right.right = new TreeNode(6);
//		
		System.out.println(res);
		
	}
	
	public int findTilt(TreeNode root) {
		
		if(null == root) {
			return 0;
		}
		
		int left = findTilt(root.left);
		int right = findTilt(root.right);
		
		res += Math.abs( left - right);
		
		return left+right+root.data;
	}

}
