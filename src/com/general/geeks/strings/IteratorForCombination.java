package com.general.geeks.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Design an Iterator class, which has:

A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
A function next() that returns the next combination of length combinationLength in lexicographical order.
A function hasNext() that returns True if and only if there exists a next combination.
 

Example:

CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.

iterator.next(); // returns "ab"
iterator.hasNext(); // returns true
iterator.next(); // returns "ac"
iterator.hasNext(); // returns true
iterator.next(); // returns "bc"
iterator.hasNext(); // returns false
 * 
 * @author skadavath
 *
 */
public class IteratorForCombination {
	
	public static void main(String[] args) {
		
		IteratorForCombination iterator = new IteratorForCombination("abc",2);
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
	}
	
	List<String> resp = new ArrayList<>();
	int curr=0;
	public IteratorForCombination(String characters, int combinationLength) {
		
		
		generate(characters, combinationLength, 0, new StringBuilder());
		System.out.println(resp);
		

	}
	
	private void generate(String s,int len , int start,StringBuilder sb) {
		if(len==0) {
			resp.add(sb.toString());
			return;
		}
		for(int i=start;i<s.length();i++) {
			sb.append(s.charAt(i));
			generate(s, len-1, i+1, sb);
			sb.deleteCharAt(sb.length()-1);
		}
	}

	public String next() {
			return resp.get(curr++);
	}

	public boolean hasNext() {
			
		return curr<resp.size();
	}

}
