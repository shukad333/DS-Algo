package com.general.geeks.misc;

import java.util.Arrays;

/**
 * There are N children standing in a line. Each child is assigned a rating
 * value.
 * 
 * You are giving candies to these children subjected to the following
 * requirements:
 * 
 * Each child must have at least one candy. Children with a higher rating get
 * more candies than their neighbors. What is the minimum candies you must give?
 * 
 * Example 1:
 * 
 * Input: [1,0,2] Output: 5 Explanation: You can allocate to the first, second
 * and third child with 2, 1, 2 candies respectively. Example 2:
 * 
 * Input: [1,2,2] Output: 4 Explanation: You can allocate to the first, second
 * and third child with 1, 2, 1 candies respectively. The third child gets 1
 * candy because it satisfies the above two conditions.
 * 
 * @author skadavath
 *
 */
public class Candies {
	
	public static void main(String[] args) {
		
		System.out.println(new Candies().candy(new int[] {1,2,87,87,87,2,1}));
		
	}

	public int candy(int[] ratings) {
		
		int resp = ratings.length;
		
		int[] rat = new int[resp];
		Arrays.fill(rat, 1);
		
		for(int i=1;i<ratings.length;i++) {
			if(ratings[i]>ratings[i-1])
				rat[i] = rat[i-1]+1;
		}
		
		for(int i=ratings.length-1;i>0;i--) {
			if(ratings[i-1]>ratings[i])
				rat[i-1] = Math.max(rat[i-1], rat[i]+1);
		}
		
		resp = 0;
		for(int i:rat)
			resp+=i;
		return resp;

	}

}
