package com.general.geeks.misc;

/**
 * 
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.

Return 0 if the array contains less than 2 elements.

Example 1:

Input: [3,6,9,1]
Output: 3
Explanation: The sorted form of the array is [1,3,6,9], either
             (3,6) or (6,9) has the maximum difference 3.
Example 2:

Input: [10]
Output: 0
Explanation: The array contains less than 2 elements, therefore return 0.
Note:

You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
Try to solve it in linear time/space.
Accepted
68,108
Submissions
211,565
 * 
 * @author skadavath
 *
 */
public class MaximumGap {
	
	public static void main(String[] args) {
		
		System.out.println(new MaximumGap().maximumGap(new int[] {10,90,300,60}));
		
	}

	public int maximumGap(int[] nums) {
	    if (nums == null || nums.length < 2) {
	        return 0;
	    }
	    
	    // m is the maximal number in nums
	    int m = nums[0];
	    for (int i = 1; i < nums.length; i++) {
	        m = Math.max(m, nums[i]);
	    }
	    
	    int exp = 1; // 1, 10, 100, 1000 ...
	    int R = 10; // 10 digits

	    int[] aux = new int[nums.length];
	    
	    while (m / exp > 0) { // Go through all digits from LSB to MSB
	        int[] count = new int[R];
	        
	        for (int i = 0; i < nums.length; i++) {
	            count[(nums[i] / exp) % 10]++;
	        }
	        
	        for (int i = 1; i < count.length; i++) {
	            count[i] += count[i - 1];
	        }
	        
	        for (int i = nums.length - 1; i >= 0; i--) {
	            aux[--count[(nums[i] / exp) % 10]] = nums[i];
	        }
	        
	        for (int i = 0; i < nums.length; i++) {
	            nums[i] = aux[i];
	        }
	        exp *= 10;
	    }
	    
	    int max = 0;
	    for (int i = 1; i < aux.length; i++) {
	        max = Math.max(max, aux[i] - aux[i - 1]);
	    }
	     
	    return max;
	}

}
