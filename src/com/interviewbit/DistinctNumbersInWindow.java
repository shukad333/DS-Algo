package com.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class DistinctNumbersInWindow {

	public static void main(String[] args) {
		
		List<Integer> inp = Arrays.asList(1, 2, 1, 3, 4, 3);
		
		System.out.println(new DistinctNumbersInWindow().dNums(inp, 3));
		
	}

	public ArrayList<Integer> dNums(List<Integer> A, int B) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (A.size() == 0 || A.size() < B)
			return list;

		
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < A.size(); i++) {

			
			if(i>=B) {
				
				list.add(map.keySet().size());
				int toRemove = A.get(i-B);
				
				if(map.get(toRemove)>1) {
					map.put(toRemove, map.get(toRemove)-1);
				}
				else 
					map.remove(toRemove);
				
				
					
			}
			
			map.put(A.get(i), map.getOrDefault(A.get(i), 0)+1);
			
			
			
			
		}
		
		list.add(map.keySet().size());

		return list;

	}

}
