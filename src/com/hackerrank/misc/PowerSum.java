package com.hackerrank.misc;

/**
 * 
 * Find the number of ways that a given integer, , can be expressed as the sum of the  powers of unique, natural numbers.

For example, if  and , we have to find all combinations of unique squares adding up to . The only solution is .

Function Description

Complete the powerSum function in the editor below. It should return an integer that represents the number of possible combinations.

powerSum has the following parameter(s):

X: the integer to sum to
N: the integer power to raise numbers to
Input Format

The first line contains an integer .
The second line contains an integer .

Constraints

Output Format

Output a single integer, the number of possible combinations caclulated.

Sample Input 0

10
2
Sample Output 0

1
Explanation 0

If  and , we need to find the number of ways that  can be represented as the sum of squares of unique numbers.


This is the only way in which  can be expressed as the sum of unique squares.

Sample Input 1

100
2
Sample Output 1

3
Explanation 1


Sample Input 2

100
3
Sample Output 2

1
Explanation 2

 can be expressed as the sum of the cubes of .
. There is no other way to express  as the sum of cubes.

 * @author skadavath
 *
 */
public class PowerSum {
	
	
	public static void main(String[] args) {
		
		System.out.println(powerSum(100, 2));
		
	}
	static int powerSum(int X, int N) {
		
		return powerSumHelper(X, N, 1, 0);


    }
	
	static int powerSumHelper(int x,int N , int currNum , int currSum) {
		
		int resp = 0;
		
		int curr = (int)Math.pow(currNum, N);
		
		while(curr+currSum<x) {
			
			resp += powerSumHelper(x, N, currNum+1, +curr+currSum);
			currNum++;
			curr = (int)Math.pow(currNum, N);
		}
		
		if(curr+currSum==x)
			resp++;
		return resp;
		
	}

}
