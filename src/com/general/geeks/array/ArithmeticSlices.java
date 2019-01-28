package com.general.geeks.array;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 
 * A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, these are arithmetic sequence:

1, 3, 5, 7, 9
7, 7, 7, 7
3, -1, -5, -9
The following sequence is not arithmetic.

1, 1, 2, 5, 7

A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.

A slice (P, Q) of array A is called arithmetic if the sequence:
A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.

The function should return the number of arithmetic slices in the array A.


Example:

A = [1, 2, 3, 4]

return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
 * 
 * @author skadavath
 *
 */
public class ArithmeticSlices {
	
	static AtomicBoolean bool = new AtomicBoolean();
	static String str;
	public static void main(String[] args) {
		
		System.out.println(bool.get());
		
		boolean should = null==str;
		System.out.println(should);
		
		try {
			
			throw new RuntimeException();
		}
		
		catch(Exception e) {
			System.out.println("Caught");
		}
		
		//System.out.println(new ArithmeticSlices().numberOfArithmeticSlices(new int[] {1,2,3,4}));
		
	}

	public int numberOfArithmeticSlices(int[] A) {
		
		int resp = 0;
		
		int curr = 0;
		
		for(int i=2;i<A.length;i++) {
			
			if(A[i]-A[i-1]==A[i-1]-A[i-2]) {
				curr+=1;
				resp+=curr;
			}
			else {
				curr=0;
			}
			
		}
		return resp;

	}

}
