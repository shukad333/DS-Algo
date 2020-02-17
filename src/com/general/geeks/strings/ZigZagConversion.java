package com.general.geeks.strings;

/**
 * 
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
 * 
 * @author skadavath
 *
 */
public class ZigZagConversion {
	
	public static void main(String[] args) {
		
		System.out.println(new ZigZagConversion().convert("PAYPALISHIRING", 4));
		
	}

	public String convert(String s, int numRows) {
		
		if(null==s || s.isEmpty()) {
            return "";
        }

		StringBuilder[] sb = new StringBuilder[numRows];
		
		int index =  0;
		for(int i=0;i<numRows;i++) {
			sb[i] = new StringBuilder();
		}
		while(index < s.length()) {
			
			for(int i=0;i<numRows-1 && index<s.length();i++) {
				sb[i].append(s.charAt(index++));
			}
			for(int i=numRows-2;i>=0 && index<s.length();i--) {
				sb[i].append(s.charAt(index++));
			}
		}
		
		for(int i=1;i<numRows-1;i++) {
			sb[0].append(sb[i]);
		}
		
		return sb[0].toString();
		
//		int index = 0;
//		while (index < s.length()) {
//			for (int i = 0; i < numRows && index<s.length(); i++) {
//				if(sb[i]==null)
//					sb[i] = new StringBuilder();
//				sb[i].append(s.charAt(index++));
//
//			}
//			
//			for(int j=numRows-2;j>0 && index<s.length();j--) {
//				if(sb[j]==null)
//					sb[j] = new StringBuilder();
//				sb[j].append(s.charAt(index++));
//				
//			}
//		}
//		
//		String resp = sb[0].toString();
//		for(int i=1;i<numRows;i++) {
//			resp+=sb[i].toString();
//		}
//
//		return resp;

	}

}
