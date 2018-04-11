package com.general.geeks.misc;

public class ReverseWordsInString {
	
	public static void main(String[] args) {
		
		String s = " a b ";
		System.out.println(new ReverseWordsInString().reverseWords(s));
	}
	
	public String reverseWords(String s) {
		
		StringBuilder sb = new StringBuilder();
		String[] words = s.split(" ");
		for(int i=words.length-1;i>=0;i--) {
			if(!words[i].isEmpty()) {
			sb.append(words[i]);
			sb.append(" ");
			}
		}
		
		return sb.toString().trim();
	}

}
