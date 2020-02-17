package com.general.geeks.misc;

/**
 * 
 * Given an array equations of strings that represent relationships between variables, each string equations[i] has length 4 and takes one of two different forms: "a==b" or "a!=b".  Here, a and b are lowercase letters (not necessarily different) that represent one-letter variable names.

Return true if and only if it is possible to assign integers to variable names so as to satisfy all the given equations.

 

Example 1:

Input: ["a==b","b!=a"]
Output: false
Explanation: If we assign say, a = 1 and b = 1, then the first equation is satisfied, but not the second.  There is no way to assign the variables to satisfy both equations.
Example 2:

Input: ["b==a","a==b"]
Output: true
Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
Example 3:

Input: ["a==b","b==c","a==c"]
Output: true
Example 4:

Input: ["a==b","b!=c","c==a"]
Output: false
Example 5:

Input: ["c==c","b==d","x!=z"]
Output: true
 
 * 
 * @author skadavath
 *
 */
public class SatisfiabilityOfEqualityEquations {
	
	public static void main(String[] args) {
		
		SatisfiabilityOfEqualityEquations sf = new SatisfiabilityOfEqualityEquations();
		System.out.println(sf.equationsPossible(new String[] {"b!=f","c!=e","f==f","d==f","b==f","a==f"}));
		
		
	}
public boolean equationsPossible(String[] equations) {
		
		int[] variableArr = new int[26];
		for(int i=0;i<26;i++)
			variableArr[i] = i;
		
		for(String equation : equations) {
			
			if(equation.charAt(1)=='=') {
				int op1 = equation.charAt(0)-'a';
				int op2 = equation.charAt(3)-'a';
				variableArr[unionFind(variableArr,op2)] = unionFind(variableArr, op1);
			}
		}
		
		for(String equation : equations) {
			
			if(equation.charAt(1)=='!') {
				int op1 = equation.charAt(0)-'a';
				int op2 = equation.charAt(3)-'a';
				if(unionFind(variableArr, op1)==unionFind(variableArr, op2))
					return false;
			}
		}
	
		//System.out.println("Parent of c is "+(char)(unionFind(variableArr, 1)+97));
		return true;

	}
	
	private int unionFind(int[] arr,int a) {
		if(arr[a]!=a)
			arr[a]=unionFind(arr, arr[a]);
		return arr[a];
	}

}
