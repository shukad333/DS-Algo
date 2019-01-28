package com.general.geeks.bst;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Given a binary tree, write a function to get the maximum width of the given
 * tree. The width of a tree is the maximum width among all levels. The binary
 * tree has the same structure as a full binary tree, but some nodes are null.
 * 
 * The width of one level is defined as the length between the end-nodes (the
 * leftmost and right most non-null nodes in the level, where the null nodes
 * between the end-nodes are also counted into the length calculation.
 * 
 * Example 1: Input:
 * 
 * 1 / \ 3 2 / \ \ 5 3 9
 * 
 * Output: 4 Explanation: The maximum width existing in the third level with the
 * length 4 (5,3,null,9). Example 2: Input:
 * 
 * 1 / 3 / \ 5 3
 * 
 * Output: 2 Explanation: The maximum width existing in the third level with the
 * length 2 (5,3). Example 3: Input:
 * 
 * 1 / \ 3 2 / 5
 * 
 * Output: 2 Explanation: The maximum width existing in the second level with
 * the length 2 (3,2). Example 4: Input:
 * 
 * 1 / \ 3 2 / \ 5 9 / \ 6 7 Output: 8 Explanation:The maximum width existing in
 * the fourth level with the length 8 (6,null,null,null,null,null,null,7).
 * 
 * 
 * Note: Answer will in the range of 32-bit signed integer.
 * 
 * @author skadavath
 *
 */
public class WidthOfABinaryTree {

	public static void main(String[] args) {
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.right.right = new TreeNode(5);
		node.right.left = new TreeNode(10);
		node.left.left = new TreeNode(22);
		System.out.println(new WidthOfABinaryTree().widthOfBinaryTree(node));
	}

	public int widthOfBinaryTree(TreeNode root) {

		Map<TreeNode, Integer> map = new HashMap<>();
		Queue<TreeNode> queue = new LinkedList<>();
		map.put(root, 1);
		queue.offer(root);
		
		int maxWidth = 0;
		while (!queue.isEmpty()) {

			int startIndex = 0;
			int endIndex = 0;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode pop = queue.poll();

				if (i == 0)
					startIndex = map.get(pop);
				if (i == size - 1)
					endIndex = map.get(pop);

				if (null != pop.left) {
					map.put(pop.left, 2 * map.get(pop));
					queue.add(pop.left);
				}

				if (null != pop.right) {
					map.put(pop.right, 2 * map.get(pop) + 1);
					queue.add(pop.right);
				}
				
				maxWidth = Math.max(endIndex-startIndex+1, maxWidth);

			}
			System.out.println();
		}
		return maxWidth;

	}

}
