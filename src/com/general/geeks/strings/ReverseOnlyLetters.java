package com.general.geeks.strings;

/**
 * 
 * Given a string S, return the "reversed" string where all characters that are
 * not a letter stay in the same place, and all letters reverse their positions.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: "ab-cd" Output: "dc-ba" Example 2:
 * 
 * Input: "a-bC-dEf-ghIj" Output: "j-Ih-gfE-dCba" Example 3:
 * 
 * Input: "Test1ng-Leet=code-Q!" Output: "Qedo1ct-eeLg=ntse-T!"
 * 
 * 
 * Note:
 * 
 * S.length <= 100 33 <= S[i].ASCIIcode <= 122 S doesn't contain \ or "
 * 
 * 
 * @author skadavath
 *
 */
public class ReverseOnlyLetters {

	public static void main(String[] args) {

		System.out.println(new ReverseOnlyLetters().reverseOnlyLetters("7_28]"));

	}

	public String reverseOnlyLetters(String S) {

		int i = 0, j = S.length() - 1;
		char[] sArr = S.toCharArray();
		while (i < j && i < S.length() && j >= 0) {

			while (i<j && !Character.isLetter(sArr[i]))
				i++;
			while (i<j && !Character.isLetter(sArr[j]))
				j--;

			if (i < j) {
				char temp = sArr[i];
				sArr[i] = sArr[j];
				sArr[j] = temp;
				i++;
				j--;
			}
		}

		return new String(sArr);

	}

}
