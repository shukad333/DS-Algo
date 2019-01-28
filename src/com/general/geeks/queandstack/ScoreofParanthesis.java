package com.general.geeks.queandstack;

import java.util.Collections;
import java.util.Stack;

/**
 * Given a balanced parentheses string S, compute the score of the string based
 * on the following rule:
 * 
 * () has score 1 AB has score A + B, where A and B are balanced parentheses
 * strings. (A) has score 2 * A, where A is a balanced parentheses string.
 * 
 * 
 * Example 1:
 * 
 * Input: "()" Output: 1 Example 2:
 * 
 * Input: "(())" Output: 2 Example 3:
 * 
 * Input: "()()" Output: 2 Example 4:
 * 
 * Input: "(()(()))" Output: 6
 * 
 * @author skadavath
 *
 */
public class ScoreofParanthesis {

	public static void main(String[] args) {

		System.out.println(new ScoreofParanthesis().scoreOfParentheses("(()(()))"));

	}

	public int scoreOfParentheses(String S) {
		
		

		int result = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < S.length(); i++) {
			char para = S.charAt(i);

			if (para == '(') {
				stack.push(-1);
			} else {
				int localRes = 0;
				while (!stack.isEmpty() && stack.peek() != -1) {

					localRes += stack.pop();
				}

				stack.pop();
				stack.push(localRes == 0 ? 1 : 2 * localRes);

			}
		}
		while (!stack.isEmpty()) {
			result += stack.pop();
		}
		return result;

	}

}
