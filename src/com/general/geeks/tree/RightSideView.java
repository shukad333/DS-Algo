package com.general.geeks.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

 * @author skadavath
 *
 */
public class RightSideView {
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.right = new TreeNode(4);
		
		List<Integer> resp = new RightSideView().rightSideView(node);
		System.out.println(resp);
		
	}
	
	public List<Integer> rightSideView(TreeNode root) {
		
		int[] maxLevel = new int[] {0};
		List<Integer> resp = new ArrayList();
		getRightView(root, resp, 1, maxLevel);
		return resp;

	}

	private void getRightView(TreeNode node, List<Integer> resp, int level, int[] maxLevel) {

		if (null == node) {
			return ;
		}

		if (maxLevel[0] < level) {
			maxLevel[0] = level;
			resp.add(node.data);
		}

		getRightView(node.right, resp, level + 1, maxLevel);
		getRightView(node.left, resp, level + 1, maxLevel);

	}
	

}