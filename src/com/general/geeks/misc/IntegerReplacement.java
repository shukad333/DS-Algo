package com.general.geeks.misc;

/**
 * Given a positive integer n and you can do operations as follow:

If n is even, replace n with n/2.
If n is odd, you can replace n with either n + 1 or n - 1.
What is the minimum number of replacements needed for n to become 1?

Example 1:

Input:
8

Output:
3

Explanation:
8 -> 4 -> 2 -> 1
Example 2:

Input:
7

Output:
4

Explanation:
7 -> 8 -> 4 -> 2 -> 1
or
7 -> 6 -> 3 -> 2 -> 1

 * @author skadavath
 *
 */
public class IntegerReplacement {
	
	public static void main(String[] args) {
		System.out.println(new IntegerReplacement().integerReplacement(7));
	}

	public int integerReplacement(int n) {
		
		/*
		 * if n is even divide it by 2
		 * Else , it (n-1) has less 1 bits than (n+1) , decrement n
		 * else increment n
		 * 
		 * only exception is 3 , coz , 3->2->1 better than 3->4->2->1
		 */
		
		int resp = 0;
		while(n>1) {
			
			if(n%2==0)
				n/=2;
			else if(n==3 || Integer.bitCount(n-1) < Integer.bitCount(n+1))
				n--;
			else n++;
			
			resp++;
		}
		
		return resp;

	}

}
