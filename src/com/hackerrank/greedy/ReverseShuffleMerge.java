package com.hackerrank.greedy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;


/**
 * 
 * Given a string, , we define some operations on the string as follows:

a.  denotes the string obtained by reversing string . Example:  


b.  denotes any string that's a permutation of string . Example:  


c.  denotes any string that's obtained by interspersing the two strings  & , maintaining the order of characters in both. For example,  & , one possible result of  could be , another could be , another could be  and so on.

Given a string  such that  for some string , find the lexicographically smallest .

For example, . We can split it into two strings of . The reverse is  and we need to find a string to shuffle in to get . The middle two characters match our reverse string, leaving the  and  at the ends. Our shuffle string needs to be . Lexicographically , so our answer is .

Function Description

Complete the reverseShuffleMerge function in the editor below. It must return the lexicographically smallest string fitting the criteria.

reverseShuffleMerge has the following parameter(s):

s: a string
Input Format

A single line containing the string .

Constraints

 contains only lower-case English letters, ascii[a-z]
Output Format

Find and return the string which is the lexicographically smallest valid .

Sample Input 0

eggegg
Sample Output 0

egg
Explanation 0

Split "eggegg" into strings of like character counts: "egg", "egg" 
reverse("egg") = "gge" 
shuffle("egg") can be "egg" 
"eggegg" belongs to the merge of ("gge", "egg")

The merge is: gge.

'egg' < 'gge'

Sample Input 1

abcdefgabcdefg
Sample Output 1

agfedcb
Explanation 1

Split the string into two strings with like characters:  and . 
Reverse  =  
Shuffle  can be  
Merge to bcdefga

Sample Input 2

aeiouuoiea
Sample Output 2

eaid
Explanation 2

Split the string into groups of like characters:  
Reverse  =  
These merge to uoiea
 * 
 * @author skadavath
 *
 */
public class ReverseShuffleMerge {
	
	public static void main(String[] args) {
		
		System.out.println(reverseShuffleMerge("aahaxxxhxhxxah"));
		
	}
	
	 // Complete the reverseShuffleMerge function below.
    static String reverseShuffleMerge(String s) {

    	int[] skip = new int[26];
    	int[] add = new int[26];
    	for(char c : s.toCharArray()) 
    		if(skip[c-'a']==0)
    		skip[c-'a']++;
    	
    	
    	for(int i=0;i<26;i++) {
    		
    		skip[i]/=2;
    		add[i]=skip[i];
    	}
    	
    	Stack<Character> stack = new Stack<>();
    	
    	for(int i=s.length()-1;i>=0;i--) {
    		
    		char ch = s.charAt(i);
    		
    		while(!stack.isEmpty() && add[ch-'a']>0 && stack.peek()>ch && skip[stack.peek()-'a']>0) {
    			
    			char peek = stack.pop();
    			add[peek-'a']++;
    			skip[peek-'a']--;
    		}
    		
    		if(add[ch-'a']>0) {
    			stack.push(ch);
    			add[ch-'a']--;
    		}
    		else {
    			skip[ch-'a']--;
    		}
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	
    	while(!stack.isEmpty()) {
    		sb.append(stack.pop()+"");
    	}
    	
    	
    	return sb.reverse().toString();
    	
    }

    private static final Scanner scanner = new Scanner(System.in);

//    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        String s = scanner.nextLine();
//
//        String result = reverseShuffleMerge(s);
//
//        bufferedWriter.write(result);
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
//    }
}


