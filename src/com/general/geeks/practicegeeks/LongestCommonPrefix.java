package com.general.geeks.practicegeeks;

import java.util.Scanner;

public class LongestCommonPrefix {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		String word = sc.nextLine();
		getLCP(word);
		
	}
	
	private static String getLCP(String words) {
		
		String[] s = words.split(" ");
		int[] lcp = new int[s.length];
		
		for(int i=0;i<s.length;i++) {
			String word = s[i].substring(0,lcp[i]+1);
			
		}
		return null;
	}
}
