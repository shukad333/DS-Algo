package com.general.geeks.maths;

/**
 * X is a good number if after rotating each digit individually by 180 degrees,
 * we get a valid number that is different from X. Each digit must be rotated -
 * we cannot choose to leave it alone.
 * 
 * A number is valid if each digit remains a digit after rotation. 0, 1, and 8
 * rotate to themselves; 2 and 5 rotate to each other; 6 and 9 rotate to each
 * other, and the rest of the numbers do not rotate to any other number and
 * become invalid.
 * 
 * Now given a positive number N, how many numbers X from 1 to N are good?
 * 
 * Example: Input: 10 Output: 4 Explanation: There are four good numbers in the
 * range [1, 10] : 2, 5, 6, 9. Note that 1 and 10 are not good numbers, since
 * they remain unchanged after rotating. Note:
 * 
 * N will be in range [1, 10000].
 * 
 * @author skadavath
 *
 */
public class RotatedDigits {
	
	public static void main(String[] args) {
		System.out.println(new RotatedDigits().rotatedDigits(10));
	}

	public int rotatedDigits(int N) {
		
		int count = 0;
		for(int i=1;i<=N;i++) {
			if(isGoodNumber(i))
					count++;
		}
		return count;

	}
	
	private boolean isGoodNumber(int x) {
		
		boolean isGood = false;
		while(x!=0) {
			
			int temp = x%10;
			if(temp==2 || temp==5 || temp==6 || temp==9) {
				isGood = true;
			}
			 if(temp==3 || temp==4 || temp==7) {
				return false;
			}
			
			x = x/10;
			
		}
		
		return isGood;
	}

}
