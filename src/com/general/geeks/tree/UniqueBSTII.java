package com.general.geeks.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, generate all structurally unique BST's (binary search
 * trees) that store values 1 ... n.
 * 
 * Example:
 * 
 * Input: 3 Output: [ [1,null,3,2], [3,2,null,1], [3,1,null,null,2], [2,1,3],
 * [1,null,2,null,3] ] Explanation: The above output corresponds to the 5 unique
 * BST's shown below:
 * 
 * 1 3 3 2 1 \ / / / \ \ 3 2 1 1 3 2 / / \ \ 2 1 2 3
 * 
 * @author skadavath
 *
 */
public class UniqueBSTII {
	
	public static void main(String[] args) {
		
		List<TreeNode> node = new UniqueBSTII().generateTrees(3);
		System.out.println(node);
		
	}

	public List<TreeNode> generateTrees(int n) {

		return genTree(1, n);

	}

	private List<TreeNode> genTree(int start, int end) {

		List<TreeNode> res = new ArrayList<TreeNode>();
		if (start > end) {

			res.add(null);
			return res;

		}

		if (start == end) {

			res.add(new TreeNode(start));
			return res;

		}
		
		/**
		 * 
		 * I start by noting that 1..n is the in-order traversal for any BST with nodes
		 * 1 to n. So if I pick i-th node as my root, the left subtree will contain
		 * elements 1 to (i-1), and the right subtree will contain elements (i+1) to n.
		 * I use recursive calls to get back all possible trees for left and right
		 * subtrees and combine them in all possible ways with the root.
		 * 
		 */
		
		for(int i=start;i<=end;i++) {
			List<TreeNode> left = genTree(start, i-1);
			List<TreeNode> right = genTree(i+1, end);
			
			for(TreeNode l : left) {
				for(TreeNode r : right) {
					TreeNode node = new TreeNode(i);
					node.left = l;
					node.right = r;
					res.add(node);
				}
			}
		}
		return res;
	}

}
