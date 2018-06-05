package com.general.geeks.bits;

/**
 * Given a number n and a value k, turn of the k’th bit in n.
 * 
 * Examples:
 * 
 * Input: n = 15, k = 1 Output: 14
 * 
 * Input: n = 15, k = 2 Output: 13
 * 
 * Input: n = 15, k = 3 Output: 11
 * 
 * Input: n = 15, k = 4 Output: 7
 * 
 * Input: n = 15, k >= 5 Output: 15
 * 
 * @author skadavath
 *
 */


public class TurnOffKthBit {
	
	public static void main(String[] args) {
		
		System.out.println(new TurnOffKthBit().turnOffKthBit(15, 4));
	}
	//do ~(1<<(k-1)) - This will give a number with all but kth bit set .
	//Add this to original number and return
	private int turnOffKthBit(int n , int k) {
		return n & (~(1 << (k-1)));
	}
}
