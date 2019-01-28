package com.general.geeks.array;

import java.util.Arrays;

/**
 * 
 * A string S of lowercase letters is given. Then, we may make any number of
 * moves.
 * 
 * In each move, we choose one of the first K letters (starting from the left),
 * remove it, and place it at the end of the string.
 * 
 * Return the lexicographically smallest string we could have after any number
 * of moves.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: S = "cba", K = 1 Output: "acb" Explanation: In the first move, we move
 * the 1st character ("c") to the end, obtaining the string "bac". In the second
 * move, we move the 1st character ("b") to the end, obtaining the final result
 * "acb". Example 2:
 * 
 * Input: S = "baaca", K = 3 Output: "aaabc" Explanation: In the first move, we
 * move the 1st character ("b") to the end, obtaining the string "aacab". In the
 * second move, we move the 3rd character ("c") to the end, obtaining the final
 * result "aaabc".
 * 
 * 
 * Note:
 * 
 * 1 <= K <= S.length <= 1000 S consists of lowercase letters only.
 * 
 * 
 * @author skadavath
 *
 */
public class OrderlyQueue {

	public static void main(String[] args) {

		System.out.println(new OrderlyQueue().orderlyQueue("cba", 1));

	}

	public String orderlyQueue(String S, int K) {

		// when K>1 , we can rearrange so that we can form the sorted string

		if (K > 1) {
			char[] sArr = S.toCharArray();
			Arrays.sort(sArr);
			return new String(sArr);
		}

		// else slide one by one and get the lexicographical sorted order

		String resp = S;

		for (int i = 1; i < S.length(); i++) {
			String curr = S.substring(i) + S.substring(0, i);
			if (resp.compareTo(curr) > 0)
				resp = curr;
		}

		return resp;

	}

}
