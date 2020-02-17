package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Given a string, sort it in decreasing order based on the frequency of
 * characters.
 * 
 * Example 1:
 * 
 * Input: "tree"
 * 
 * Output: "eert"
 * 
 * Explanation: 'e' appears twice while 'r' and 't' both appear once. So 'e'
 * must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 * 
 * Input: "cccaaa"
 * 
 * Output: "cccaaa"
 * 
 * Explanation: Both 'c' and 'a' appear three times, so "aaaccc" is also a valid
 * answer. Note that "cacaca" is incorrect, as the same characters must be
 * together. Example 3:
 * 
 * Input: "Aabb"
 * 
 * Output: "bbAa"
 * 
 * Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect. Note
 * that 'A' and 'a' are treated as two different characters.
 * 
 * @author skadavath
 *
 */
public class SortCharactersByFrequency {

	public static void main(String[] args) {
		System.out.println(new SortCharactersByFrequency().frequencySort("Aabb"));
	}
	
	public String frequencySort(String s) {
		
		Map<Character, Integer> map = new HashMap<>();
		
		for(char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		
		
		PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
		
		pq.addAll(map.entrySet());
		
		StringBuilder sb  = new StringBuilder();
		
		while(!pq.isEmpty()) {
			
			Map.Entry<Character, Integer> entry = pq.poll();
			for(int i=0;i<entry.getValue();i++) {
				sb.append(entry.getKey()+"");
			}
		}
		
		return sb.toString();
		
	}

	public String frequencySortOld(String s) {

		int[] ch = new int[256];
		for (char c : s.toCharArray()) {
			ch[c]++;
		}
		
		Map<Integer, ArrayList<Character>> map = new TreeMap<>();
		for(int i=0;i<256;i++) {
			if(ch[i]==0)
				continue;
			int freq = ch[i];
			char c = (char)i;
			if(!map.containsKey(freq)) {
				map.put(freq, new ArrayList<>());
			}
			map.get(freq).add(c);
		}
		
		StringBuilder sb = new StringBuilder();
		for(Entry<Integer, ArrayList<Character>> entry : map.entrySet()) {
			int freq = entry.getKey();
			//sb.append(entry.getValue());
			ArrayList<Character> list = entry.getValue();
			for(int i=0;i<list.size();i++) {
				
				char c = list.get(i);
				for(int j=0;j<freq;j++) {
					sb.append(c);
				}
			}
		}

		System.out.println(sb.reverse().toString());
		return sb.reverse().toString();

	}

}
