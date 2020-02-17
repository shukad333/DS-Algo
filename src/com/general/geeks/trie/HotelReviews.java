package com.general.geeks.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HotelReviews {
	
	
	public static void main(String[] args) {
		
		System.out.println('c');
		System.out.println((int)('c'));
		
		HotelReviews reviews = new HotelReviews();
		
		
		System.out.println(reviews.solve("cool_ice_wifi", Arrays.asList("water_is_cool", "cold_ice_drink", "cool_wifi_speed")));
		
	}
	
	
	HotelTrie trie = new HotelTrie();
	
	public ArrayList<Integer> solve(String A, List<String> B) {
		
		
		String[] aStrings = A.split("_");
		
		for(String a : aStrings) {
			
			buildTrie(a);
		}
		
		int minMatch = Integer.MAX_VALUE;
		int maxMatch = Integer.MIN_VALUE;
		
		Map<Integer, List<Integer>> map = new HashMap<>();
		
		ArrayList<Integer> resp = new ArrayList<>();
		for(int i=0;i<B.size();i++) {
			
			String b = B.get(i);
			String[] bString = b.split("_");
			int matches = 0;
			for(String str : bString) {
				
				if(search(str))
					matches++;
			}
			
			minMatch = Math.min(minMatch, matches);
			maxMatch = Math.max(maxMatch, matches);
			buildMap(matches, i, map);
		}
		
		
		for(int i=maxMatch;i>=minMatch;i--) {
			
			if(map.containsKey(i)) {
				resp.addAll(map.get(i));
			}
		}
		return resp;
		
	}
	
	private void buildMap(int matches , int index, Map<Integer, List<Integer>> map) {
		
		map.putIfAbsent(matches, new ArrayList<>());
		
			
			List<Integer> indexes = map.get(matches);
			indexes.add(index);
			Collections.sort(indexes);
			map.put(matches, indexes);
			"A".equals("B");
		
	}
	
	private void buildTrie(String word) {
		
		HotelTrie node = trie;
		
		for(char c : word.toCharArray()) {
			
			if(null==node.next[c-'a']) {
				node.next[c-'a'] = new HotelTrie();
			}
			
			node = node.next[c-'a'];
			
		}
		
		node.isWord = true;
		
	}
	
	
	private boolean search(String word) {
		
		HotelTrie node = trie;
		
		for(char c : word.toCharArray()) {
			
			if(null==node.next[c-'a'])
				return false;
			node = node.next[c-'a'];
		}
		
		return node.isWord;
	}

}




class HotelTrie {
	
	HotelTrie[] next = new HotelTrie[256];
	boolean isWord;
	
	
}
