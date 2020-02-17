package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 
 * In a warehouse, there is a row of barcodes, where the i-th barcode is barcodes[i].

Rearrange the barcodes so that no two adjacent barcodes are equal.  You may return any answer, and it is guaranteed an answer exists.

 

Example 1:

Input: [1,1,1,2,2,2]
Output: [2,1,2,1,2,1]
Example 2:

Input: [1,1,1,1,2,2,3,3]
Output: [1,3,1,3,2,1,2,1]
 

Note:

1 <= barcodes.length <= 10000
1 <= barcodes[i] <= 10000

 * 
 * @author skadavath
 *
 */
public class DistantBarCodes {
	
	public static void main(String[] args) {
		
		System.out.println("   -42   ".trim());
		System.out.println(String.valueOf(12));
		System.out.println(Arrays.toString(new DistantBarCodes().rearrangeBarcodes(new int[] {1,1,1,1,2,2,3,3})));
		
	}
	
	public int[] rearrangeBarcodes(int[] barcodes) {
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int b : barcodes)
			map.put(b, map.getOrDefault(b, 0)+1);
		
		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b)->a.getValue()==b.getValue()?a.getKey()-b.getKey() : b.getValue()-a.getValue());
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			pq.add(entry);
		}
		
		int[] resp = new int[barcodes.length];
		int index = 0;
		while(!pq.isEmpty()) {
			
			int k=2;
			List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
			while(k>0 && !pq.isEmpty()) {
				
				Map.Entry<Integer, Integer> polled = pq.poll();
				polled.setValue(polled.getValue()-1);
				list.add(polled);
				resp[index++] = polled.getKey();
				k--;
			}
			
			for(Map.Entry<Integer, Integer> e : list) {
				if(e.getValue()>0)pq.offer(e);
			}
			
		}
		
		return resp;
		
	}

}
