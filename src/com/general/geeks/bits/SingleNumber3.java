package com.general.geeks.bits;

/**
 * 
 * Given an array of numbers nums, in which exactly two elements appear only
 * once and all the other elements appear exactly twice. Find the two elements
 * that appear only once.
 * 
 * For example:
 * 
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * 
 * Note: The order of the result is not important. So in the above example, [5,
 * 3] is also correct. Your algorithm should run in linear runtime complexity.
 * Could you implement it using only constant space complexity?
 * 
 * @author skadavath
 *
 */
public class SingleNumber3 {
	
	public static void main(String[] args) {
		
		int[] nums = {1,2,1,3,2,5};
		int[] resp = new SingleNumber3().singleNumber(nums);
		for(int i : resp) {
			System.out.print(i+" ");
		}
	}
	public int[] singleNumber(int[] nums) {
		
		int diff = 0;
		for(int i : nums) {
			diff ^= i;
		}
		
		System.out.println(Integer.toBinaryString(diff));
		System.out.println(Integer.toBinaryString(-diff));
		diff &= -diff;
		System.out.println(Integer.toBinaryString(diff));
		
		int[] op = {0,0};
		for(int i : nums) {
			if((i&diff)==0) {
				op[0] ^= i;
			}
			else  {
				op[1] ^= i;
			}
		}
		
		return op;
	}

}
