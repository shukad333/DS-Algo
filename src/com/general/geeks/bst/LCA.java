package com.general.geeks.bst;

public class LCA {
	
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(100);
		tree.left = new TreeNode(50);
		tree.right = new TreeNode(200);
		tree.left.left = new TreeNode(25);
		tree.left.right = new TreeNode(75);
		tree.right.left = new TreeNode(150);
		tree.right.right = new TreeNode(400);
		
		System.out.println(LCA(tree,50,400).data);
		
	}
	
	public static TreeNode LCA(TreeNode node,int n1,int n2) {
		if(null==node) {
			return null;
		}
		
		if(node.data>n1 && node.data>n2) {
			return LCA(node.left,n1,n2);
		}
		
		if(node.data<n1 && node.data<n2) {
			return LCA(node.right,n1,n2);
		}
		
		return node;
	}
}
