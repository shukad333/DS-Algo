package com.general.geeks.bst;

import com.general.geeks.tree.MaxDepth;

/**
 * Given a binary tree rooted at root, the depth of each node is the shortest
 * distance to the root.
 * 
 * A node is deepest if it has the largest depth possible among any node in the
 * entire tree.
 * 
 * The subtree of a node is that node, plus the set of all descendants of that
 * node.
 * 
 * Return the node with the largest depth such that it contains all the deepest
 * nodes in it's subtree.
 * 
 * @author skadavath
 *
 */
public class SmallestSubtreeWithDeepestNodes {
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(5);
		node.right = new TreeNode(1);
		node.left.left = new TreeNode(6);
		node.left.right = new TreeNode(2);
		node.left.right.left = new TreeNode(8);
		node.right.left = new TreeNode(0);
		
		TreeNode res = new SmallestSubtreeWithDeepestNodes().subtreeWithAllDeepest(node);
		System.out.println(res.data);
	}

	public TreeNode subtreeWithAllDeepest(TreeNode root) {

		int[] maxValue = new int[] {Integer.MIN_VALUE};
		TreeNode[] resp = new TreeNode[1];
		getDeepestNode(root, resp, maxValue,0);
		return resp[0];

	}

	private int getDeepestNode(TreeNode root, TreeNode[] res, int[] maxValue,int depth) {

		if (null == root)
			return depth;
		int left = getDeepestNode(root.left, res, maxValue,depth+1);
		int right = getDeepestNode(root.right, res, maxValue,depth+1);

		if (left == right && left >= maxValue[0]) {
			res[0] = root;
			maxValue[0] = left;
		}

		return Math.max(left, right);

	}
}
