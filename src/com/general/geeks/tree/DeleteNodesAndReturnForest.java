package com.general.geeks.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).

Return the roots of the trees in the remaining forest.  You may return the result in any order.

 

Example 1:

Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
Output: [[1,2,null,4],[6],[7]]
 * 
 * @author skadavath
 *
 */
public class DeleteNodesAndReturnForest {

	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		
		Set<Integer> set = new HashSet<>();
		for(int d : to_delete)
			set.add(d);
		
		List<TreeNode> forest = new ArrayList<>();
		helper(root,set,forest);
		
		if(!set.contains(root.data))
			forest.add(root);
		
		return forest;
		

	}
	
	private TreeNode helper(TreeNode root , Set<Integer> items,List<TreeNode> forest) {
		
		if(null==root)
			return null;
		
		root.left = helper(root.left,items,forest);
		root.right = helper(root.right,items,forest);
		
		if(items.contains(root.data)) {
			if(root.left!=null)forest.add(root.left);
			if(root.right!=null)forest.add(root.right);
			return null;
		}
		
		return root;
		
	}

}
