package com.general.geeks.array;

import java.util.Arrays;

/**
 * 
 * Given an array A of 0s and 1s, divide the array into 3 non-empty parts such
 * that all of these parts represent the same binary value.
 * 
 * If it is possible, return any [i, j] with i+1 < j, such that:
 * 
 * A[0], A[1], ..., A[i] is the first part; A[i+1], A[i+2], ..., A[j-1] is the
 * second part, and A[j], A[j+1], ..., A[A.length - 1] is the third part. All
 * three parts have equal binary value. If it is not possible, return [-1, -1].
 * 
 * Note that the entire part is used when considering what binary value it
 * represents. For example, [1,1,0] represents 6 in decimal, not 3. Also,
 * leading zeros are allowed, so [0,1,1] and [1,1] represent the same value.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [1,0,1,0,1] Output: [0,3] Example 2:
 * 
 * Input: [1,1,0,1,1] Output: [-1,-1]
 * 
 * 
 * Note:
 * 
 * 3 <= A.length <= 30000 A[i] == 0 or A[i] == 1
 * 
 * 
 * @author skadavath
 *
 */
public class ThreeEqualParts {

	public static void main(String[] args) {

		System.out.println(Arrays.toString(new ThreeEqualParts().threeEqualParts(new int[] { 0,0,1,0,1,1 })));

	}
	
	public int[] threeEqualParts(int[] A) {
		
		int lastIndex = -1;
		
		int counts = 0;
		int numOnes = (int)Arrays.stream(A).filter(i->i==1).count();
		for(int i=A.length-1;i>=0;i--) {
			if(A[i]==1)
				counts++;
			if(counts==numOnes/3) {
				lastIndex = i;
				break;
			}
		}
		
		
		int firstIndex = findIndex(A, 0, lastIndex);
		if(firstIndex<0)
			return new int[] {-1,-1};
		
		int secondIndex = findIndex(A, firstIndex, lastIndex);
		if(secondIndex<0)
			return new int[] {-1,-1};
		
		return new int[] {firstIndex,secondIndex+1};
		
	
	}
	
	private int findIndex(int[] A , int start , int last) {
		while(A[start]==0)
			start++;
		while(last<A.length) {
			if(A[start]!=A[last])
				return -1;
			start++;
			last++;
		}
		return start;
	}

	public int[] _threeEqualParts(int[] A) {

		// find the number of 1's in the array

		int n = A.length;
		int countOfOnes = 0;
		for (int i : A) {
			if (i == 1)
				countOfOnes++;
		}

		// if countOfOnes==0 then return new int[]{0,length-1}

		if (countOfOnes == 0)
			return new int[] { 0, n - 1 };

		// if count%3==0 then only we can partition into three sets
		if (countOfOnes % 3 != 0)
			return new int[] { -1, -1 };

		// find the first one
		int count1 = 0;
		for (int i = 0; i < n; i++) {
			if (A[i] == 1) {
				count1 = i;
				break;
			}
		}

		int start = count1;
		// size of each block
		int k = countOfOnes / 3;
		// find the (k+1)th 1

		int countk1 = 0;
		int mid = 0;
		for (int i = 0; i < n; i++) {

			if (A[i] == 1) {
				countk1++;
			}
			if (countk1 == k + 1) {

				mid = i;
				break;

			}

		}
		
		//find 2*k+1 th 1
		
		int count2k1=0;
		int end = 0;
		for(int i=0;i<n;i++) {
			
			if(A[i]==1)
				count2k1++;
			if(count2k1==2*k+1) {
				end = i;
				break;
			}
		}
		
		//match all the values in start , mid and end
		
		while(end<n && A[start]==A[mid] && A[mid]==A[end]) {
			start++;
			end++;
			mid++;
		}
		
		if(end==n) {
			return new int[] {start-1,mid};
		}
		return new int[] { -1, -1 };
	}
}
