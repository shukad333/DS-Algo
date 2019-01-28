package com.general.geeks.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Invert a binary tree.
 * 
 * Example:
 * 
 * Input:
 * 
 * 4 / \ 2 7 / \ / \ 1 3 6 9 Output:
 * 
 * 4 / \ 7 2 / \ / \ 9 6 3 1
 * 
 * @author skadavath
 *
 */
public class InvertBinaryTree {
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		
		new InvertBinaryTree()._invertTreeQueue(node);
		System.out.println(node.left.data+" "+node.right.data);
	}

	public TreeNode invertTree(TreeNode root) {
		
		if(null == root) {
			return null;
		}
		
		TreeNode temp = root.left;
		root.left = invertTree(root.right);
		root.right = invertTree(temp);
		return root;

	}
	
	public TreeNode _invertTreeStack(TreeNode root) {
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			
			TreeNode polled = stack.pop();
			TreeNode left = polled.left;
			polled.left = polled.right;
			polled.right = left;
			
			if(polled.left!=null)
				stack.push(polled.left);
			
			if(polled.right!=null)
				stack.push(polled.right);
			
		}
		
		return root;
		
	}
	
	public TreeNode _invertTreeQueue(TreeNode root) {
		
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			
			TreeNode polled = queue.poll();
			TreeNode left = polled.left;
			polled.left = polled.right;
			polled.right = left;
			
			if(polled.left!=null)
				queue.offer(polled.left);
			
			if(polled.right!=null)
				queue.offer(polled.right);
			
		}
		
		return root;
	}

}
