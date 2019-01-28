package com.general.geeks.tree;

/**
 * 
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
Accepted
171,527
Submissions
391,201
 * 
 * @author skadavath
 *
 */
public class UniqueBST1 {
	
	public static void main(String[] args) {
		
		System.out.println(new UniqueBST1().numTrees(4));
		
	}

	public int numTrees(int n) {
		
		int[] dp = new int[n+1];
		dp[0]=1;
		dp[1] = 1;
		
		for(int i=2;i<=n;i++) {
			
			for(int j=0;j<i;j++) {
				
				//catalan number
				/**
				 * for n=1, one BST is possible
				 * for n=2, two BST are possible
				 * for n=3 , 5 BST are possible
				 * for n=4 , we can change the root and arrange left and right and see
				 * T[4] = T[3] + T[2] + T[2] + T[3] = 14
				 * 
				 */
				dp[i] += dp[j] * dp[i-j-1];
				
			}
			
		}
		return dp[n];

	}

}
