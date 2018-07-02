package com.general.geeks.bits;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.
 * 
 * Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
 * 
 * Could you do this in O(n) runtime?
 * 
 * Example:
 * 
 * Input: [3, 10, 5, 25, 2, 8]
 * 
 * Output: 28
 * 
 * Explanation: The maximum result is 5 ^ 25 = 28.
 * 
 * @author skadavath
 *
 */
public class MaxXorOrTwoNumbersInArray {
	
	public static void main(String[] args) {
		System.out.println(new MaxXorOrTwoNumbersInArray().findMaximumXOR(new int[] {3,10,5,25,2,8}));
	}

	public int findMaximumXOR(int[] nums) {
		
		//like classic two sum problem 
		//calculate and store the mask 
		int max=0,mask=0;
		for(int i=31;i>=0;i--) {
			mask = mask | (1 << i);
			Set<Integer> set = new HashSet<>();
			for(int j : nums) {
				set.add(j & mask);
			}
			int temp = max | (1 << i);
			for(int k : set) {
				if(set.contains(temp ^ k)) {
					max = temp;
					break;
				}
			}
		}
		return max;

	}

}
