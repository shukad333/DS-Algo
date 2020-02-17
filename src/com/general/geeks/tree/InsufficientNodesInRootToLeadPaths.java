package com.general.geeks.tree;

public class InsufficientNodesInRootToLeadPaths {

	public TreeNode sufficientSubset(TreeNode root, int limit) {
		
		if(null == root) 
			return null;
		
		if(null==root.left && null==root.right) {
			return root.data<limit ? null : root;
		}
		
		root.left = sufficientSubset(root.left, limit-root.data);
		root.right = sufficientSubset(root.right, limit-root.data);
		
		
		return root.left == root.right ? null : root;

	}

}
