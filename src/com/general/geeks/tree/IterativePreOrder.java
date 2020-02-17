package com.general.geeks.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

class Abc {
	
	int data;
}
public class IterativePreOrder {
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(10);
		node.left = new TreeNode(6);
		node.right = new TreeNode(20);
		node.left.left = new TreeNode(2);
		node.left.right = new TreeNode(8);
		node.right.left = new TreeNode(15);
		node.right.right = new TreeNode(40);
		
		inorderRecursive(node);
		//preOrder(node);
		
		
		
		
	}
	
	public static void preOrder(TreeNode node) {
		
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
		
		inorderRecursive(node.left);;
		System.out.println(node.data);
		
		inorderRecursive(node.right);
	}
	
public List<Integer> preorderTraversal(TreeNode root) {
	
	List<Integer> list = new LinkedList();
	Stack<TreeNode> stack = new Stack<>();
	stack.push(root);
	while(!stack.isEmpty()) {
		
		TreeNode node = stack.pop();
		
		if(null!=node) {
			list.add(node.data);
			stack.push(node.right);
			stack.push(node.left);
		}
		
	}
	
	return list;
        
    }

}
