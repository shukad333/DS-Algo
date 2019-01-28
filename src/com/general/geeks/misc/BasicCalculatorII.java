package com.general.geeks.misc;

import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

Example 1:

Input: "3+2*2"
Output: 7
Example 2:

Input: " 3/2 "
Output: 1
Example 3:

Input: " 3+5 / 2 "
Output: 5
Note:
 * @author skadavath
 *
 */
public class BasicCalculatorII {
	
	public static void main(String[] args) {
		
		System.out.println(new BasicCalculatorII().calculate("3+2*2"));
		
	}

	public int calculate(String s) {
		
		Stack<Integer> stack = new Stack<>();
		
		char lastSign = '+';
		int num = 0;
		for(int i=0;i<s.length();i++) {
			
			if(Character.isDigit(s.charAt(i)))
				num = num*10 + Integer.parseInt(s.charAt(i)+"");
			if(!Character.isDigit(s.charAt(i)) || i==s.length()-1) {
				
				char c = s.charAt(i);
				
				if(lastSign=='+')
					stack.push(num);
				if(lastSign=='-')
					stack.push(-num);
				if(lastSign=='*')
					stack.push(stack.pop()*num);
				if(lastSign=='/')
					stack.push(stack.pop()/num);
				
				lastSign = s.charAt(i);
				num=0;
				
			}
			
		}
		
		int resp = 0;
		for(int i :stack) {
			resp+=i;
		}
		return resp;

	}

}
