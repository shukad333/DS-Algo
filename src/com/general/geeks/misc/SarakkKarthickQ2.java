package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.List;

public class SarakkKarthickQ2 {
	
	public static void main(String[] args) {
	
		//System.out.println(new SarakkKarthickQ2().solve(new int[]{-3,-14,-5,7,8,42,8,3}));
		
		System.out.println(new SarakkKarthickQ2().solve(10,10));
	}
	
	private String appendEqual(char ch1, char ch2, int count, String result) {
        while(count>0) {
            result+=ch1;
            result+=ch2;
            count--;
        }	    			
		return result;
	}
	
	public String solve(int A, int B) {

		String result = "";
		while (A > 0 || B > 0) {
			if (A > B) {
				for (int i = 0; i < 2 && A > 0; i++, A--) {
					result += 'a';
				}
				if (B > 0) {
					result += 'b';
					B--;
				}
			} else if (A < B) {
				for (int i = 0; i < 2 && B > 0; i++, B--) {
					result += 'b';
				}
				if (A > 0) {
					result += 'a';
					A--;
				}
			} else {
				if (result.length() == 0) {
					return appendEqual('a', 'b', A, result);
				} else {
					if (result.charAt(result.length() - 1) == 'a') {
						return appendEqual('b', 'a', A, result);
					} else {
						return appendEqual('a', 'b', A, result);
					}
				}
			}
		}
		
		return result;
	}
	
	
	

}
