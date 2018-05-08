package com.general.geeks.tree;

public class SumOfLeftLeaves {
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(34);
		node.left.right = new TreeNode(2);
		node.left.right.left = new TreeNode(6);
		node.right = new TreeNode(100);
		node.right.left = new TreeNode(4);
		
		System.out.println(new SumOfLeftLeaves().sumOfLeftLeaves(node));
	}

	public int sumOfLeftLeaves(TreeNode root) {
		
		int res = 0;
		
		if(null!=root) {
			if(isLeaf(root.left)) {
				res+=root.left.data;
			}
			else
				res+=sumOfLeftLeaves(root.left);
			
			res+=sumOfLeftLeaves(root.right);
		}
		
		return res;
	}

	private boolean isLeaf(TreeNode node) {
		if (null == node) {
			return false;
		}

		if (null == node.left && null == node.right) {
			return true;
		}

		return false;
	}
}
