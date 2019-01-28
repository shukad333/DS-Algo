package com.general.geeks.misc;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given two arrays A and B of equal size, the advantage of A with respect to B
 * is the number of indices i for which A[i] > B[i].
 * 
 * Return any permutation of A that maximizes its advantage with respect to B.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: A = [2,7,11,15], B = [1,10,4,11] Output: [2,11,7,15] Example 2:
 * 
 * Input: A = [12,24,8,32], B = [13,25,32,11] Output: [24,32,8,12]
 * 
 * 
 * 
 * @author skadavath
 *
 */
public class AdvantageShuffle {
	
	public static void main(String[] args) {
		int[] A = {2,7,11,15};
		int[] B = {1,10,4,11};
		
		System.out.println(Arrays.toString(new AdvantageShuffle().advantageCount(A, B)));
		
	}

	public int[] advantageCount(int[] A, int[] B) {
		
		int[] resp = new int[A.length];
		
		Arrays.sort(A);
		PriorityQueue<int[]> bQueue = new PriorityQueue<>((a,b) -> b[0]-a[0]);
		
		for(int i=0;i<B.length;i++) {
			bQueue.offer(new int[] {B[i],i});
		}
		
		int low=0;
		int high = A.length-1;
		while(!bQueue.isEmpty()) {
			int[] poll = bQueue.poll();
			int index = poll[1];
			int val = poll[0];
			
			if(A[high]>val) {
				resp[index] = A[high--];
			}
			else {
				resp[index] = A[low++];
			}
		}
		return resp;
		

	}

}
