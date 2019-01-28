package com.general.geeks.bst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.
Example 1:
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
Note:
The range of node's value is in the range of 32-bit signed integer.

 * @author skadavath
 *
 */
public class AverageOfLevelsInBinaryTree {
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(12);
		node.right = new TreeNode(14);
		node.left.right = new TreeNode(100);
		node.right.left = new TreeNode(50);
		
		List<Double> resp = new AverageOfLevelsInBinaryTree().averageOfLevels(node);
		System.out.println(resp);
	}

	public List<Double> averageOfLevels(TreeNode root) {
		
		List<Double> resp = new ArrayList<>();
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			Double sum = 0d;
			
			for(int i=0;i<size;i++) {
				TreeNode poll = queue.poll();
				sum+=poll.data;
				
				if(null!=poll.left)
					queue.offer(poll.left);
				if(null!=poll.right)
					queue.offer(poll.right);
			}
			resp.add(sum/size);
		}
		
		return resp;

	}

}
