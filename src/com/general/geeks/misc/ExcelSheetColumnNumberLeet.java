package com.general.geeks.misc;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
    ...
Example 1:

Input: 1
Output: "A"
Example 2:

Input: 28
Output: "AB"
Example 3:

Input: 701
Output: "ZY"

 * @author skadavath
 *
 */
public class ExcelSheetColumnNumberLeet {
	
	public static void main(String[] args) {
		
		System.out.println(new ExcelSheetColumnNumberLeet().convertToTitle(2109));
		
	}

	public String convertToTitle(int n) {
		
		String resp = "";
		
		while(n>0) {
			n--;
			resp = (char)('A' + n%26) + resp;
			n/=26;
		}
		return resp;

	}

}
