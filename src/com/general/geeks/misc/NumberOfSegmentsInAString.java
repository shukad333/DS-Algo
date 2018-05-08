package com.general.geeks.misc;

/**
 * Count the number of segments in a string, where a segment is defined to be a
 * contiguous sequence of non-space characters.
 * 
 * Please note that the string does not contain any non-printable characters.
 * 
 * Example:
 * 
 * Input: "Hello, my name is John" Output: 5
 * 
 * @author skadavath
 *
 */
public class NumberOfSegmentsInAString {
	
	public static void main(String[] args) {
		
		System.out.println(new NumberOfSegmentsInAString().countSegments(", , , ,        a, eaefa"));
	}
	
	 public int countSegments(String s) {
	        
	        if(s.isEmpty()) {
	            return 0;
	        }
	        String[] arr = s.split(" ");
	        int count = 0;
	        for(String str : arr) {
	        	
	        	if(!str.trim().isEmpty()) {
	        		count++;
	        	}
	        	
	        }
	        return count;
	        
	    }
}
