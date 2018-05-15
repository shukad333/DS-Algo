package com.general.geeks.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * 
 * In a forest, each rabbit has some color. Some subset of rabbits (possibly all
 * of them) tell you how many other rabbits have the same color as them. Those
 * answers are placed in an array.
 * 
 * Return the minimum number of rabbits that could be in the forest.
 * 
 * Examples: Input: answers = [1, 1, 2] Output: 5 Explanation: The two rabbits
 * that answered "1" could both be the same color, say red. The rabbit than
 * answered "2" can't be red or the answers would be inconsistent. Say the
 * rabbit that answered "2" was blue. Then there should be 2 other blue rabbits
 * in the forest that didn't answer into the array. The smallest possible number
 * of rabbits in the forest is therefore 5: 3 that answered plus 2 that didn't.
 * 
 * Input: answers = [10, 10, 10] Output: 11
 * 
 * Input: answers = [] Output: 0
 * 
 * @author skadavath
 *
 */
public class RabbitsInForest {
	
	public static void main(String[] args) {
		
		int[] answers = {1,1,2,3};
		System.out.println(new RabbitsInForest().numRabbits(answers));
		
	}

	public int numRabbits(int[] answers) {
		
		int sum = 0;
		Map<Integer, Integer> map = new HashMap();
		
		for(int answer : answers) {
			
			if(answer==0) {
				sum+=1;
				continue;
			}
			
			if(!map.containsKey(answer)) {
				map.put(answer, 0);
				sum+=(answer+1);
			}
			else {
				map.put(answer, map.get(answer)+1);
				if(map.get(answer)==answer) {
					map.remove(answer);
				}
			}
			
		}
		return sum;

	}

}
