package com.designpatterns.dp.design;

import java.util.HashMap;
import java.util.Map;

public class Test {
	
	public static void main(String[] args) {

		Map<Integer,Map<Integer,Integer>> map = new HashMap<>();
		Map<Integer,Integer> m = new HashMap<>();
		m.put(0,0);
		map.put(0,m);
		while(map.size()!=0) {
			Map<Integer,Integer> m1 = map.getOrDefault(map.size()-1,new HashMap<>());
			m1.putIfAbsent(m1.size(),m1.size());

			map.put(map.size()+1,m);
			System.out.println(map);
		}
		
	}

}
