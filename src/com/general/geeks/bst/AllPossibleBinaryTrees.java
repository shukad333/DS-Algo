package com.general.geeks.bst;

import java.util.ArrayList;
import java.util.List;

/**
 * A full binary tree is a binary tree where each node has exactly 0 or 2
 * children.
 * 
 * Return a list of all possible full binary trees with N nodes. Each element of
 * the answer is the root node of one possible tree.
 * 
 * Each node of each tree in the answer must have node.val = 0.
 * 
 * You may return the final list of trees in any order.
 * 
 * 
 * @author skadavath
 *
 */
public class AllPossibleBinaryTrees {
	
	public List<TreeNode> allPossibleFBT(int N) {
		
		List<TreeNode> resp = new ArrayList<>();
		
		if(N==1) {
			TreeNode node = new TreeNode(0);
			resp.add(node);
			return resp;
		}
		
		for(int i=1;i<N-1;i++) {
			List<TreeNode> left = allPossibleFBT(i);
			List<TreeNode> right = allPossibleFBT(N-i-1);
			for(TreeNode l : left) {
				for(TreeNode r : right) {
					TreeNode curr = new TreeNode(0);
					curr.left = l;
					curr.right = r;
					resp.add(curr);
				}
			}
		}
		
		return resp;

	}

}
