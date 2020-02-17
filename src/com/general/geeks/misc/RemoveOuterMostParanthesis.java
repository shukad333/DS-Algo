package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * A valid parentheses string is either empty (""), "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.  For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.

A valid parentheses string S is primitive if it is nonempty, and there does not exist a way to split it into S = A+B, with A and B nonempty valid parentheses strings.

Given a valid parentheses string S, consider its primitive decomposition: S = P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.

Return S after removing the outermost parentheses of every primitive string in the primitive decomposition of S.

 

Example 1:

Input: "(()())(())"
Output: "()()()"
Explanation: 
The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
Example 2:

Input: "(()())(())(()(()))"
Output: "()()()()(())"
Explanation: 
The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
Example 3:

Input: "()()"
Output: ""
Explanation: 
The input string is "()()", with primitive decomposition "()" + "()".
After removing outer parentheses of each part, this is "" + "" = "".
 

Note:

S.length <= 10000
S[i] is "(" or ")"
S is a valid parentheses string
 * 
 * @author skadavath
 *
 */
public class RemoveOuterMostParanthesis {
	
	public static void main(String[] args) {
		
		System.out.println(new RemoveOuterMostParanthesis().removeOuterParentheses("(()())(())(()(()))"));
		
	}
	
	public String removeOuterParentheses(String S) {
		
		int opened=0;
		StringBuilder sb = new StringBuilder();
		for(char c : S.toCharArray()) {
			if(c=='(' && opened++>0)sb.append(c);
		}
		
	}

	public String _removeOuterParentheses(String S) {
		
		StringBuilder sb = new StringBuilder();
		
		Stack<Character> stack = new Stack<>();
		
		for(char c : S.toCharArray()) {
			
			if(stack.isEmpty() && c=='(') {
				stack.push(c);
			}
			else if(stack.size()>=1 && c=='(') {
				sb.append(c+"");
				stack.push(c);
			}
			else if(stack.size()>1 && c==')') {
				sb.append(c+"");
				stack.pop();
			}
			else if(stack.size()==1 && c==')') {
				stack.pop();
			}
			
		}
		
		return sb.toString();

	}

}
