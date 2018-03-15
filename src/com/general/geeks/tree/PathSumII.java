package com.general.geeks.tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(10);
		node.left = new TreeNode(5);
		node.right = new TreeNode(3);
		node.left.left = new TreeNode(7);
		node.left.right = new TreeNode(6);
		node.right.left = new TreeNode(9);
		
		List<List<Integer>> result = new PathSumII().pathSum(node,22);
		for(List<Integer> l : result) {
			for(Integer i : l) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}
	
	
	public List<List<Integer>> pathSum(TreeNode node,int sum) {
		
		List<List<Integer>> result = new ArrayList();
		if(null == node) {
			return result;
		}
		
		List<Integer> list = new ArrayList();
		list.add(node.data);
		dfs(node,sum-node.data,result,list);
		return result;
		
	}
	
	public void dfs(TreeNode node , int sum , List<List<Integer>> result , List<Integer> list) {
		
		if(null!=node) {
			if(null==node.left && null==node.right && 0==sum) {
				//create a temp arraylist .. Needed coz if we add directly , and remove the items from list later
				//it will remove from the result as well .
				List<Integer> temp = new ArrayList();
				temp.addAll(list);
				result.add(temp);
				//return;
			}
			
			if(null!=node.left) {
				list.add(node.left.data);
				dfs(node.left,sum-node.left.data,result,list);
				list.remove(list.size()-1);
			}
			
			if(null!=node.right) {
				list.add(node.right.data);
				dfs(node.right,sum-node.right.data,result,list);
				list.remove(list.size()-1);
			}
		}
	}
	
	
}
