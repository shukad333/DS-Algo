package com.general.geeks.bst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * Given a binary tree with N nodes, each node has a different value from {1, ..., N}.

A node in this binary tree can be flipped by swapping the left child and the right child of that node.

Consider the sequence of N values reported by a preorder traversal starting from the root.  Call such a sequence of N values the voyage of the tree.

(Recall that a preorder traversal of a node means we report the current node's value, then preorder-traverse the left child, then preorder-traverse the right child.)

Our goal is to flip the least number of nodes in the tree so that the voyage of the tree matches the voyage we are given.

If we can do so, then return a list of the values of all nodes flipped.  You may return the answer in any order.

If we cannot do so, then return the list [-1].

 

Example 1:



Input: root = [1,2], voyage = [2,1]
Output: [-1]
Example 2:



Input: root = [1,2,3], voyage = [1,3,2]
Output: [1]
Example 3:



Input: root = [1,2,3], voyage = [1,2,3]
Output: []
 

Note:

1 <= N <= 100
 * 
 * @author skadavath
 *
 */
public class FlipBinaryTreeToMatchPreorderTraversal {
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		System.out.println(new FlipBinaryTreeToMatchPreorderTraversal().flipMatchVoyage(node,new int[] {1,3,2}));
		
	}

	public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
		
		
		List<Integer> resp = new ArrayList<>();
		int r = dfs(root, voyage, resp, 0);
		
		return r==-1?Arrays.asList(-1):resp;

	}
	
	private int dfs(TreeNode node , int[] voyage , List<Integer> resp,int count) {
		
		if(null==node)
			return count;
		if(node.data!=voyage[count])
			return -1;
		
		int left = dfs(node.left, voyage, resp, count+1);
		
		if(left!=-1) {
			return dfs(node.right, voyage, resp, left);
		}
		
		resp.add(node.data);
		
		int right = dfs(node.right, voyage, resp, count+1);
		
		if(right!=-1) {
			return dfs(node.left, voyage, resp, right);
		}
		
		return -1;
		
		
	}

}
