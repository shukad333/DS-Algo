package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, return 1 - n in lexicographical order.
 * 
 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 * 
 * Please optimize your algorithm to use less time and space. The input size may
 * be as large as 5,000,000.
 * 
 * Seen this question in a real interview before?
 * 
 * @author skadavath
 *
 */
public class LexicographicalNumbers {

	public static void main(String[] args) {
		
		System.out.println(new LexicographicalNumbers().lexicalOrder(100));

	}

	public List<Integer> lexicalOrder(int n) {

		List<Integer> resp = new ArrayList<>();
		for (int i = 1; i < 10; i++) {
			dfs(i, resp, n);
		}
		return resp;

	}

	private void dfs(int curr, List<Integer> resp, int n) {

		if (curr > n)
			return;
		else {
			resp.add(curr);
			for (int i = 0; i < 10; i++) {
				if (10 * curr + i > n)
					return;
				dfs(10 * curr + i, resp, n);
			}
		}
	}

}
