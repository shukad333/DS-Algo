package com.general.geeks.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * 
 * You are given a string s, and an array of pairs of indices in the string pairs where pairs[i] = [a, b] indicates 2 indices(0-indexed) of the string.

You can swap the characters at any pair of indices in the given pairs any number of times.

Return the lexicographically smallest string that s can be changed to after using the swaps.

 

Example 1:

Input: s = "dcab", pairs = [[0,3],[1,2]]
Output: "bacd"
Explaination: 
Swap s[0] and s[3], s = "bcad"
Swap s[1] and s[2], s = "bacd"
Example 2:

Input: s = "dcab", pairs = [[0,3],[1,2],[0,2]]
Output: "abcd"
Explaination: 
Swap s[0] and s[3], s = "bcad"
Swap s[0] and s[2], s = "acbd"
Swap s[1] and s[2], s = "abcd"
Example 3:

Input: s = "cba", pairs = [[0,1],[1,2]]
Output: "abc"
Explaination: 
Swap s[0] and s[1], s = "bca"
Swap s[1] and s[2], s = "bac"
Swap s[0] and s[1], s = "abc"

 

Constraints:

1 <= s.length <= 10^5
0 <= pairs.length <= 10^5
0 <= pairs[i][0], pairs[i][1] < s.length
s only contains lower case English letters.
 * 
 * @author skadavath
 *
 */
public class SmallestStringWithSwaps {
	
	public static void main(String[] args) {
		
		List<Integer> l = new ArrayList<>();
		l.add(0);
		l.add(3);
		List<List<Integer>> list = new ArrayList<>();
		list.add(l);
		l = new ArrayList<>();
		l.add(1);
		l.add(2);
		list.add(l);
		l = new ArrayList<>();
		l.add(0);
		l.add(2);
		list.add(l);
		
		System.out.println(new SmallestStringWithSwaps().smallestStringWithSwaps("dcab", list));
		
	}

	public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
		
		int[] p = IntStream.range(0, s.length()).toArray();
		
		for(List<Integer> pair : pairs) {
			union(p, pair.get(0), pair.get(1));
		}
		
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for(int i=0;i<s.length();i++) {
			int parent = find(p, i);
			map.putIfAbsent(parent, new ArrayList<>());
			map.get(parent).add(i);
		}
		
		char[] arr = s.toCharArray();
		for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
			List<Integer> group = entry.getValue();
			List<Character> temp = new ArrayList<>();
			for(int index : group)
				temp.add(arr[index]);
			Collections.sort(temp);
			
			for(int i=0;i<group.size();i++)
				arr[group.get(i)] = temp.get(i);
		}
		
		return new String(arr);
		
		

	}
	
	private void union(int[] arr , int p , int q) {
		int A = find(arr,p);
		int B = find(arr,q);
		if(A!=B)
			arr[A] = B;
	}
	
	private int find(int[] parent , int p) {
		if(p==parent[p])
			return p;
		return find(parent,parent[p]);
	}

}
