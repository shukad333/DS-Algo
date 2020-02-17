package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonIntersectionPoints {
	
	public static void main(String[] args) {
		
		
		List<List<Integer>> inp = new ArrayList<>();
		
		inp.add(Arrays.asList(1,2,3));
		inp.add(Arrays.asList(2,3,4));
		inp.add(Arrays.asList(3,4,5));
		
		System.out.println(new CommonIntersectionPoints().getCommon(inp));
		
		
	}
	
	private Set<Integer> getCommon(List<List<Integer>> lists) {
		
		Set<Integer> set = new HashSet<>(lists.get(0));
		
		for(int i=1;i<lists.size();i++) {
			
			List<Integer> currList = lists.get(i);
			Set<Integer> currSet = new HashSet<>();
			for(int num : currList) {
				
				if(set.contains(num))
					currSet.add(num);
				
			}
			
			set = currSet;
			
		}
		return set;
		
	}

}
