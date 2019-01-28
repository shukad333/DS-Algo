package com.general.geeks.misc;

/**
 * Given an integer array nums, find the sum of the elements between indices i
 * and j (i ≤ j), inclusive.
 * 
 * The update(i, val) function modifies nums by updating the element at index i
 * to val.
 * 
 * Example:
 * 
 * Given nums = [1, 3, 5]
 * 
 * sumRange(0, 2) -> 9 update(1, 2) sumRange(0, 2) -> 8 Note:
 * 
 * The array is only modifiable by the update function. You may assume the
 * number of calls to update and sumRange function is distributed evenly.
 * 
 * @author skadavath
 *
 */
public class RangeSumQuery {
	
	public static void main(String[] args) {
		int[] nums = new int[] {1,3,5};
		RangeSumQuery rs = new RangeSumQuery(nums);
		System.out.println(rs.sumRange(0, 2));
		rs.update(1, 2);
		System.out.println(rs.sumRange(0, 2));
	}

	int[] nums;
	public RangeSumQuery(int[] nums) {
		this.nums = nums;
	}

	public void update(int i, int val) {
		nums[i] = val;
	}

	public int sumRange(int i, int j) {
		int sum = 0;
		for (int k = i; k <= j; k++) {
			sum += nums[k];
		}
		return sum;
	}

	/**
	 * Your NumArray object will be instantiated and called as such: NumArray obj =
	 * new NumArray(nums); obj.update(i,val); int param_2 = obj.sumRange(i,j);
	 */

}
