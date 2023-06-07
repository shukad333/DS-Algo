package com.general.geeks.tree;

import java.util.Stack;

public class IterativeInorder {
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(10);
		node.left = new TreeNode(6);
		node.right = new TreeNode(20);
		node.left.left = new TreeNode(2);
		node.left.right = new TreeNode(8);
		node.right.right = new TreeNode(18);
		node.right.left = new TreeNode(28);
		node.right.left.left = new TreeNode(128);
		String s;

		printInorder(node);
		
		
	}

	public static void printInorder(TreeNode node) {

		Stack<TreeNode> stack = new Stack<>();
		while (null != node) {
			stack.push(node);
			node = node.left;
		}
		while (!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			System.out.println(temp.data);
			if (temp.right != null) {
				temp = temp.right;
				while (temp != null) {
					stack.push(temp);
					temp = temp.left;
					
				}
			}
		}
	}
}
