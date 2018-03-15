package com.general.geeks.tree;

public class SymmetricTreeRecursive {

	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(10);
		node.left = new TreeNode(5);
		node.right = new TreeNode(5);
		
		System.out.println(new SymmetricTreeRecursive().isSymmetric(node));
	}

	public boolean isSymmetric(TreeNode root) {
			
		return isSymmetric(root, root);
	}
	
	public boolean isSymmetric(TreeNode node1,TreeNode node2) {
		
		if(null == node1 && null == node2) {
			return true;
		}
		
		if(null!=node1 && null!=node2 && node1.data==node2.data) {
			return isSymmetric(node1.left,node2.right) && isSymmetric(node1.right, node2.left);
		}
		
		return false;
	}
}
