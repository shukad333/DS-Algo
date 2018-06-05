package com.general.geeks.strings;

import java.util.Stack;

/**
 * Given two strings S and T, return if they are equal when both are typed into
 * empty text editors. # means a backspace character.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: S = "ab#c", T = "ad#c" Output: true Explanation: Both S and T become
 * "ac". Example 2:
 * 
 * Input: S = "ab##", T = "c#d#" Output: true Explanation: Both S and T become
 * "". Example 3:
 * 
 * Input: S = "a##c", T = "#a#c" Output: true Explanation: Both S and T become
 * "c". Example 4:
 * 
 * Input: S = "a#c", T = "b" Output: false Explanation: S becomes "c" while T
 * becomes "b".
 * 
 * @author skadavath
 *
 */
public class BackSpaceStringCompare {
	
	public static void main(String[] args) {
		System.out.println(new BackSpaceStringCompare().backspaceCompare("ab##", "c#d#"));
	}

	public boolean backspaceCompare(String S, String T) {
		
		return getString(S).equals(getString(T));

	}
	
	public String getString(String str) {
		Stack<Character> stack = new Stack<>();
		
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);
			if(c=='#') {
				if(!stack.isEmpty())
				stack.pop();
			}
			else
				stack.push(c);
		}
		
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.toString();
	}

}
