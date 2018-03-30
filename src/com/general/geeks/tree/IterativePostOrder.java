package com.general.geeks.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class IterativePostOrder {
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(10);
		node.left = new TreeNode(6);
		node.right = new TreeNode(20);
		node.left.left = new TreeNode(2);
		node.left.right = new TreeNode(8);
		node.right.left = new TreeNode(15);
		node.right.right = new TreeNode(40);
		
		//postOrderRec(node);
		postOrder(node);
		
	}
	
	
	public static void postOrder(TreeNode node) {
		
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		s1.push(node);
		while(!s1.isEmpty()) {
			TreeNode temp = s1.pop();
			s2.push(temp);
			if(temp.left!=null) 
				s1.push(temp.left);
			if(temp.right!=null)
				s1.push(temp.right);
		}
		
		while(!s2.isEmpty()) {
			TreeNode t = s2.pop();
			System.out.println(t.data);
		}
	}
	
	public static void postOrderRec(TreeNode node) {
		if(null==node) {
			return;
		}
		postOrderRec(node.left);
		postOrderRec(node.right);
		System.out.println(node.data);
	}
	
public List<Integer> postorderTraversal(TreeNode root) {
        	
	List<Integer> list = new LinkedList();
	Stack<TreeNode> s1 = new Stack<>();
	Stack<TreeNode> s2 = new Stack<>();
	
	s1.push(root);
	String s = new String();
	
	while(!s1.isEmpty()) {
		
		TreeNode node = s1.pop();
		s2.push(node);
		if(null!=node) {
			s1.push(node.left);
		}
		if(null!=node) {
			s1.push(node.right);
		}
	}
	
	while(!s2.isEmpty()) {
		TreeNode node = s2.pop();
		list.add(node.data);
	}
	
	return list;
    }
}
