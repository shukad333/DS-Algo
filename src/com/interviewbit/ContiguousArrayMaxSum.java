package com.interviewbit;

import java.util.List;

public class ContiguousArrayMaxSum {
	
	//Kadanes Algo
	public int maxSubArray(final List<Integer> A) {
		
		int max_so_far = Integer.MIN_VALUE,max_ending_here = 0;
		
		for(int i : A) {
			
			max_ending_here += i;
			max_so_far = Math.max(max_so_far, max_ending_here);
			if(max_ending_here<0)
				max_ending_here = 0;
		}
		
		return max_so_far;
    }

}
