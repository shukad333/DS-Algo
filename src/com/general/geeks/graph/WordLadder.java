package com.general.geeks.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
	
	public static void main(String[] args) {
		
		String[] arr = {"hot","dot","dog","lot","log","cog"};
		List<String> wordList = new ArrayList();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		System.out.println(new WordLadder().ladderLength("hit", "cog", wordList));
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {

		Queue<SItem> queue = new LinkedList();
		queue.add(new SItem(beginWord, 1));
		
		while(!queue.isEmpty()) {
			
			SItem item = queue.poll();
			
		
			
			for(Iterator<String> iterator = wordList.iterator();iterator.hasNext();) {
			
			String str = iterator.next();
			if(isAdjacent(str, item.word)) {
				SItem it = new SItem(str, item.len+1);
				
				queue.add(it);
				iterator.remove();
				
				
				if(str.equals(endWord)) {
					return it.len;
				}
			}

		}
		
		}
		return 0;

	}

	private boolean isAdjacent(String s1, String s2) {
		
		int count = 0;
		for(int i=0;i<s1.length();i++) {
			
			if(s1.charAt(i)!=s2.charAt(i)) {
				count++;
			}
			
			if(count > 1) {
				return false;
			}
		}
		return true;
	}
}

class SItem {
	String word;
	int len;

	public SItem(String word, int len) {
		this.word = word;
		this.len = len;
	}
}
