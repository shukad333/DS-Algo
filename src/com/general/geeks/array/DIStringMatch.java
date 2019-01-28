package com.general.geeks.array;

import java.util.Arrays;
import java.util.Stack;

/**
 * 
 * Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.

Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:

If S[i] == "I", then A[i] < A[i+1]
If S[i] == "D", then A[i] > A[i+1]
 

Example 1:

Input: "IDID"
Output: [0,4,1,3,2]
Example 2:

Input: "III"
Output: [0,1,2,3]
Example 3:

Input: "DDI"
Output: [3,2,0,1]
 

Note:

1 <= S.length <= 10000
S only contains characters "I" or "D".

 * 
 * @author skadavath
 *
 */
public class DIStringMatch {
	
	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(new DIStringMatch().diStringMatch("ID")));
		System.out.println(Arrays.toString(new DIStringMatch().diStringMatchStack("ID")));
		
		String  pscLicenseName= "1$2$-12-12";
		int descriptionIndex = pscLicenseName.indexOf("$");
		  String description = descriptionIndex==-1?null : pscLicenseName.substring(descriptionIndex+1);
		  String licenseKeyUUID = descriptionIndex==-1?pscLicenseName:pscLicenseName.substring(0, descriptionIndex);
		  
		  System.out.println(description+" "+licenseKeyUUID);
		
	}

	public int[] diStringMatch(String S) {

		int[] resp = new int[S.length() + 1];

		int index = 0, max = S.length()+1, min = 1;
		for (char c : S.toCharArray()) {

			if (c == 'D')
				resp[index++] = max--;
			else
				resp[index++] = min++;
		}

		resp[index] = min;
		return resp;

	}
	
	private int[] diStringMatchStack(String s) {
		
		int[] resp = new int[s.length()+1];
		
		Stack<Integer> stack = new Stack<>();
		
		int j=0;
		
		for(int i=1;i<=s.length();i++) {
			
			char c = s.charAt(i-1);
			
			if(c=='I') {
				
				stack.push(i);
				while(!stack.isEmpty()) {
					resp[j++] = stack.pop(); 
				}
				
			}
			else
				stack.push(i);
		}
		stack.push(s.length()+1);
		while(!stack.isEmpty()) {
			resp[j++] = stack.pop();
		}
		
		return resp;
	}
}
