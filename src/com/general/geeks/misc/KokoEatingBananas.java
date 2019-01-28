package com.general.geeks.misc;

import java.util.Arrays;

/**
 * Koko loves to eat bananas. There are N piles of bananas, the i-th pile has
 * piles[i] bananas. The guards have gone and will come back in H hours.
 * 
 * Koko can decide her bananas-per-hour eating speed of K. Each hour, she
 * chooses some pile of bananas, and eats K bananas from that pile. If the pile
 * has less than K bananas, she eats all of them instead, and won't eat any more
 * bananas during this hour.
 * 
 * Koko likes to eat slowly, but still wants to finish eating all the bananas
 * before the guards come back.
 * 
 * Return the minimum integer K such that she can eat all the bananas within H
 * hours.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: piles = [3,6,7,11], H = 8 Output: 4 Example 2:
 * 
 * Input: piles = [30,11,23,4,20], H = 5 Output: 30 Example 3:
 * 
 * Input: piles = [30,11,23,4,20], H = 6 Output: 23
 * 
 * @author skadavath
 *
 */
public class KokoEatingBananas {

	public static void main(String[] args) {
		System.out.println(new KokoEatingBananas().minEatingSpeed(new int[] { 3, 6, 7, 11 }, 8));
	}

	public int minEatingSpeed(int[] piles, int H) {

		Arrays.sort(piles);
		int low = 0,high = piles[piles.length-1];
		while(low<high) {
			int mid = low + (high-low)/2;
			if(eatingCapacity(piles, mid)>H) // means need to eat more
				low = mid+1;
			else //means needs to eat less
				high = mid;
			
		}
		return low;
		
	}
	
	private int eatingCapacity(int[] piles , int step) {
		
		int count = 0;
		for(int pile : piles) {
			count+=Math.ceil((double)pile/step);
		}
		return count;
	}
}
