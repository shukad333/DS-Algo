package com.general.geeks.strings;

/**
 * 
 * Print all substrings of a string
 * 
 * @author skadavath
 *
 */
public class SubstringsOfAString {
	
	public static void main(String[] args) {
		
		new SubstringsOfAString().printAllSubstrings("abc");
	}
	
	private void printAllSubstrings(String s) {
		
		for(int i=0;i<s.length();i++) {
			for(int j=i+1;j<=s.length();j++) {
				System.out.println(s.substring(i, j));
			}
		}
	}

}
