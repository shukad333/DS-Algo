package com.general.geeks.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class HeightOfTreeIterative {
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(10);
		node.left = new TreeNode(5);
		node.left.left = new TreeNode(100);
		System.out.println(new HeightOfTreeIterative().heightIfTree(node));
	}
	
	public int heightIfTree(TreeNode node) {
		
		Queue<TreeNode> queue = new LinkedList();
		queue.add(node);
		int height = 0;
		while(true) {
			
			
			
			
			int currentSize = queue.size();
			if(currentSize==0) {
				return height;
			}
			height++;
			while(currentSize>0) {
				
				TreeNode temp = queue.poll();
				if(temp.left!=null)
					queue.add(temp.left);
				if(temp.right!=null)
					queue.add(temp.right);
				currentSize--;
			}
			
		}
		
	}
	

}
