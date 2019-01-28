package com.general.geeks.array;

import java.util.ArrayList;
import java.util.List;

import sun.applet.Main;

/**
 * 
 * The gray code is a binary numeral system where two successive values differ
 * in only one bit.
 * 
 * Given a non-negative integer n representing the total number of bits in the
 * code, print the sequence of gray code. A gray code sequence must begin with
 * 0.
 * 
 * Example 1:
 * 
 * Input: 2 Output: [0,1,3,2] Explanation: 00 - 0 01 - 1 11 - 3 10 - 2
 * 
 * For a given n, a gray code sequence may not be uniquely defined. For example,
 * [0,2,3,1] is also a valid gray code sequence.
 * 
 * 00 - 0 10 - 2 11 - 3 01 - 1 Example 2:
 * 
 * Input: 0 Output: [0] Explanation: We define the gray code sequence to begin
 * with 0. A gray code sequence of n has size = 2n, which for n = 0 the size is
 * 20 = 1. Therefore, for n = 0 the gray code sequence is [0].
 * 
 * 
 * 
 * @author skadavath
 *
 */
public class GrayCode {

	/**
	 * GeeksForGeeks
	 * 
	 * The above sequences are Gray Codes of different widths. Following is an
	 * interesting pattern in Gray Codes.
	 * 
	 * n-bit Gray Codes can be generated from list of (n-1)-bit Gray codes using
	 * following steps. 1) Let the list of (n-1)-bit Gray codes be L1. Create
	 * another list L2 which is reverse of L1. 2) Modify the list L1 by prefixing a
	 * ‘0’ in all codes of L1. 3) Modify the list L2 by prefixing a ‘1’ in all codes
	 * of L2. 4) Concatenate L1 and L2. The concatenated list is required list of
	 * n-bit Gray codes.
	 * 
	 * For example, following are steps for generating the 3-bit Gray code list from
	 * the list of 2-bit Gray code list. L1 = {00, 01, 11, 10} (List of 2-bit Gray
	 * Codes) L2 = {10, 11, 01, 00} (Reverse of L1) Prefix all entries of L1 with
	 * ‘0’, L1 becomes {000, 001, 011, 010} Prefix all entries of L2 with ‘1’, L2
	 * becomes {110, 111, 101, 100} Concatenate L1 and L2, we get {000, 001, 011,
	 * 010, 110, 111, 101, 100}
	 * 
	 * To generate n-bit Gray codes, we start from list of 1 bit Gray codes. The
	 * list of 1 bit Gray code is {0, 1}. We repeat above steps to generate 2 bit
	 * Gray codes from 1 bit Gray codes, then 3-bit Gray codes from 2-bit Gray codes
	 * till the number of bits becomes equal to n. Following is C++ implementation
	 * of this approach.
	 */

	public static void main(String[] args) {

		System.out.println(new GrayCode().grayCode(3));
	}

	public List<Integer> grayCode(int n) {

		List<Integer> resp = new ArrayList<Integer>();

		resp.add(0);
		for (int i = 0; i < n; i++) {

			for (int j = resp.size() - 1; j >= 0; j--) {
				resp.add(resp.get(j) | (1 << i));
			}
		}

		return resp;

	}

}
