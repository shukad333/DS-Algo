package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Given a chemical formula (given as a string), return the count of each atom.
 * 
 * An atomic element always starts with an uppercase character, then zero or
 * more lowercase letters, representing the name.
 * 
 * 1 or more digits representing the count of that element may follow if the
 * count is greater than 1. If the count is 1, no digits will follow. For
 * example, H2O and H2O2 are possible, but H1O2 is impossible.
 * 
 * Two formulas concatenated together produce another formula. For example,
 * H2O2He3Mg4 is also a formula.
 * 
 * A formula placed in parentheses, and a count (optionally added) is also a
 * formula. For example, (H2O2) and (H2O2)3 are formulas.
 * 
 * Given a formula, output the count of all elements as a string in the
 * following form: the first name (in sorted order), followed by its count (if
 * that count is more than 1), followed by the second name (in sorted order),
 * followed by its count (if that count is more than 1), and so on.
 * 
 * Example 1: Input: formula = "H2O" Output: "H2O" Explanation: The count of
 * elements are {'H': 2, 'O': 1}. Example 2: Input: formula = "Mg(OH)2" Output:
 * "H2MgO2" Explanation: The count of elements are {'H': 2, 'Mg': 1, 'O': 2}.
 * Example 3: Input: formula = "K4(ON(SO3)2)2" Output: "K4N2O14S4" Explanation:
 * The count of elements are {'K': 4, 'N': 2, 'O': 14, 'S': 4}. Note:
 * 
 * All atom names consist of lowercase letters, except for the first character
 * which is uppercase. The length of formula will be in the range [1, 1000].
 * formula will only consist of letters, digits, and round parentheses, and is a
 * valid formula as defined in the problem.
 * 
 * @author skadavath
 *
 */
public class NumberOfAtoms {
	
	public static void main(String[] args) {
		System.out.println(new NumberOfAtoms().countOfAtoms("K4(ON(SO3)2)2"));
	}

	public String countOfAtoms(String formula) {
		
		Map<String, Integer> map = new HashMap<>();
		Stack<Map<String, Integer>> stack = new Stack<>();
		
		int n = formula.length();
		int i=0;
		while(i<n) {
			
			char c = formula.charAt(i);i++;
			
			if(c=='(') {
				stack.push(map);
				map = new HashMap<>();
			}
			else if(c==')') {
				
				int d = 0;
				while(i<n && Character.isDigit(formula.charAt(i))) {
					d = d*10 + formula.charAt(i++)-'0';
				}
				
				Map<String, Integer> temp = map;
				
				map = stack.pop();
				
				for(String s : temp.keySet()) {
					
					map.put(s, map.getOrDefault(s, 0)+temp.get(s)*(d==0?1:d));
					
					
				}
				
			}
			
			else {
				
				int start = i-1;
				while(i<n && Character.isLowerCase(formula.charAt(i))) {
					i++;
				}
				String element = formula.substring(start, i);
				int d = 0;
				int index = 10;
				while(i<n && Character.isDigit(formula.charAt(i))) {
					int digit = formula.charAt(i)-'0';
					d = d*10 + digit;
					i++;
				}
				if(d==0)d=1;
				map.put(element, map.getOrDefault(element,0)+d);
			}
		}
		
		List<String> keys = new ArrayList<>(map.keySet());
		Collections.sort(keys);
		StringBuilder resp = new StringBuilder();
		for(String s : keys) {
			resp.append(s+(map.get(s)==1?"":map.get(s)));
		}
		
		return resp.toString();

	}

}
