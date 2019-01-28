package com.general.geeks.misc;

import java.util.Stack;

/**
 * Given a nested list of integers represented as a string, implement a parser
 * to deserialize it.
 * 
 * Each element is either an integer, or a list -- whose elements may also be
 * integers or other lists.
 * 
 * Note: You may assume that the string is well-formed:
 * 
 * String is non-empty. String does not contain white spaces. String contains
 * only digits 0-9, [, - ,, ]. Example 1:
 * 
 * Given s = "324",
 * 
 * You should return a NestedInteger object which contains a single integer 324.
 * Example 2:
 * 
 * Given s = "[123,[456,[789]]]",
 * 
 * Return a NestedInteger object containing a nested list with 2 elements:
 * 
 * 1. An integer containing value 123. 2. A nested list containing two elements:
 * i. An integer containing value 456. ii. A nested list with one element: a. An
 * integer containing value 789.
 * 
 * @author skadavath
 *
 */
public class MiniParser {

public NestedInteger deserialize(String s) {
        
        if (s.isEmpty())
        return null;
    if (s.charAt(0) != '[') 
        return new NestedInteger(Integer.valueOf(s));
		Stack<NestedInteger> stack = new Stack<>();
		NestedInteger nestedInteger = new NestedInteger();

		NestedInteger current = null;
		int l = 0;
		for (int i = 0; i < s.length(); i++) {

			if (s.charAt(i) == '[') {
				if (null != current) {
					stack.push(current);
				}
				
				l = i+1;
				current = new NestedInteger();

			} else if (s.charAt(i) == ']') {
				
				String num = s.substring(l,i);
				if(!num.isEmpty()) {
					current.add(new NestedInteger(Integer.valueOf(num)));
				}
				if(!stack.isEmpty()) {
					NestedInteger ni = stack.pop();
					ni.add(current);
					current = ni;
				}
                l = i+1;

			}
			else if (s.charAt(i)==',') {
                if(s.charAt(i-1)!=']') {
				int num = Integer.valueOf(s.substring(l, i));
				current.add(new NestedInteger(num));
            }
				l = i+1;
			}

		}

		return current;

	}
}



class NestedInteger {
	int value;
	NestedInteger ni;

	public NestedInteger() {
		// TODO Auto-generated constructor stub
	}

	public NestedInteger(int val) {
		this.value = val;
	}
	
	public void add(NestedInteger i) {
		
	}

}
