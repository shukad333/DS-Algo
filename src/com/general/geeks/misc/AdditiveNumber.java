package com.general.geeks.misc;

/**
 * Additive number is a string whose digits can form additive sequence.
 * 
 * A valid additive sequence should contain at least three numbers. Except for
 * the first two numbers, each subsequent number in the sequence must be the sum
 * of the preceding two.
 * 
 * Given a string containing only digits '0'-'9', write a function to determine
 * if it's an additive number.
 * 
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence
 * 1, 2, 03 or 1, 02, 3 is invalid.
 * 
 * Example 1:
 * 
 * Input: "112358" Output: true Explanation: The digits can form an additive
 * sequence: 1, 1, 2, 3, 5, 8. 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * Example 2:
 * 
 * Input: "199100199" Output: true Explanation: The additive sequence is: 1, 99,
 * 100, 199. 1 + 99 = 100, 99 + 100 = 199
 * 
 * @author skadavath
 *
 */
public class AdditiveNumber {
	
	public static void main(String[] args) {
		System.out.println(new AdditiveNumber().isAdditiveNumber("1199100199"));
	}

	public boolean isAdditiveNumber(String num) {

		int L = num.length();

		for (int i = 1; i <= (L - 1) / 2; i++) {
			// A cannot start with a 0 if its length is more than 1
			if (num.charAt(0) == '0' && i >= 2)
				break; // previous code: continue;

			// choose the second number B
			for (int j = i + 1; L - j >= j - i && L - j >= i; j++) {
				// B cannot start with a 0 if its length is more than 1
				if (num.charAt(i) == '0' && j - i >= 2)
					break; // previous: continue;

				long num1 = Long.parseLong(num.substring(0, i)); // A
				long num2 = Long.parseLong(num.substring(i, j)); // B
				String substr = num.substring(j); // remaining string

				if (isAdditive(substr, num1, num2))
					return true; // return true if passes isAdditive test
				// else continue; // continue for loop if does not pass isAdditive test
			}
		}
		return false; // does not pass isAdditive test, thus is not additive
	}

	private boolean isAdditive(String s, long first, long second) {
		if (s.equals(""))
			return true;

		long sum = first + second;
		String sumStr = ((Long) sum).toString();
		if (!s.startsWith(sumStr))
			return false;
		return isAdditive(s.substring(s.length()), first, sum);
	}

}
