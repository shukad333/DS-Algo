package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
Example 2:

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"
 * 
 * @author skadavath
 *
 */
public class LongestValidParanthesis {
	
	public static void main(String[] args) {
		
		List<String> nics = Arrays.asList("v1","v2","v3");
		Predicate<PNIC> pr = pNic -> nics.contains(pNic.getName());
		
		List<PNIC> nicsNew = new ArrayList<>();
		PNIC p1 = new PNIC();
		p1.setName("v5");
		nicsNew.add(p1);
		p1 = new PNIC();
		p1.setName("v1");
		nicsNew.add(p1);
		p1 = new PNIC();
		p1.setName("v5");
		nicsNew.add(p1);
		
		System.out.println(nicsNew.stream().filter(pr).collect(Collectors.toList()).get(0).getName());
		
		
		System.out.println(new LongestValidParanthesis().longestValidParentheses(")()())"));
		
	}
	
	
	
	public int longestValidParentheses(String s) {
		
		int n = s.length();
		
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<n;i++) {
			
			char p = s.charAt(i);
			
			if(p=='(')
				stack.push(i);
			else {
				if(!stack.isEmpty()) {
					if(s.charAt(stack.peek())=='(')
						stack.pop();
					else
						stack.push(i);
				}
				else
					stack.push(i);
			}
		}
		
		int longest = 0;
		if(stack.isEmpty())
			return n;
		
		int a=n,b=0;
		while(!stack.isEmpty()) {
			b=stack.pop();
			longest = Math.max(longest, a-b-1);
			a=b;
		}
		
		longest = Math.max(longest, a);
		
		return longest;

	}

}

class PNIC {
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
