package com.general.geeks.misc;

import java.util.Stack;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string may contain open ( and closing parentheses ), the plus
 * + or minus sign -, non-negative integers and empty spaces .
 * 
 * Example 1:
 * 
 * Input: "1 + 1" Output: 2 Example 2:
 * 
 * Input: " 2-1 + 2 " Output: 3 Example 3:
 * 
 * Input: "(1+(4+5+2)-3)+(6+8)" Output: 23 Note: You may assume that the given
 * expression is always valid. Do not use the eval built-in library function.
 * 
 * @author skadavath
 *
 */
public class BasicCalculator {

	public static void main(String[] args) {

		System.out.println(new BasicCalculator().calculate("(1+(4+5+ 2)-3)+(6+8)"));

	}

	public int calculate(String s) {

		Stack<Integer> stack = new Stack<>();

		int sign = 1;
		int num = 0;
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				num = num * 10 + Integer.parseInt(c + "");
			}

			else if (c == '+') {
				res += sign * num;
				num = 0;
				sign = 1;
			} else if (c == '-') {
				res += sign * num;
				num = 0;
				sign = -1;
			} else if (c == '(') {
				stack.push(res);
				stack.push(sign);
				sign = 1;
				res = 0;
			} else if (c == ')') {
				res += sign * num;
				num = 0;
				res *= stack.pop(); // sign
				res += stack.pop(); // res till now
			}
		}

		if (num != 0)
			res += sign * num;

		return res;
	}
}
