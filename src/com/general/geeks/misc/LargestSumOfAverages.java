package com.general.geeks.misc;

/*
 * We partition a row of numbers A into at most K adjacent (non-empty) groups, then our score is the sum of the average of each group. What is the largest score we can achieve?

Note that our partition must use every number in A, and that scores are not necessarily integers.

Example:
Input: 
A = [9,1,2,3,9]
K = 3
Output: 20
Explanation: 
The best choice is to partition A into [9], [1, 2, 3], [9]. The answer is 9 + (1 + 2 + 3) / 3 + 9 = 20.
We could have also partitioned A into [9, 1], [2], [3, 9], for example.
That partition would lead to a score of 5 + 2 + 6 = 13, which is worse.
 

Note:

1 <= A.length <= 100.
1 <= A[i] <= 10000.
1 <= K <= A.length.
Answers within 10^-6 of the correct answer will be accepted as correct.
 */
public class LargestSumOfAverages {

	public double largestSumOfAverages(int[] A, int K) {

		
		int n = A.length;
		//f[i][j] is the sum of averages of i+1 numbers to j numbers
		double[][] f = new double[n][n];
		
		double[] sum = new double[n];
		for(int i=0;i<n;i++) {
			sum[i]+=A[i-1]+sum[i-1];
			f[i-1][1] = sum[i]/i;
		}
		
		
		
		return 0;

	}

}
