package com.general.geeks.tree;

import java.util.ArrayList;
import java.util.List;

public class ZigZag {
	
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(100);
		node.left = new TreeNode(20);
		node.right = new TreeNode(80);
		node.left.left = new TreeNode(10);
		node.left.right = new TreeNode(1000);
		List<List<Integer>> lists = new ZigZag().zigzagLevelOrder(node);
		
		for(List<Integer> l : lists) {
			for(Integer i : l) {
				System.out.print(i+" ");
			}
			
			System.out.println();
		}
	}
	
		public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
			List<List<Integer>> lists = new ArrayList();
			int height = height(root);
			boolean direction = true;
			for(int i=1;i<=height;i++) {
				
				List<Integer> list = new ArrayList();
				zigzag(root, list, i, direction);
				lists.add(list);
				direction = !direction;
				
			}
			
			return lists;
			
		}
		
		private void zigzag(TreeNode node , List<Integer> list,int level, boolean direction) {
			
			if(null == node) {
				return;
			}
			
			
			if(1 == level) {
				list.add(node.data);
				return;
			}
			
			
			if(direction) {
				zigzag(node.left, list, level-1, direction);
				zigzag(node.right, list, level-1, direction);
			}
			else {
				zigzag(node.right, list, level-1, direction);
				zigzag(node.left, list, level-1, direction);
			}
			
		}
		private int height(TreeNode node) {
			
			if(null==node) {
				return 0;
			}
			
			return 1+Math.max(height(node.left), height(node.right));
		}

}
