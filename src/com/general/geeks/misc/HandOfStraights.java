package com.general.geeks.misc;

import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * Alice has a hand of cards, given as an array of integers.
 * 
 * Now she wants to rearrange the cards into groups so that each group is size
 * W, and consists of W consecutive cards.
 * 
 * Return true if and only if she can.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: hand = [1,2,3,6,2,3,4,7,8], W = 3 Output: true Explanation: Alice's
 * hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]. Example 2:
 * 
 * Input: hand = [1,2,3,4,5], W = 4 Output: false Explanation: Alice's hand
 * can't be rearranged into groups of 4.
 * 
 * 
 * Note:
 * 
 * 1 <= hand.length <= 10000 0 <= hand[i] <= 10^9 1 <= W <= hand.length
 * 
 * @author skadavath
 *
 */
public class HandOfStraights {

	public static void main(String[] args) {
		System.out.println(new HandOfStraights().isNStraightHand(new int[] { 1, 2, 3, 6, 2, 3, 4, 7, 8 }, 3));
	}

	public boolean isNStraightHand(int[] hand, int W) {

		Map<Integer, Integer> map = new TreeMap<>();
		for (int h : hand) {
			map.put(h, map.getOrDefault(h, 0) + 1);
		}

		int count = 0;
		for (int h : map.keySet()) {
			if (map.get(h) > 0) {
				for (int i = W - 1; i >= 0; i--) {
					if (map.getOrDefault(h + i, 0) < map.get(h))
						return false;
					map.put(h + i, map.get(h + i) - map.get(h));
				}
			}
		}

		return true;

	}

}
