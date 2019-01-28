package com.general.geeks.array;

import java.util.Arrays;

/**
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such arrangement is not possible, it must rearrange it as the lowest
 * possible order (ie, sorted in ascending order).
 * 
 * The replacement must be in-place and use only constant extra memory.
 * 
 * Here are some examples. Inputs are in the left-hand column and its
 * corresponding outputs are in the right-hand column.
 * 
 * 1,2,3 → 1,3,2 3,2,1 → 1,2,3 1,1,5 → 1,5,1
 * 
 * @author skadavath
 *
 */
public class NextPermutation {

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 3, 2 };
		new NextPermutation().nextPermutation(nums);
		System.out.println(Arrays.toString(nums));
	}

	/**
	 * I) Traverse the given number from rightmost digit, keep traversing till you
	 * find a digit which is smaller than the previously traversed digit. For
	 * example, if the input number is “534976”, we stop at 4 because 4 is smaller
	 * than next digit 9. If we do not find such a digit, then output is “Not
	 * Possible”.
	 * 
	 * II) Now search the right side of above found digit ‘d’ for the smallest digit
	 * greater than ‘d’. For “534976″, the right side of 4 contains “976”. The
	 * smallest digit greater than 4 is 6.
	 * 
	 * III) Swap the above found two digits, we get 536974 in above example.
	 * 
	 * IV) Now sort all digits from position next to ‘d’ to the end of number. The
	 * number that we get after sorting is the output. For above example, we sort
	 * digits in bold 536974. We get “536479” which is the next greater number for
	 * input 534976.
	 * 
	 * @param nums
	 */
	public void nextPermutation(int[] nums) {

		int i = nums.length - 1;
		for (; i > 0; i--) {
			if (nums[i] > nums[i - 1]) {
				break;
			}
		}

		if (i == 0)
			Arrays.sort(nums);
		else {
			i--;
			int found = nums[i];
			int min = i + 1;
			for (int j = nums.length - 1; j > i; j--) {
				if (nums[j] > found && nums[j] < nums[min])
					min = j;
			}
			swap(nums, i, min);
			Arrays.sort(nums, i + 1, nums.length);
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
