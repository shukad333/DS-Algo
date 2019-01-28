package com.general.geeks.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given a string, find the first non-repeating character in it. For example, if
 * the input string is “GeeksforGeeks”, then output should be ‘f’ and if input
 * string is “GeeksQuiz”, then output should be ‘G’.
 * 
 * @author skadavath
 *
 */
public class FirstNonRepeatingCharacterStringSinglePass {
	
	public static void main(String[] args) {
		
		System.out.println(new FirstNonRepeatingCharacterStringSinglePass().firstNonRepeating("GeeksforGeeks"));
		
	}
	
	public char firstNonRepeating(String str) {
		
		Map<Character,Count> map = new HashMap<>();
		
		for(int i=0;i<str.length();i++) {
			
			char c = str.charAt(i);
			if(map.get(c)==null)
			map.put(c, new Count(i));
			else
				map.get(c).increment();
			
		}
		
		int min = Integer.MAX_VALUE;
		for(Map.Entry<Character, Count> entry : map.entrySet()) {
			
			if(entry.getValue().index<min && entry.getValue().count==1)
				min = entry.getValue().index;
		}
		return str.charAt(min);
	}

}

class Count {
	
	int count,index;
	public Count(int index) {
		count = 1;
		this.index = index;
	}
	
	public void increment() {
		this.count++;
	}
}
