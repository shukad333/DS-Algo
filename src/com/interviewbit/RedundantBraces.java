package com.interviewbit;

import java.util.Stack;

public class RedundantBraces {

	public static void main(String[] args) {

		System.out.println(new RedundantBraces().braces("(a+b+(c))"));

	}

	public int braces(String a) {

		Stack<Character> st = new Stack<>();

		for (char c : a.toCharArray()) {

			if (c == ')') {

				char top = st.pop();
				boolean isRed = true;
				while (top != '(') {
					
					if (top == '+' || top == '*' || top == '-' || top == '/') {

						isRed = false;

					}
					top = st.pop();
				}

				if (isRed)
					return 1;

			}

			else
				st.push(c);
		}

		return 0;

	}
}
