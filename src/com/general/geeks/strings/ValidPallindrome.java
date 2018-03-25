package com.general.geeks.strings;

/*
 * Given a string, determine if it is a palindrome, 
 * considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
 */
public class ValidPallindrome {

	public boolean isPalindrome(String s) {

		if (null == s || s.length() == 0) {
			return true;
		}

		int start = 0;
		int end = s.length() - 1;

		while (start < end) {
			char first = s.charAt(start);
			char last = s.charAt(end);
			if (isValidChar(first) && isValidChar(last)) {
				if (Character.toUpperCase(first) != Character.toUpperCase(last)) {
					return false;
				}
				start++;
				end--;
			} else {

				if (!isValidChar(first))
					start++;
				if (!isValidChar(last))
					end--;
			}
		}
		return true;
	}

	private boolean isValidChar(char c) {

		return ((c >= 65 && c <= 90) || (c >= 97 && c <= 122) || (c >= 48 && c <= 57));
	}

	public static void main(String[] args) {

		String s = "Sh$ail";
		char c = '1';
		System.out.println(new ValidPallindrome().isPalindrome("race a car"));
	}
}
