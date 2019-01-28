package com.general.geeks.strings;

/**
 * 
 * Given two integers A and B, return any string S such that:

S has length A + B and contains exactly A 'a' letters, and exactly B 'b' letters;
The substring 'aaa' does not occur in S;
The substring 'bbb' does not occur in S.
 

Example 1:

Input: A = 1, B = 2
Output: "abb"
Explanation: "abb", "bab" and "bba" are all correct answers.
Example 2:

Input: A = 4, B = 1
Output: "aabaa"
 

Note:

0 <= A <= 100
0 <= B <= 100
It is guaranteed such an S exists for the given A and B.
 * 
 * @author skadavath
 *
 */
public class StringWithoutAAAorBBB {
	
	public static void main(String[] args) {
		
		System.out.println(new StringWithoutAAAorBBB().strWithout3a3b(4, 2));
		
	}
	
	 public String strWithout3a3b(int A, int B) {
	        return strWithout3a3b(A,B,'a','b');
	       
	    }
	    
	    public String strWithout3a3b(int A, int B,char a ,char b) {
	     
	         int i=A,j=B;
	        if(B>A) {
	            a='b';
	            b='a';
	            i=B;j=A;
	        }
	        StringBuilder sb = new StringBuilder();
	        while(i>0 || j >0) {
	            
	            if(i>0){sb.append(a);i--;};
	            if(i>j){sb.append(a);i--;}
	            if(j>0){sb.append(b);j--;}
	            
	            
	         
	        }
	        
	        return sb.toString();
	        
	        
	    }

}
