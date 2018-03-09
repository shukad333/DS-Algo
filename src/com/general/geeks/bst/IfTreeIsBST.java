package com.general.geeks.bst;

public class IfTreeIsBST {
	
	public boolean validate(TreeNode node , int min, int max) {
		
		if(null==node)
			return true;
		if(node.data<min || node.data>max)
			return false;
		return validate(node.left,min,node.data-1) && validate(node.right,node.data+1,max);
		
	}
}
