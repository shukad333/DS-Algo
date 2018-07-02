package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given two strings A and B of lowercase letters, return true if and only if we
 * can swap two letters in A so that the result equals B.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: A = "ab", B = "ba" Output: true Example 2:
 * 
 * Input: A = "ab", B = "ab" Output: false Example 3:
 * 
 * Input: A = "aa", B = "aa" Output: true Example 4:
 * 
 * Input: A = "aaaaaaabc", B = "aaaaaaacb" Output: true Example 5:
 * 
 * Input: A = "", B = "aa" Output: false
 * 
 * @author skadavath
 *
 */
public class BuddyString {
	
	public static void main(String[] args) {
		System.out.println(new BuddyString().buddyStrings("aaaaaaabc", "aaaaaaacb"));
	}

	public boolean buddyStrings(String A, String B) {
		
		if(A.length()!=B.length())
			return false;
		if(A.equals(B)) {
			Set<Character> set = new HashSet<>();
			for(char c : A.toCharArray()) {
				set.add(c);
			}
			return set.size() < A.length();
		}
		
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<A.length();i++) {
			if(A.charAt(i)!=B.charAt(i)) {
				list.add(i);
			}
		}
		
		return list.size()==2 && A.charAt(list.get(0))==B.charAt(list.get(1)) && A.charAt(list.get(1))==B.charAt(list.get(0));

	}

}
