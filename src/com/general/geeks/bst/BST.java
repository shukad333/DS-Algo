package com.general.geeks.bst;

import java.util.ArrayList;
import java.util.List;

public class BST {

	TreeNode root;

	public BST() {

		this.root = null;
	}

	public void push(int data) {
		root = insertRec(root, data);

	}

	public TreeNode insertRec(TreeNode node, int key) {
		if (null == node) {
			node = new TreeNode(key);
			return node;
		}
		if (key < node.data) {
			node.left = insertRec(node.left, key);
		} else {
			node.right = insertRec(node.right, key);
		}
		return node;
	}
	
	public void preOrder(TreeNode node) {
		if(node==null)
			return;
		
		System.out.println(node.data);
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public void inOrder(TreeNode node) {
		if(null==node)
			return;
		
		inOrder(node.left);
		System.out.println(node.data);
		inOrder(node.right);
	}
	
	public static void main(String[] args) {
		
		BST bst = new BST();
		bst.push(10);
		bst.push(5);
		bst.push(1);
		bst.push(100);
		bst.preOrder(bst.root);
		bst.inOrder(bst.root);
		
		
			List<String> l = new ArrayList<>();
			for(String s : l) {
				System.out.println(s);
		
		
	}
	}
}

class TreeNode {
	int data;
	TreeNode left;
	TreeNode right;

	public TreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
