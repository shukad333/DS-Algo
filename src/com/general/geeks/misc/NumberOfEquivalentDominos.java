package com.general.geeks.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if either (a==c and b==d), or (a==d and b==c) - that is, one domino can be rotated to be equal to another domino.

Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].

 

Example 1:

Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
Output: 1
 

Constraints:

1 <= dominoes.length <= 40000
1 <= dominoes[i][j] <= 9
 * 
 * @author skadavath
 *
 */
public class NumberOfEquivalentDominos {
	
	public static void main(String[] args) {
		
		System.out.println(new NumberOfEquivalentDominos().numEquivDominoPairs(new int[][] {{1,2},{2,1},{3,4},{5,6}}));
		
	}
	
	public int numEquivDominoPairs(int[][] dominoes) {
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] a : dominoes) {
            int max = Math.max(a[0], a[1]), min = Math.min(a[0], a[1]);
            int key = min * 10 + max;
            int pairs = map.getOrDefault(key, 0);
            cnt += pairs;
            map.put(key, 1 + pairs);
                               
        }
        return cnt;
    }

}
