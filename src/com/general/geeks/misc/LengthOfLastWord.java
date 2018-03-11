package com.general.geeks.misc;

public class LengthOfLastWord {
	
	public static void main(String[] args) {
		
		LengthOfLastWord lw = new LengthOfLastWord();
		System.out.println(lw.LengthOfLastWord(""));
	}
	
	private int LengthOfLastWord(String s) {
		if(null==s || s.length()==0) {
			return 0;
		}
		
		String[] words = s.split(" ");
		int cnt=0;
		for(int i=0;i<words.length;i++) {
			cnt = words[i].length();
		}
		
		return cnt;
	}

}
