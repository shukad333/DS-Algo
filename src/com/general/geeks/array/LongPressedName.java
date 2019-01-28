package com.general.geeks.array;

/**
 * 
 * Your friend is typing his name into a keyboard. Sometimes, when typing a
 * character c, the key might get long pressed, and the character will be typed
 * 1 or more times.
 * 
 * You examine the typed characters of the keyboard. Return True if it is
 * possible that it was your friends name, with some characters (possibly none)
 * being long pressed.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: name = "alex", typed = "aaleex" Output: true Explanation: 'a' and 'e'
 * in 'alex' were long pressed. Example 2:
 * 
 * Input: name = "saeed", typed = "ssaaedd" Output: false Explanation: 'e' must
 * have been pressed twice, but it wasn't in the typed output. Example 3:
 * 
 * Input: name = "leelee", typed = "lleeelee" Output: true Example 4:
 * 
 * Input: name = "laiden", typed = "laiden" Output: true Explanation: It's not
 * necessary to long press any character.
 * 
 * 
 * Note:
 * 
 * name.length <= 1000 typed.length <= 1000 The characters of name and typed are
 * lowercase letters.
 * 
 * 
 * @author skadavath
 *
 */
public class LongPressedName {

	public static void main(String[] args) {

		System.out.println(new LongPressedName().isLongPressedName("kikcxmvzi", "kiikcxxmmvvzz"));

	}

	public boolean isLongPressedName(String name, String typed) {

		int t = 0, n = 0;
		while (t < typed.length() && n < name.length()) {

			if (typed.charAt(t) == name.charAt(n)) {
				t++;
				n++;
			}

			else if (t > 0 && typed.charAt(t - 1) == typed.charAt(t))
				t++;

			else
				return false;

		}

		while (t < typed.length()) {
			if (typed.charAt(t - 1) != typed.charAt(t))
				return false;
			t++;
		}

		return n==name.length();

	}

}
