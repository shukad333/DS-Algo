package com.general.geeks.tree;

public class TreeEqual {
	
	public static void main(String[] args) {
		
		TreeNode p = new TreeNode(12);
		p.left = new TreeNode(14);
		TreeNode q = new TreeNode(12);
		q.left = new TreeNode(14);
		TreeEqual equal = new TreeEqual();
		System.out.println(equal.isSameTree(p, q));
		
		
	}
	
	public boolean isSameTree(TreeNode p, TreeNode q) {
		
		if(null==p && null==q)
			return true;
		
		if((null==p && null!=q) || (null!=p && null==q))
			return false;
		
		if(p.data != q.data) 
			return false;
		
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		
	}

}
