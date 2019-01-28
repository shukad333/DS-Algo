package com.general.geeks.bits;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 * 
 * Example:
 * 
 * Input: 43261596 Output: 964176192 Explanation: 43261596 represented in binary
 * as 00000010100101000001111010011100, return 964176192 represented in binary
 * as 00111001011110000010100101000000. Follow up: If this function is called
 * many times, how would you optimize it?
 * 
 * 
 * @author skadavath
 *
 */
public class ReverseBits {
	
	public static void main(String[] args) {
		System.out.println(-5>>1);
		System.out.println(-5>>>1);
		//System.out.println(new ReverseBits().reverseBits(43261596));
	}
	public int reverseBits(int n) {
		int result = 0;
		System.out.println(Integer.toBinaryString(n));
		for (int i = 0; i < 32; ++i) {
			result = result << 1 | (n & 1);
			n >>>= 1;
			System.out.println(Integer.toBinaryString(n));
		}
		return result;
	}

}
