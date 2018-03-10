package com.general.geeks.misc;

/*
 * 
 * 1
 * 11
 * 21
 * 1211
 * 111221
 * 312211
 * So on .. Generate the nth count and say character
 */
public class CountAndSay {
	
	public static void main(String[] args) {
		
		CountAndSay count = new CountAndSay();
		System.out.println(count.getNthCountAndSay(6));
	}
	
	public String getNthCountAndSay(int n) {
		if(n==1) {
			return "1";
		}
		if(n==2) {
			return "11";
		}
		
		String str = "11";
		for(int i=3;i<=n;i++) {
			
			str+="$";
			char chr = str.charAt(0);
			StringBuilder sb = new StringBuilder();
			int count = 1;
			for(int j=1;j<str.length();j++) {
				
				
				char temp = str.charAt(j);
				if(chr==temp)
					count++;
				else {
					
					sb.append(count+""+chr);
					count = 1;
					chr = temp;
				}
			}
			str = sb.toString();
		}
		return str;
	}

}
