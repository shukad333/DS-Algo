package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
Accepted
169,962
Submissions
383,748
 * 
 * @author skadavath
 *
 */
public class Combinations {
	
	public static void main(String[] args) {
		
		System.out.println(new Combinations().combine(4, 2));
		
	}

	public List<List<Integer>> combine(int n, int k) {
		
		List<List<Integer>> resp = new ArrayList<>();
		combination(resp, new ArrayList<>(), n, k, 1);
		return resp;

	}
	
	private void combination(List<List<Integer>> resp , List<Integer> temp , int n , int k , int index) {
		
		if(temp.size()==k) {
			resp.add(new ArrayList<>(temp));
			return;
		}
		
		for(int i=index;i<=n;i++) {
			
			temp.add(i);
			combination(resp, temp, n, k, i+1);
			temp.remove(temp.size()-1);//remove last added
			
		}
	}

}
