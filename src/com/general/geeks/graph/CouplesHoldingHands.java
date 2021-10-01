package com.general.geeks.graph;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * N couples sit in 2N seats arranged in a row and want to hold hands. We want to know the minimum number of swaps so that every couple is sitting side by side. A swap consists of choosing any two people, then they stand up and switch seats.

The people and seats are represented by an integer from 0 to 2N-1, the couples are numbered in order, the first couple being (0, 1), the second couple being (2, 3), and so on with the last couple being (2N-2, 2N-1).

The couples' initial seating is given by row[i] being the value of the person who is initially sitting in the i-th seat.

Example 1:

Input: row = [0, 2, 1, 3]
Output: 1
Explanation: We only need to swap the second (row[1]) and third (row[2]) person.
Example 2:

Input: row = [3, 2, 0, 1]
Output: 0
Explanation: All couples are already seated side by side.
Note:

len(row) is even and in the range of [4, 60].
row is guaranteed to be a permutation of 0...len(row)-1.
 * 
 * @author skadavath
 *
 */
public class CouplesHoldingHands {

	private class UF {
		private int[] parents;
		public int count;
		UF(int n) {
			this.count = n;
			this.parents = new int[n];

			for(int i=0;i<n;i++)
				parents[i] = i;
		}

		private int find(int i) {
			if(parents[i]==i)
				return i;
			parents[i] = find(parents[i]);
			return parents[i];
		}

		public void union(int x , int y) {
			int findX = find(x);
			int findY = find(y);
			if(findX!=findY) {
				this.count--;
				parents[findX] = findY;
			}
		}
	}
	


	public int minSwapsCouples(int[] row) {

		int N = row.length/2;
		UF uf = new UF(N);

		for(int i=0;i<N;i++) {
			int a = row[2*i];
			int b = row[2*i+1];
			uf.union(a/2,b/2);
		}

		return N-uf.count;

	}


	public static void main(String[] args) {

		System.out.println(new CouplesHoldingHands().minSwapsCouples(new int[] {5, 1, 3, 2,4,0}));

	}

	public int _minSwapsCouples(int[] row) {
		
		/*
		 * Map the from and two to a map ... 
		 * See if we can map the original one again , 
		 * for each iteration ... The number of swaps required again will
		 * be the answer .
		 * 
		 */
		
		Map<Integer, Integer> map = new HashMap<>();
		
		int swaps = 0;
		int n = row.length;
		for(int i=0;i<n;i+=2) {
			map.put(row[i], row[i+1]);
			map.put(row[i+1], row[i]);
		}
		
		for(int i=0;i<n;i+=2) {
			if(map.get(i)!=i+1) {
				
				int next = map.get(i+1);
				int curr = map.get(i);
				map.put(next, curr);
				map.put(curr, next);
				map.put(i, i+1);
				swaps++;
			}
		}
		
		return swaps;

	}

}
