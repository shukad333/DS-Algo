package com.general.geeks.queandstack;

import java.util.Stack;

/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.
 */
public class ValidParanthesis {
	
	public static void main(String[] args) {
		
		System.out.println(new ValidParanthesis().isValid(")"));
	}

	public boolean isValid(String s) {
		
		if(null==s || s.isEmpty()) {
			return true;
		}
		
		
		Stack<Character> stack = new Stack();
		
		for(int i=0;i<s.length();i++) {
			
			char c = s.charAt(i);
			if(isValidSymbol(c)) {
				
				if(shouldPush(c)) {
					
					stack.push(c);
					continue;
					
				}
				
				if(shouldPop(c)) {
					if(!stack.isEmpty()) {
						if(!validClosing(stack.peek(), c)) {
							return false;
						}
						stack.pop();
					}
					else
						return false;
				}
			}
		}
		return stack.isEmpty();

	}
	
	private boolean isValidSymbol(char c) {
		
		return "{}()[]".indexOf(c)!=-1;
	}
	
	private boolean shouldPush(char c) {
		
		return "{([".indexOf(c)!=-1;
	}
	
	private boolean shouldPop(char c) {
		return "})]".indexOf(c)!=-1;
	}
	
	private boolean validClosing(char s,char d) {
		return (s=='{' && d=='}') || (s=='[' && d==']') || (s=='(' && d==')');  
	}

}
