package com.general.geeks.misc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 
 * A frog is crossing a river. The river is divided into x units and at each
 * unit there may or may not exist a stone. The frog can jump on a stone, but it
 * must not jump into the water.
 * 
 * Given a list of stones' positions (in units) in sorted ascending order,
 * determine if the frog is able to cross the river by landing on the last
 * stone. Initially, the frog is on the first stone and assume the first jump
 * must be 1 unit.
 * 
 * If the frog's last jump was k units, then its next jump must be either k - 1,
 * k, or k + 1 units. Note that the frog can only jump in the forward direction.
 * 
 * Note:
 * 
 * The number of stones is ≥ 2 and is < 1,100. Each stone's position will be a
 * non-negative integer < 231. The first stone's position is always 0.
 * 
 * @author skadavath
 *
 */
public class FrogJump {

	public static void main(String[] args) {

		int[] stones = { 0, 1, 3, 5, 6, 8, 12, 17 };
		System.out.println(new FrogJump().canCross(stones));
	}

	public boolean canCross(int[] stones) {

		Map<Integer, Set<Integer>> map = new HashMap();
		map.put(stones[0], new HashSet<>());
		map.get(stones[0]).add(1);
		for (int i = 1; i < stones.length; i++) {
			map.put(stones[i], new HashSet<>());
		}

		int last = stones[stones.length - 1];
		for (int i : stones) {

			for (int k : map.get(i)) {
				int step = i + k;
				if (step == last) {
					return true;
				}

				if (map.get(step) != null) {
					map.get(step).add(k);
					if (k - 1 > 0)
						map.get(step).add(k - 1);
					map.get(step).add(k + 1);
				}

			}
		}

		return false;

	}

}
