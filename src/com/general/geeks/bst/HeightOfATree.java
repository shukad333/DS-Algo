package com.general.geeks.bst;

public class HeightOfATree {
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(10);
		node.left = new TreeNode(5);
		node.left.left = new TreeNode(100);
		new HeightOfATree().getHeight(node);
	}
	
	public void getHeight(TreeNode bst) {
		System.out.println(getHeightOfTree(bst));
	}
	
	public int getHeightOfTree(TreeNode bst) {
		if(bst==null)
			return 0;
		return 1+Math.max(getHeightOfTree(bst.left),getHeightOfTree(bst.right));
	}
}
