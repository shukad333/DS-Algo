package com.general.geeks.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTreeIterative {
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(100);
		node.left = new TreeNode(200);
		node.right = new TreeNode(200);
		node.left.left = new TreeNode(25);
		node.right.right = new TreeNode(25);
		node.left.right = new TreeNode(75);
		node.right.left = new TreeNode(75);
		
		System.out.println(new SymmetricTreeIterative().isSymmetric(node));
	}
	
	public boolean isSymmetric(TreeNode root) {
		
		// a null tree is symmetric - my weird assumption bro
		if(null==root) {
			return true;
		}
		Queue<TreeNode> queue = new LinkedList();
		queue.add(root.left);
		queue.add(root.right);
		
		while(!queue.isEmpty()) {
			
			TreeNode node1 = queue.remove();
			TreeNode node2 = queue.remove();
			
			if(null==node1 && null==node2) {
				continue;
			}
			
			if ((null==node1 && null!=node2) || (null!=node1 && null==node2)) {
				return false;
			}
			
			if(node1.data!=node2.data) {
				return false;
			}
			
			queue.add(node1.left);
			queue.add(node2.right);
			queue.add(node1.right);
			queue.add(node2.left);
		}
		return true;
	}
}
