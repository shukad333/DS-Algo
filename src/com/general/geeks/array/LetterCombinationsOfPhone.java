package com.general.geeks.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * Example:
 * 
 * Input: "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * 
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 * 
 * @author skadavath
 *
 */
public class LetterCombinationsOfPhone {
	
	public static void main(String[] args) {
		System.out.println(new LetterCombinationsOfPhone().letterCombinations("23"));
	}

	public List<String> letterCombinations(String digits) {
		
		String[] phoneKeys = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		
		List<String> resp = new ArrayList<String>();
		
		resp.add("");
		for(int i=0;i<digits.length();i++) {
			String digit = phoneKeys[digits.charAt(i)-'0'];
			resp = allCombinations(digit, resp);
		}
		
		return resp;

	}
	
	private List<String> allCombinations(String digit,List<String> resp) {
		
		List<String> res = new ArrayList<>();
		for(int i=0;i<digit.length();i++) {
			
			for(String r : resp) {
				res.add(r+digit.charAt(i));
			}
			
		}
		
		return res;
		
	}

}
