package com.general.geeks.array.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * We are given N different types of stickers. Each sticker has a lowercase
 * English word on it.
 * 
 * You would like to spell out the given target string by cutting individual
 * letters from your collection of stickers and rearranging them.
 * 
 * You can use each sticker more than once if you want, and you have infinite
 * quantities of each sticker.
 * 
 * What is the minimum number of stickers that you need to spell out the target?
 * If the task is impossible, return -1.
 * 
 * Example 1:
 * 
 * Input:
 * 
 * ["with", "example", "science"], "thehat" Output:
 * 
 * 3 Explanation:
 * 
 * We can use 2 "with" stickers, and 1 "example" sticker. After cutting and
 * rearrange the letters of those stickers, we can form the target "thehat".
 * Also, this is the minimum number of stickers necessary to form the target
 * string. Example 2:
 * 
 * Input:
 * 
 * ["notice", "possible"], "basicbasic" Output:
 * 
 * -1 Explanation:
 * 
 * We can't form the target "basicbasic" from cutting letters from the given
 * stickers. Note:
 * 
 * stickers has length in the range [1, 50]. stickers consists of lowercase
 * English words (without apostrophes). target has length in the range [1, 15],
 * and consists of lowercase English letters. In all test cases, all words were
 * chosen randomly from the 1000 most common US English words, and the target
 * was chosen as a concatenation of two random words. The time limit may be more
 * challenging than usual. It is expected that a 50 sticker test case can be
 * solved within 35ms on average.
 * 
 * @author skadavath
 *
 */
public class StickersToSpellWord {
	
	public static void main(String[] args) {
		
		
		System.out.println(new StickersToSpellWord().minStickers(new String[] {"with", "example", "science"}, "thehat"));
		
	}

	public int minStickers(String[] stickers, String target) {

		int[][] stick = new int[stickers.length][26];
		for (int i = 0; i < stick.length; i++) {

			for (char c : stickers[i].toCharArray()) {

				stick[i][c - 'a']++;

			}

		}
		
		Map<String, Integer> dp = new HashMap<>();
		dp.put("", 0);

		return bfs(dp,stick,target);
		
	}

	private int bfs(Map<String, Integer> dp, int[][] stickers, String target) {
		
		if(dp.containsKey(target))return dp.get(target);
		
		int resp = Integer.MAX_VALUE;
		
		int n = stickers.length;
		
		int[] targetCharArr = new int[26];
		int t=0;
		while(t<target.length())
			targetCharArr[target.charAt(t++)-'a']++;
		
		for(int i=0;i<n;i++) {
			
			//try all stickers which has first char of target
			if(stickers[i][target.charAt(0)-'a']>0) {
				
				//found a sticker
				
				StringBuilder sb = new StringBuilder();
				
				for(int k=0;k<26;k++) {
					if(targetCharArr[k]>0) {
						
						for(int l=0;l<Math.max(0,targetCharArr[k]-stickers[i][k]);l++) {
							sb.append((char)('a'+k));
						}
						
					}
				}
				
				int next = bfs(dp, stickers, sb.toString());
				if(next!=-1)resp = Math.min(resp, 1+next);
				
			}
			
		}	
		
		dp.put(target, resp==Integer.MAX_VALUE?-1:resp);

		return dp.get(target);
	}

}
