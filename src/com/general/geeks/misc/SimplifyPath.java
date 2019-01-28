package com.general.geeks.misc;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"

Corner Cases:

Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
 * @author skadavath
 *
 */
public class SimplifyPath {
	
	public static void main(String[] args) {
		
		String s = "/a/./b/../../c/";
		String[] spl = s.split("/");
		SimplifyPath sp = new SimplifyPath();
		System.out.println(sp.simplifyPath(s));
	}

	public String simplifyPath(String path) {
		
		String[] spl = path.split("/");
		
		Stack<String> stack = new Stack<>();
		for(int i=0;i<spl.length;i++) {
			
			if(spl[i].equals(".") || spl[i].equals(""))
				continue;
			
			if(spl[i].equals("..")) {
				if(!stack.isEmpty())
					stack.pop();
				
			}
			
			else
				stack.push(spl[i]);
			
			
		}
		StringBuilder sb = new StringBuilder();
		String[] s = new String[stack.size()];
		int i = s.length-1;
		while(!stack.isEmpty()) {
			
			s[i--] = stack.pop();
		}
		sb.append("/");
		for(String str : s) {
			sb.append(str);
			sb.append("/");
		}
		return (sb.charAt(sb.length()-1)=='/' && s.length>=1) ? sb.substring(0,sb.length()-1) : sb.toString(); 

	}

}
