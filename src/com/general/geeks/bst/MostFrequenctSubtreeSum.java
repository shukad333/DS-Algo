package com.general.geeks.bst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given the root of a tree, you are asked to find the most frequent subtree
 * sum. The subtree sum of a node is defined as the sum of all the node values
 * formed by the subtree rooted at that node (including the node itself). So
 * what is the most frequent subtree sum value? If there is a tie, return all
 * the values with the highest frequency in any order.
 * 
 * Examples 1 Input:
 * 
 * 5 / \ 2 -3 return [2, -3, 4], since all the values happen only once, return
 * all of them in any order. Examples 2 Input:
 * 
 * 5 / \ 2 -5 return [2], since 2 happens twice, however -5 only occur once.
 * Note: You may assume the sum of values in any subtree is in the range of
 * 32-bit signed integer.
 * 
 * @author skadavath
 *
 */
public class MostFrequenctSubtreeSum {
	
	public static void main(String[] args) {
		
		TreeNode node = new TreeNode(5);
		node.left = new TreeNode(2);
		node.right = new TreeNode(-3);
		
		System.out.println(Arrays.toString(new MostFrequenctSubtreeSum().findFrequentTreeSum(node)));
	}

	public int[] findFrequentTreeSum(TreeNode root) {
		
		Map<Integer, Integer> map = new HashMap<>();
		int[] maxCount = new int[1];
		
		List<Integer> resp = new ArrayList<>();
		postOrderAndCount(root, map, maxCount);
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if(entry.getValue()==maxCount[0]) {
				resp.add(entry.getKey());
			}
		}
		int[] r =  new int[resp.size()];
		for(int i=0;i<resp.size();i++) {
			r[i] = resp.get(i);
		}
		return r;
	}
	
	
	private int postOrderAndCount(TreeNode root,Map<Integer, Integer> map,int[] maxCount) {
		
		if(null==root)
			return 0;
		
		int left = postOrderAndCount(root.left,map,maxCount);
		int right = postOrderAndCount(root.right,map,maxCount);
		
		int val = left+right + root.data;
		
		map.putIfAbsent(val, 0);
		map.put(val,map.get(val)+1);
		
		maxCount[0] = Math.max(maxCount[0], map.get(val));
		
		return val;
		
	}

}
