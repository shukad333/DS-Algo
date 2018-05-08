package com.general.geeks.misc;

import java.util.LinkedList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 * 
 * @author skadavath
 *
 */
public class GenerateParanthesis {
	
	public static void main(String[] args) {
		
		List<String> res = new GenerateParanthesis().generateParenthesis(2);
		for(String s : res) {
			System.out.println(s);
		}
	}

	public List<String> generateParenthesis(int n) {

		if (n == 0) {
			return null;
		}
		
		LinkedList<String> result = new LinkedList();
		generate(result, new char[n*2], n, 0, 0, 0);
		return result;
		

	}

	public void generate(LinkedList<String> paranthesis, char[] str, int n, int pos, int open, int close) {

		if (n == close) {
			String s = new String(str);
			paranthesis.add(s);
			return;
		} else {
			if (open > close) {
				str[pos] = ')';
				generate(paranthesis, str, n, pos + 1, open, close+1);
			}

			if (open < n) {
				str[pos] = '(';
				generate(paranthesis, str, n, pos + 1, open+1, close);
			}
		}

	}
}
