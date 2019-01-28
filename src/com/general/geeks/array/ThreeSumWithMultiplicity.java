package com.general.geeks.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given an integer array A, and an integer target, return the number of tuples
 * i, j, k such that i < j < k and A[i] + A[j] + A[k] == target.
 * 
 * As the answer can be very large, return it modulo 10^9 + 7.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: A = [1,1,2,2,3,3,4,4,5,5], target = 8 Output: 20 Explanation:
 * Enumerating by the values (A[i], A[j], A[k]): (1, 2, 5) occurs 8 times; (1,
 * 3, 4) occurs 8 times; (2, 2, 4) occurs 2 times; (2, 3, 3) occurs 2 times.
 * Example 2:
 * 
 * Input: A = [1,1,2,2,2,2], target = 5 Output: 12 Explanation: A[i] = 1, A[j] =
 * A[k] = 2 occurs 12 times: We choose one 1 from [1,1] in 2 ways, and two 2s
 * from [2,2,2,2] in 6 ways.
 * 
 * 
 * Note:
 * 
 * 3 <= A.length <= 3000 0 <= A[i] <= 100 0 <= target <= 300
 * 
 * @author skadavath
 *
 */
public class ThreeSumWithMultiplicity {
	
	/**
	 * public int threeSumMulti(int[] A, int target) {
        long[] c = new long[101];
        for (int a : A) c[a]++;
        long res = 0;
        for (int i = 0; i <= 100; i++)
            for (int j = i; j <= 100; j++) {
                int k = target - i - j;
                if (k > 100 || k < 0) continue;
                if (i == j && j == k)
                    res += c[i] * (c[i] - 1) * (c[i] - 2) / 6;
                else if (i == j && j != k)
                    res += c[i] * (c[i] - 1) / 2 * c[k];
                else if (j < k)
                    res += c[i] * c[j] * c[k];
            }
        return (int)(res % (1e9 + 7));
    }

	 * @param A
	 * @param target
	 * @return
	 */

	public int threeSumMulti(int[] A, int target) {

		Map<Integer, Integer> map = new HashMap<>();

		int resp = 0, mod = 1000000007;
		for (int i = 0; i < A.length; i++) {
			
			resp = (resp + map.getOrDefault(target-A[i], 0))%mod;
			
			for(int j=0;j<i;j++) {
				
				int temp = A[i] + A[j];
				map.put(temp, map.getOrDefault(temp, 0)+1);
 				
			}

		}
		return resp;

	}

}
