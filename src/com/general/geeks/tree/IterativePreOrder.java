package com.general.geeks.tree;

import java.util.Stack;

public class IterativePreOrder {
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(10);
		node.left = new TreeNode(6);
		node.right = new TreeNode(20);
		node.left.left = new TreeNode(2);
		node.left.right = new TreeNode(8);
		node.right.left = new TreeNode(15);
		node.right.right = new TreeNode(40);
		
		//inorderRecursive(node);
		inOrder(node);
		
	}
	
	public static void inOrder(TreeNode node) {
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(node);
		while(!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			if(null!=temp) {
			System.out.println(temp.data);
			stack.push(temp.right);
			stack.push(temp.left);
			}
			
		}
		
	}
	
	public static void inorderRecursive(TreeNode node) {
		if(null==node)
			return;
		System.out.println(node.data);
		inorderRecursive(node.left);;
		inorderRecursive(node.right);
	}

}
