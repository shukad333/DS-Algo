package com.designpatterns.dp.proxy.sarakk;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Sarakk1 {
	
	Map<Integer, Integer> cache = new HashMap<>();
	
	public static void main(String[] args) {
		
		
		
		System.out.println(new Sarakk1().getTheMax(2, 1000000000));
		
	}
	
	private int getTheMax(int start,int end) {
		
		int startIndex = (int)Math.floor(Math.sqrt(start));
		int endIndex = (int)Math.ceil(Math.sqrt(end));
		
		
		
		for(int i=startIndex;i<=endIndex;i++) {
			
			
			int maxPossible = getTheMaxSquarePossible(i);
			cache.put(i, maxPossible+1);
		}
		
		int max = Integer.MIN_VALUE;
		for(int x : cache.values()) {
			max = Math.max(x, max);
		}
		
		for(Map.Entry<Integer, Integer> ent : cache.entrySet()) {
			if(ent.getValue()>1) {
				System.out.println(ent.getKey()+"--->"+ent.getValue());
			}
		}
		return max;
	}
	
	
	private int getTheMaxSquarePossible(int n) {
		
		if(n==1 || Math.floor(Math.sqrt(n)) != Math.ceil(Math.sqrt(n)))
			return 0;
		return 1+getTheMaxSquarePossible(((int)Math.sqrt(n)));
	}

}
