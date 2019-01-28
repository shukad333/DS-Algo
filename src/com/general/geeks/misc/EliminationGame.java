package com.general.geeks.misc;

/**
 * There is a list of sorted integers from 1 to n. Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.

Repeat the previous step again, but this time from right to left, remove the right most number and every other number from the remaining numbers.

We keep repeating the steps again, alternating left to right and right to left, until a single number remains.

Find the last number that remains starting with a list of length n.

Example:

Input:
n = 9,
1 2 3 4 5 6 7 8 9
2 4 6 8
2 6
6

Output:
6

 * @author skadavath
 *
 */
public class EliminationGame {
	
	public static void main(String[] args) {
		System.out.println(new EliminationGame().lastRemaining(9));
	}

	public int lastRemaining(int n) {
		
		int element=1;
		
		int totalNow = n;
		int step = 1;
		int dir = 0;//0 for right and 1 for left
		while(totalNow>1) {
			
			//if dir is from left or the remaining is odd , we update the element
			if(dir==0 || totalNow%2==1) {
				element += step;
			}
			
			dir = 1 - dir;//change dir
			step*=2;
			totalNow/=2;
		}
		
		return element;

	}

}
