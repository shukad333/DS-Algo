package com.general.geeks.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SearchForKeyInSortedTree {
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.left = new TreeNode(4);
		node.left.right = new TreeNode(5);
		node.right.left = new TreeNode(6);
		node.right.right = new TreeNode(7);
		System.out.println(new SearchForKeyInSortedTree().isPresent(node, 10));
	}
	
	public boolean isPresent(TreeNode node,int key) {
		
		Queue<TreeNode> queue = new LinkedList();
		queue.add(node);
		
		while(!queue.isEmpty()) {
			TreeNode temp = queue.poll();
			if(temp.data==key)
				return true;
			if(null!=temp.left)
				queue.add(temp.left);
			if(null!=temp.right)
				queue.add(temp.right);
		}
		
		return false;
	}

}
