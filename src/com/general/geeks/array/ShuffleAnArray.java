package com.general.geeks.array;

import java.util.Arrays;
import java.util.Random;

/**
 * Shuffle a set of numbers without duplicates.

Example:

// Init an array with set 1, 2, and 3.
int[] nums = {1,2,3};
Solution solution = new Solution(nums);

// Shuffle the array [1,2,3] and return its result. Any permutation of [1,2,3] must equally likely to be returned.
solution.shuffle();

// Resets the array back to its original configuration [1,2,3].
solution.reset();

// Returns the random shuffling of array [1,2,3].
solution.shuffle();

 * @author skadavath
 *
 */
public class ShuffleAnArray {
	
	public static void main(String[] args) {
		ShuffleAnArray s = new ShuffleAnArray(new int[] {1,2,3,4});
		System.out.println(Arrays.toString(s.shuffle()));
		System.out.println();
	}
	
	int[] original;
	int[] arr;
	
	public ShuffleAnArray(int[] nums) {
		this.arr = nums;
		this.original = nums;
	}
	
	 /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        this.arr = original.clone();
        return this.arr;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
    	
    	Random rand = new Random();
    	for(int i=0;i<arr.length;i++) {
    		int r = rand.nextInt(arr.length);
    		int temp = arr[i];
            arr[i] = arr[r];
            arr[r] = temp;
    	}
    	return arr;
        
    }

}
