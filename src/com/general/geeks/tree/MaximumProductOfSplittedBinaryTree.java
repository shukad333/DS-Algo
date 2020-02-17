package com.general.geeks.tree;

/**
 * 
 * Given a binary tree root. Split the binary tree into two subtrees by removing 1 edge such that the product of the sums of the subtrees are maximized.

Since the answer may be too large, return it modulo 10^9 + 7.

 
 * 
 * @author skadavath
 *
 */
public class MaximumProductOfSplittedBinaryTree {

	public int maxProduct(TreeNode root) {
		
		getTotalSum(root);
		getMaxRes(root);
		
		return (int)(maxRes % ((int)Math.pow(10, 9)+7));
		

	}
	
	long sum,maxRes;
	void getTotalSum(TreeNode root) {
		if(null==root)
			return;
		
		sum += (long)root.data ;
		getTotalSum(root.left);
		getTotalSum(root.right);
		
		
	}
	
	 int getMaxRes(TreeNode root) {
		if(null==root)
			return 0;
		
		int left = getMaxRes(root.left);
		int right = getMaxRes(root.right);
		maxRes = Math.max(maxRes, (sum-root.data-left-right)*(root.data+left+right));
		return root.data+left+right;
	}

}
