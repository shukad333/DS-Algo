package com.general.geeks.misc;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

public class SetToArray {
	
	public static void main(String[] args) {
		
		Set<String> set = new HashSet();
		set.add("geeks");
		set.add("for");
		set.add("geeks");
		String[] arr = set.stream().toArray(String[] ::new);
		
		for(String s : arr) {
			System.out.println(s);
		}
		
		//int[] arr1 = new int[Integer.MAX_VALUE-2^28];
		
		Map<String, String> map = new HashMap<>();
		
		for(Entry<String,String> entry : map.entrySet()) {
			System.out.println(entry.getKey()+"  "+entry.getValue());
		}
		
		map.forEach((k,v)->{
			System.out.println(k+"  "+v);
		});
		
		String[] arr1 = {"s","hh","uuu"};
		String[] arr2 = null;
		new SetToArray().just(Optional.ofNullable(arr2));
		
		Long i = null;
		long j = 0;
		System.out.println(i+"  "+j);
	}
	
	void just(Optional<String[]> arr2) {
		
		System.out.println(arr2.isPresent());
		
		
		
	}
	
	
	 
	

}
