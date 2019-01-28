package com.general.geeks.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Consider all the leaves of a binary tree. From left to right order, the
 * values of those leaves form a leaf value sequence.
 * 
 * 
 * 
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9,
 * 8).
 * 
 * Two binary trees are considered leaf-similar if their leaf value sequence is
 * the same.
 * 
 * Return true if and only if the two given trees with head nodes root1 and
 * root2 are leaf-similar.
 * 
 * 
 * @author skadavath
 *
 */
public class LeafSimilarTrees {
	
	
	public static void main(String[] args) {
		
		TreeNode n1 = new TreeNode(1);
		n1.left = new TreeNode(5);
		n1.right = new TreeNode(15);
		
		
		TreeNode n2 = new TreeNode(100);
		n2.left = new TreeNode(5);
		n2.right = new TreeNode(150);
		
		System.out.println(new LeafSimilarTrees().leafSimilar(n1, n2));
		
	}

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		
		getLeafSequence(l1, root1);
		getLeafSequence(l2, root2);
		
		return l1.equals(l2);
	}
	
	private void getLeafSequence(List<Integer> list , TreeNode node) {
		if(null==node)
			return;
		if(null==node.left && null==node.right)
			list.add(node.data);
		if(null!=node.left)
		getLeafSequence(list, node.left);
		
		if(null!=node.right)
		getLeafSequence(list, node.right);
	}

}
