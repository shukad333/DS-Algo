package com.general.geeks.tree;


public class LCA {
	
	public static void main(String[] args) {
		
		TreeNode tree = new TreeNode(100);
		tree.left = new TreeNode(50);
		tree.right = new TreeNode(200);
		tree.left.left = new TreeNode(25);
		tree.left.right = new TreeNode(75);
		tree.right.left = new TreeNode(150);
		tree.right.right = new TreeNode(400);
		
		System.out.println(LCA(tree,25,150).data);
	}
	
	private static TreeNode LCA(TreeNode node,int n1,int n2) {
		
		if(null==node) {
			return node;
		}
		
		if(n1==node.data || n2==node.data) {
			return node;
		}
		TreeNode leftLCA = LCA(node.left,n1,n2);
		TreeNode rightLCA = LCA(node.right,n1,n2);
		
		if(null!=leftLCA && null!=rightLCA) {
			return node;
		}
		
		return (leftLCA!=null?leftLCA:rightLCA);
	}
}
