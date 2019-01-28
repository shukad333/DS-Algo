package com.general.geeks.bst;

/**
 * Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.

Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.

Example 1:
Input: 
    2
   / \
  2   5
     / \
    5   7

Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.
Example 2:
Input: 
    2
   / \
  2   2

Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.

 * @author skadavath
 *
 */
public class SecondMinimumNodeInABinaryTree {
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(2);
		node.left = new TreeNode(2);
		node.right = new TreeNode(1);
		node.left.left = new TreeNode(1);
		System.out.println(new SecondMinimumNodeInABinaryTree().findSecondMinimumValue(node));
	}
	
	public int findSecondMinimumValue(TreeNode root) {
		
		int[] resp = new int[] {Integer.MAX_VALUE,-1};
		findMin(root, resp);
		if(resp[1]==Integer.MAX_VALUE) {
			return -1;
		}
		return resp[1];
	}
	
	private void findMin(TreeNode root , int[] res) {
		if(null == root) {
			return;
		}
		
		if(root.data<res[0]) {
			res[1] = res[0];
			res[0] = root.data;
		}
		findMin(root.left, res);
		findMin(root.right,res);
	}

}
