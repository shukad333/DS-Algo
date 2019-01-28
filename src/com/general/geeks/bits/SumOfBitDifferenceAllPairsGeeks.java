package com.general.geeks.bits;

public class SumOfBitDifferenceAllPairsGeeks {

	public int sumBitDifference(int[] arr) {
		
		int n = arr.length;
		int ans = 0; // Initialize result

		// traverse over all bits
		for (int i = 0; i < 32; i++) {

			// count number of elements
			// with i'th bit set
			int count = 0;

			for (int j = 0; j < n; j++)
				if ((arr[j] & (1 << i)) == 0)
					count++;

			// Add "count * (n - count) * 2"
			// to the answer
			ans += (count * (n - count) * 2);
		}

		return ans;
	}
	
	public static void main(String[] args) {
		
		System.out.println(new SumOfBitDifferenceAllPairsGeeks().sumBitDifference(new int[] {1,2}));
		
	}

}
