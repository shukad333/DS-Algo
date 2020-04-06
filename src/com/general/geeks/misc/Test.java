package com.general.geeks.misc;

import java.util.*;
import java.util.stream.Collectors;

public class Test {
	
	public static void main(String[] args) throws InterruptedException {

		PriorityQueue<Integer[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);

		pq.add(new Integer[]{4,5});
		pq.add(new Integer[]{2,6});
		pq.add(new Integer[]{10,25});

		System.out.println(pq.peek()[0]);

		
		
	}

}
