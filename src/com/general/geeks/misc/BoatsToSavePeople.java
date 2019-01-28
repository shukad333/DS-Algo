package com.general.geeks.misc;

import java.util.Arrays;

/**
 * The i-th person has weight people[i], and each boat can carry a maximum
 * weight of limit.
 * 
 * Each boat carries at most 2 people at the same time, provided the sum of the
 * weight of those people is at most limit.
 * 
 * Return the minimum number of boats to carry every given person. (It is
 * guaranteed each person can be carried by a boat.)
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: people = [1,2], limit = 3 Output: 1 Explanation: 1 boat (1, 2) Example
 * 2:
 * 
 * Input: people = [3,2,2,1], limit = 3 Output: 3 Explanation: 3 boats (1, 2),
 * (2) and (3) Example 3:
 * 
 * Input: people = [3,5,3,4], limit = 5 Output: 4 Explanation: 4 boats (3), (3),
 * (4), (5) Note:
 * 
 * 1 <= people.length <= 50000 1 <= people[i] <= limit <= 30000
 * 
 * @author skadavath
 *
 */
public class BoatsToSavePeople {

	public static void main(String[] args) {
		System.out.println(new BoatsToSavePeople().numRescueBoats(new int[] { 5, 1, 4, 2 }, 6));
	}

	public int numRescueBoats(int[] people, int limit) {

		int min = 0;

		Arrays.sort(people);

		int j = people.length - 1,i=0;
		while(i<=j) {

			if (i == 0) {
				if (i + 1 < people.length && people[i] + people[i + 1] > limit) {
					return people.length;
				}

			}

			if (people[i] + people[j] <= limit) {
				j--;
				i++;
				min++;
				continue;
			}

			else {
				j--;
				min++;
			}
				
		}

		return min;

	}

}
