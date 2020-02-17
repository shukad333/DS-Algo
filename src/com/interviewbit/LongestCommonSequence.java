package com.interviewbit;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestCommonSequence {
	
	public static void main(String[] args) {
		
		System.out.println(new LongestCommonSequence().longestConsecutive(Arrays.asList(5,3,2,1,4,100,102)));
		
	}
	
	public int longestConsecutive(final List<Integer> A) {
		
		Set<Integer> set = new HashSet<>();
		
		for(int i : A)
			set.add(i);
		
		int max = Integer.MIN_VALUE;
		for(int i : A) {
			
			if(!set.contains(i-1)) {
				
				int j = 1;
				while(set.contains(i+j)) {
					j++;
				}
				
				max = Math.max(max, j);
				
			}
		}
		
		return max;
    }

}
