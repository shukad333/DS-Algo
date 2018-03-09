package com.general.geeks.misc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PairSum {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5,6,7};
		int[] op = hasSum(arr, 10);
		System.out.println(op);
		for(int i :op) {
			System.out.println(i+" ");
		}
		
	}
	
	public static int[] hasSum(int[] nums,int target) {
		Map<Integer,Integer> comp = new HashMap();
		for(int i=0;i<nums.length;i++) {
			if(comp.get(target-nums[i])!=null) {
				return new int[] {comp.get(target-nums[i]),i};
			}
			comp.put(nums[i],i);
		}
		return null;
	}
}
