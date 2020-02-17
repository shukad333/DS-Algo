package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * A query word matches a given pattern if we can insert lowercase letters to the pattern word so that it equals the query. (We may insert each character at any position, and may insert 0 characters.)

Given a list of queries, and a pattern, return an answer list of booleans, where answer[i] is true if and only if queries[i] matches the pattern.

 

Example 1:

Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
Output: [true,false,true,true,false]
Explanation: 
"FooBar" can be generated like this "F" + "oo" + "B" + "ar".
"FootBall" can be generated like this "F" + "oot" + "B" + "all".
"FrameBuffer" can be generated like this "F" + "rame" + "B" + "uffer".
Example 2:

Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
Output: [true,false,true,false,false]
Explanation: 
"FooBar" can be generated like this "Fo" + "o" + "Ba" + "r".
"FootBall" can be generated like this "Fo" + "ot" + "Ba" + "ll".
Example 3:

Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
Output: [false,true,false,false,false]
Explanation: 
"FooBarTest" can be generated like this "Fo" + "o" + "Ba" + "r" + "T" + "est".
 

Note:

1 <= queries.length <= 100
1 <= queries[i].length <= 100
1 <= pattern.length <= 100
All strings consists only of lower and upper case English letters.
 * 
 * @author skadavath
 *
 */
public class CamelCaseMatching {
	
	public static void main(String[] args) {
		
		System.out.println(new CamelCaseMatching().camelMatch(new String[] {"FooBarTrash"}, "FoBaT"));
		
	}

	public List<Boolean> camelMatch(String[] queries, String pattern) {
		
		List<Boolean> resp = new ArrayList<>();
		for(String query : queries) {
			resp.add(doesMatch(query.toCharArray(), pattern.toCharArray()));
		}
		
		return resp;

	}
	
	private boolean doesMatch(char[] query,char[] pattern) {
		
		int p=0,q=0;
		
		for(q=0;p<query.length&&q<query.length;q++) {
			
			if(p<pattern.length && pattern[p]==query[q]) {
				p++;
			}
			else if(Character.isUpperCase(query[q]))
				return false;
			
		}
		
		return q==query.length;
		
		
	}

}
