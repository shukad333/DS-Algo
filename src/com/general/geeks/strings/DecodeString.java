package com.general.geeks.strings;

import java.util.Stack;

/**
 * 
 * Given an encoded string, return it's decoded string.
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed
 * to be a positive integer.
 * 
 * You may assume that the input string is always valid; No extra white spaces,
 * square brackets are well-formed, etc.
 * 
 * Furthermore, you may assume that the original data does not contain any
 * digits and that digits are only for those repeat numbers, k. For example,
 * there won't be input like 3a or 2[4].
 * 
 * Examples:
 * 
 * s = "3[a]2[bc]", return "aaabcbc". s = "3[a2[c]]", return "accaccacc". s =
 * "2[abc]3[cd]ef", return "abcabccdcdcdef".
 * 
 * @author skadavath
 *
 */
public class DecodeString {
	
	public static void main(String[] args) {
		System.out.println(new DecodeString().decodeString("2[a2[c]]"));
	}

	public String decodeString(String s) {
		
		Stack<String> stringStack = new Stack<String>();
		Stack<Integer> countStack = new Stack<Integer>();
		
		int i = 0;
		String str = "";
		while(i<s.length()) {
			
			if(Character.isDigit(s.charAt(i))) {
				int num = 0;
				while(Character.isDigit(s.charAt(i))) {
					num = num * 10 + s.charAt(i)-'0';
					i++;
				}
				countStack.add(num);
			}
			
			else if(s.charAt(i)=='[') {
				
				stringStack.push(str);
				str = "";
				i++;
			}
			
			else if (s.charAt(i)==']') {
				int count = countStack.pop();
				StringBuilder sb = new StringBuilder(stringStack.pop());
				String temp = str;
				for(int j=1;j<=count;j++) {
					sb.append(str);
				}
				
				str = sb.toString();
				i++;
			}
			
			else {
				str += s.charAt(i++);
			}
		}
		return str;

	}

}
