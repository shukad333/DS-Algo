package com.interviewbit;

import java.util.LinkedList;
import java.util.List;

public class SuffixTrieToSearchInStreams {
	
	
	public static void main(String[] args) {
		
		SuffixTrieToSearchInStreams suff = new SuffixTrieToSearchInStreams("bananaandotherthingsotherbro");
		suff.search("other");
		
	}
	
	
	SuffixSearchTrie root = new SuffixSearchTrie();
	
	public SuffixTrieToSearchInStreams(String word) {
		
		for(int i=0;i<word.length();i++) {
			
			root.insertSuffix(word.substring(i), i);
			
		}
	
	}
	
	public void search(String word) {
		
		List<Integer> ind = root.search(word);
		
		if(null==ind) {
			System.out.println("Pattern not found");
		}
		
		else {
			
			for(int i : ind)
			System.out.println("Found at "+i);
		}
		
	}

}


class SuffixSearchTrie {
	
	SuffixSearchTrie[] children = new SuffixSearchTrie[256];
	List<Integer> indexes;
	
	
	public SuffixSearchTrie() {
		
		indexes = new LinkedList<>();
		
	}
	
	public void insertSuffix(String S , int index) {
		
		indexes.add(index);
		
		if(S.length()>0) {
			
			char first = S.charAt(0);
			if(children[first]==null) {
				children[first] = new SuffixSearchTrie();
			}
			
			children[first].insertSuffix(S.substring(1), index+1);
			
		}
		
	}
	
	public List<Integer> search(String word) {
		
		if(word.length()==0)
			return indexes;
		
		if(children[word.charAt(0)]!=null) {
			
			return children[word.charAt(0)].search(word.substring(1));
		}
		else
			return null;
	}
	
}
