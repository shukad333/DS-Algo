package com.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TwoSum {
	
	public static void main(String[] args) {
		
		System.out.println(new TwoSum().twoSum(Arrays.asList(4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8), -3));
		
	}
	
	 public ArrayList<Integer> twoSum(final List<Integer> a, int b) {
	        
	        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        for(int i=0;i<a.size();i++) {
	            
	            if(!map.containsKey(a.get(i))) {
	                
	               map.put(a.get(i), i+1);
	            }
	            
	        }
	        
	        int minY = Integer.MAX_VALUE;
	        int minX = Integer.MIN_VALUE;
	        
	        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)-> y[1]==x[1]?x[0]-y[0]:(x[1]-y[1]));
	        
	        for(int i=0;i<a.size()/2;i++) {
	            if(map.containsKey(b-a.get(i))) {
	                pq.add(new int[]{i+1,map.get(b-a.get(i))});        
	                
	            }
	        }
	        int[] resp = pq.poll();
	        list.add(resp[1]);
	        list.add(resp[0]);
	        
	        return list;
	        
	    }

}
