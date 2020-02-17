package com.general.geeks.strings;

/**
 * 
 *
 * Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made.

It is guaranteed that the answer is unique.

 

Example 1:

Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.
Example 2:

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation: 
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
Example 3:

Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"
 

Constraints:

1 <= s.length <= 10^5
2 <= k <= 10^4
s only contains lower case English letters.
Accepted
 * 
 * @author skadavath
 *
 */
public class RemoveAllAdjacentDuplicatesinStringII {
	
	public static void main(String[] args) {
		
		System.out.println(new RemoveAllAdjacentDuplicatesinStringII().removeDuplicates("pbbcggttciiippooaais", 2));
		
	}

	public String removeDuplicates(String s, int k) {
		
		int n=s.length(),i=0;
		int[] count = new int[n];
		char[] sArr = s.toCharArray();
		
		for(int j=0;j<n;j++,i++) {
			sArr[i] = sArr[j];
			count[i] = i>0 && sArr[i-1] == sArr[j] ? count[i-1]+1 : 1;
			if(count[i]==k)
				i-=k;
		}
		
		return new String(sArr,0,i);

	}

}
