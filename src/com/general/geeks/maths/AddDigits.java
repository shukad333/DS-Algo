package com.general.geeks.maths;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the
 * result has only one digit.
 * 
 * Example:
 * 
 * Input: 38 Output: 2 Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
 * Since 2 has only one digit, return it. Follow up: Could you do it without any
 * loop/recursion in O(1) runtime?
 * 
 * 
 * @author skadavath
 *
 */
public class AddDigits {
	
	public static void main(String[] args) {
		System.out.println(new AddDigits().addDigits(10));
	}

	public int addDigits(int num) {
		
		int sum = 0;
		int j = 0;
		while(num/10!=0) {
			
			j = num;
			
			while(j!=0) {
				sum+= j%10;
				j/=10;
			}
			num = sum;
			sum=0;
		}
		return num;
		
	}

}
