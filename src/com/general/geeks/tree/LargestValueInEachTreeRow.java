package com.general.geeks.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * You need to find the largest value in each row of a binary tree.
 * 
 * Example: Input:
 * 
 * 1 / \ 3 2 / \ \ 5 3 9
 * 
 * Output: [1, 3, 9]
 * 
 * @author skadavath
 *
 */
public class LargestValueInEachTreeRow {
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(3);
		node.right = new TreeNode(2);
		node.left.left = new TreeNode(5);
		node.left.right = new TreeNode(6);
		node.right.left = new TreeNode(10);
		
		List<Integer> vals = new LargestValueInEachTreeRow().largestValues(node);
		System.out.println(vals);
	}

	public List<Integer> largestValues(TreeNode root) {

		List<Integer> val = new ArrayList();
		largestValue(root, 0, val);
		return val;

	}
	
	private void largestValue(TreeNode root , int level,List<Integer> val) {
		
		if(null == root) {
			return;
		}
		
		if(level == val.size()) {
			val.add(root.data);
		}
		else {
			val.set(level, Math.max(root.data, val.get(level)));
		}
		
		largestValue(root.left, level+1, val);
		largestValue(root.right, level+1, val);
	}

}
