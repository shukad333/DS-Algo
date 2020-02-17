package com.general.geeks.bst;

/**
 * 
 * Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.

For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.

Return the sum of these numbers.

Input: [1,0,1,0,1,0,1]
Output: 22
Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22

 * 
 * @author skadavath
 *
 */
public class SumOfRootToLeafBinaryNumbers {
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(0);
		node.right = new TreeNode(1);
		node.left.right = new TreeNode(1);
		node.left.left = new TreeNode(0);
		node.right.right = new TreeNode(1);
		node.right.left = new TreeNode(0);
		
		
		System.out.println(new SumOfRootToLeafBinaryNumbers().sumRootToLeaf(node));
		
	}

	public int sumRootToLeaf(TreeNode root) {
		
		return binarySum(root, 0);

	}
	
	int mod = 1000_000_00_7;
	private int binarySum(TreeNode root , int parentVal) {
		
		if(null==root)
			return 0;
		if(null==root.left && null==root.right) {
			return parentVal*2+root.data;
		}
		
		int curr = parentVal*2+root.data;
		
		int sum = binarySum(root.left, curr)+binarySum(root.right, curr);
		
		return sum%mod;
		
	}

}
