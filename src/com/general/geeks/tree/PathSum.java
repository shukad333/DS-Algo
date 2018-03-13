package com.general.geeks.tree;

public class PathSum {
	
	public static void main(String[] args) {
		
		TreeNode tree = new TreeNode(20);
		tree.left = new TreeNode(15);
		tree.right = new TreeNode(50);
		tree.left.left = new TreeNode(10);
		tree.left.right = new TreeNode(17);
		
		System.out.println(new PathSum().hasPathSum(tree, 51));
	}
	
	public boolean hasPathSum(TreeNode root , int sum) {
		
		if(root == null) {
			return (sum == 0);
		}
		else {
			
			boolean isFound = false;
			
			int tempSum = sum - root.data;
			
			if(0 == tempSum && root.left==null && root.right==null) {
				return true;
			}
			if(null != root.left) {
				isFound =  isFound || hasPathSum(root.left, tempSum);
			}
			
			if(null!= root.right) {
				isFound =  isFound || hasPathSum(root.right, tempSum);
			}
			
			return isFound;
		}
		
	}
}
