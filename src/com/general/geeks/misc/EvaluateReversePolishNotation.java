package com.general.geeks.misc;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Note:

Division between two integers should truncate toward zero.
The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
Example 1:

Input: ["2", "1", "+", "3", "*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9
Example 2:

Input: ["4", "13", "5", "/", "+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6
Example 3:

Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
Output: 22
Explanation: 
  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22
 * @author skadavath
 *
 */
public class EvaluateReversePolishNotation {
	
	public static void main(String[] args) {
		System.out.println(new EvaluateReversePolishNotation().evalRPN(new String[] {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
	}

	public int evalRPN(String[] tokens) {
		
		Stack<Integer> stack = new Stack<>();
		for(String token : tokens) {
			
			if(token.equals("+")) {
				stack.add(stack.pop()+stack.pop());
			}
			else if(token.equals("/")) {
				int a = stack.pop();
				int b = stack.pop();
				stack.add(b/a);
			}
			else if(token.equals("*")) {
				stack.add(stack.pop()*stack.pop());
			}
			else if(token.equals("-")) {
				int a = stack.pop();
				int b = stack.pop();
				stack.add(b-a);
			}
			else {
				stack.add(Integer.parseInt(token));
			}
		}
		return stack.pop();
		

	}

}
