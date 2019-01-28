package com.general.geeks.array.dynamicprogramming;

/**
 * We partition a row of numbers A into at most K adjacent (non-empty) groups,
 * then our score is the sum of the average of each group. What is the largest
 * score we can achieve?
 * 
 * Note that our partition must use every number in A, and that scores are not
 * necessarily integers.
 * 
 * Example: Input: A = [9,1,2,3,9] K = 3 Output: 20 Explanation: The best choice
 * is to partition A into [9], [1, 2, 3], [9]. The answer is 9 + (1 + 2 + 3) / 3
 * + 9 = 20. We could have also partitioned A into [9, 1], [2], [3, 9], for
 * example. That partition would lead to a score of 5 + 2 + 6 = 13, which is
 * worse.
 * 
 * 
 * Note:
 * 
 * 1 <= A.length <= 100. 1 <= A[i] <= 10000. 1 <= K <= A.length. Answers within
 * 10^-6 of the correct answer will be accepted as correct.
 * 
 * 
 * @author skadavath
 *
 */
public class LargestSumOfAverages {

	public static void main(String[] args) {

		System.out.println(new LargestSumOfAverages().largestSumOfAverages(new int[] { 9, 1, 2, 3, 9 }, 3));

	}

	public double largestSumOfAverages(int[] A, int K) {

		double[][] dp = new double[A.length + 1][K+1];

		double[] sum = new double[A.length+1];
		//sum[0] = A[0];
		for (int i = 1; i <= A.length; i++) {

			sum[i] = sum[i - 1] + A[i-1];
			dp[i - 1][1] = sum[i] / i;

		}

		for (int i = 2; i <= K; i++) {
			for (int j = 0; j < A.length; j++) {
				double max = Double.MIN_VALUE;
				for (int z = 0; z < j; z++) {
					
					double localSum = dp[z][i-1] + (sum[j+1]-sum[z+1])/(j-z);
					max = Double.max(max, localSum);

				}
				dp[j][i] = max;
			}
		}

		return dp[A.length-1][K];

	}

}
