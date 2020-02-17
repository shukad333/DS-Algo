package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Example 1:

Input: "()())()"
Output: ["()()()", "(())()"]
Example 2:

Input: "(a)())()"
Output: ["(a)()()", "(a())()"]
Example 3:

Input: ")("
Output: [""]
 * 
 * @author skadavath
 *
 */
public class RemoveInvalidParanthesis {
	
	public static void main(String[] args) {
		
		System.out.println(new RemoveInvalidParanthesis().removeInvalidParentheses("()())()"));
		
	}

	public List<String> removeInvalidParentheses(String s) {
		
		List<String> resp = new ArrayList<>();
		Queue<String> queue = new LinkedList<>();
		
		queue.add(s);
		Set<String> visited = new HashSet<>();
		visited.add(s);
		
		boolean found = false;
		while(!queue.isEmpty()) {
			
			s = queue.poll();
			if(isValid(s)) {
				resp.add(s);
				found = true;
			}
			
			if(found)continue;
			
			for(int i=0;i<s.length();i++) {
				if(s.charAt(i)!='(' && s.charAt(i)!=')')
					continue;
				
				String temp = s.substring(0, i) + s.substring(i+1);
				if(!visited.contains(temp)) {
					visited.add(temp);
					queue.offer(temp);
				}
			}
			
		}
		
		return resp;

	}
	
	boolean isValid(String s) {
	      int count = 0;
	    
	      for (int i = 0; i < s.length(); i++) {
	        char c = s.charAt(i);
	        if (c == '(') count++;
	        if (c == ')' && count-- == 0) return false;
	      }
	    
	      return count == 0;
	    }

}
