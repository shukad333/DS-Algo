package com.general.geeks.array;

/**
 * 
 * Given a string S of '(' and ')' parentheses, we add the minimum number of
 * parentheses ( '(' or ')', and in any positions ) so that the resulting
 * parentheses string is valid.
 * 
 * Formally, a parentheses string is valid if and only if:
 * 
 * It is the empty string, or It can be written as AB (A concatenated with B),
 * where A and B are valid strings, or It can be written as (A), where A is a
 * valid string. Given a parentheses string, return the minimum number of
 * parentheses we must add to make the resulting string valid.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: "())" Output: 1 Example 2:
 * 
 * Input: "(((" Output: 3 Example 3:
 * 
 * Input: "()" Output: 0 Example 4:
 * 
 * Input: "()))((" Output: 4
 * 
 * 
 * Note:
 * 
 * S.length <= 1000 S only consists of '(' and ')' characters.
 * 
 * 
 * @author skadavath
 *
 */
public class MinimumAddToMakeParanthesisValid {

	public static void main(String[] args) {

		System.out.println(new MinimumAddToMakeParanthesisValid().minAddToMakeValid("()))(("));

	}

	public int minAddToMakeValid(String S) {

		int left = 0, right = 0;

		for (char c : S.toCharArray()) {

			if (right == 0 && c == ')')
				left++;
			else
				right += c == '(' ? 1 : -1;

		}

		return left + right;

	}

}
