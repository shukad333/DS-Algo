package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

All numbers will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]

 * 
 * @author skadavath
 *
 */
public class CombinationSum3 {
	
	public static void main(String[] args) {
		
		System.out.println(new CombinationSum3().combinationSum3(3, 7));
		
	}

	public List<List<Integer>> combinationSum3(int k, int n) {
		
		List<List<Integer>> resp = new ArrayList<List<Integer>>();
		dfs(resp, k, n, new ArrayList<>(), 1);
		return resp;
	}
	
	private void dfs(List<List<Integer>> resp , int k , int n,List<Integer> temp,int start) {
		
		if(temp.size()==k && n==0) {
			resp.add(new ArrayList<>(temp));
			return;
		}
		else {
			for(int i=start;i<=9;i++) {
				temp.add(i);
				dfs(resp, k, n-i, temp, i+1);
				temp.remove(temp.size()-1);
			}
			
		}
		
	}

}
