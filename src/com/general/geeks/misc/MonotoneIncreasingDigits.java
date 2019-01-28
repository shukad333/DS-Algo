package com.general.geeks.misc;

/**
 * Given a non-negative integer N, find the largest number that is less than or equal to N with monotone increasing digits.

(Recall that an integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.)

Example 1:
Input: N = 10
Output: 9
Example 2:
Input: N = 1234
Output: 1234
Example 3:
Input: N = 332
Output: 299
Note: N is an integer in the range [0, 10^9].
 * @author skadavath
 *
 */
public class MonotoneIncreasingDigits {
	
	public static void main(String[] args) {
		System.out.println(new MonotoneIncreasingDigits().monotoneIncreasingDigits(12345));
	}

	public int monotoneIncreasingDigits(int N) {
		
		//check each digit from the last
		//if smaller than the previous , then move marker back
		//which is actually for putting max no 9
		//and reduce previous by 1
		
		char[] arr = String.valueOf(N).toCharArray();
		
		int marker = arr.length;
		for(int i=arr.length-1;i>0;i--) {
			if(arr[i]<arr[i-1]) {
				marker = i;
				arr[i-1]--;
			}
		}
		for(int i=marker;i<arr.length;i++)
			arr[i] = '9';
		
		return Integer.valueOf(String.valueOf(arr));

	}

}
