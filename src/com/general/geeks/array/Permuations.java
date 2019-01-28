package com.general.geeks.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]

 * @author skadavath
 *
 */
public class Permuations {
	
	public static void main(String[] args) {
		System.out.println(new Permuations().permute(new int[] {1,2,3,4}));
	}

	public List<List<Integer>> permute(int[] nums) {
		
		List<List<Integer>> resp = new ArrayList<>();
		permute(resp, new ArrayList<>(), nums);
		return resp;
	}
	
	private void permute(List<List<Integer>> resp , List<Integer> temp , int[] nums) {
		if(nums.length==temp.size()) {
			resp.add(new ArrayList<>(temp));
		}
		else {
			for(int i=0;i<nums.length;i++) {
				if(temp.contains(nums[i]))
					continue;
				temp.add(nums[i]);
				permute(resp, temp, nums);
				temp.remove(temp.size()-1);
			}
		}
	}

}
