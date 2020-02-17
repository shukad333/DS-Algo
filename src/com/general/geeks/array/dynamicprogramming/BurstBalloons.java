package com.general.geeks.array.dynamicprogramming;

/**
 * 
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Note:

You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
Example:

Input: [3,1,5,8]
Output: 167 
Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
             coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167

 * 
 * @author skadavath
 *
 */
public class BurstBalloons {
	
	public static void main(String[] args) {
		
		
		System.out.println(new BurstBalloons().maxCoins(new int[] {3,1,5,8}));
		
	}

	public int maxCoins(int[] nums) {
		
		int[] numsArray = new int[nums.length+2];
		int index=1;
		for(int i : nums)
			if(i>0)
				numsArray[index++] = i;
		
		numsArray[0] = numsArray[index++] = 1;
		
		return getMax(new int[index][index], numsArray, 0, index-1);

	}
	
	private int getMax(int[][] dp , int[] nums,int left,int right) {
		
		if(left+1==right)
			return 0;
		
		if(dp[left][right]>0)
			return dp[left][right];
		int ans = 0;
		
		for(int i=left+1;i<right;i++) {
			
			ans = Math.max(ans, nums[left]*nums[i]*nums[right] +  getMax(dp, nums, left, i) + getMax(dp, nums, i, right));
			
		}
			dp[left][right] = ans;
		
		
		return ans;
		
		
		
	}

}
