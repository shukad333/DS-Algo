package com.general.geeks.misc;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
	
	public static void main(String[] args) throws InterruptedException {

		int[] arr = {1,1,1,1};
		System.out.println(Arrays.binarySearch(arr,1));
		char[] c = {'a','1','b'};
		System.out.println(((char)(c[0]+Integer.parseInt(c[1]+""))));

		//PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

//		int[][] orders = {{8,1},{4,2},{5,6},{3,1},{4,3}};
//		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->((a[1]+a[2])-(b[1]+b[2])));
//
//		int i=0;
//		for(int[] o : orders) {
//			pq.offer(new int[]{i++,o[0],o[1]});
//		}
//
//		System.out.println(pq.peek()[1]+" ccc "+pq.peek()[2]);;
//
//		while(!pq.isEmpty()) {
//			int[] c = pq.poll();
//			System.out.println(c[1]+"   ccc  "+c[2]);;
//		}
//
//		char[] s1 = {'a'};
//		char[] s2 = {'a'};
//		List<Integer> list = Arrays.asList(1,2);


//		pq.add(new Integer[]{4,5});
//		pq.add(new Integer[]{2,6});
//		pq.add(new Integer[]{10,25});
//
//		System.out.println(pq.peek()[0]);

		
		
	}

}
